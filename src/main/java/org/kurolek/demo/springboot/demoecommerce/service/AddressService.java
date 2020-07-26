package org.kurolek.demo.springboot.demoecommerce.service;

import org.kurolek.demo.springboot.demoecommerce.dao.AddressHibernateDAO;
import org.kurolek.demo.springboot.demoecommerce.entity.Address;
import org.kurolek.demo.springboot.demoecommerce.model.AddressModel;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressHibernateDAO dao;

    public ResponseModel setAddress(AddressModel addressModel) {
        Address address =
                Address.builder()
                        .country(addressModel.getCountry())
                        .city(addressModel.getCity())
                        .postalCode(addressModel.getPostalCode())
                        .street(addressModel.getStreet())
                        .build();
        dao.save(address);
        return ResponseModel.builder()
                .status("success")
                .message("Address set successful with postal code : " + address.getPostalCode())
                .build();
    }

    public ResponseModel getAddressesByCountry(String country) {
        List<Address> addresses = dao.getAddressesByCountry(country);
        List<AddressModel> addressModels = addresses.stream().map((a) ->
                AddressModel.builder()
                        .id(a.getId())
                        .country(a.getCountry())
                        .city(a.getCity())
                        .street(a.getStreet())
                        .postalCode(a.getPostalCode())
                        .build()
        ).collect(Collectors.toList());
        return ResponseModel.builder()
                .status("success")
                .data(addressModels)
                .build();
    }
}
