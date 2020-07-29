package org.kurolek.demo.springboot.demoecommerce.dao;

import org.kurolek.demo.springboot.demoecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressHibernateDAO extends JpaRepository<Address, Long> {
    List<Address> getAddressesByCountry(String countryName);


}
