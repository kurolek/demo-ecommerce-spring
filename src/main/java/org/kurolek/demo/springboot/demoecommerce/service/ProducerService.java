package org.kurolek.demo.springboot.demoecommerce.service;


import org.kurolek.demo.springboot.demoecommerce.dao.AddressHibernateDAO;
import org.kurolek.demo.springboot.demoecommerce.dao.ProducerHibernateDAO;
import org.kurolek.demo.springboot.demoecommerce.entity.Address;
import org.kurolek.demo.springboot.demoecommerce.entity.Producer;
import org.kurolek.demo.springboot.demoecommerce.model.ProducerModel;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProducerService {

    @Autowired
    private ProducerHibernateDAO producerDao;

    @Autowired
    private AddressHibernateDAO addressDao;

    public ResponseModel addProducer(ProducerModel producerModel) {
        //вставка сущности в качестве параметра через айди
        Optional<Address> addressOptional =
                addressDao.findById(producerModel.getAddress().getId());
        if (addressOptional.isPresent()) {
            Producer producer =
                    Producer.builder()
                            .name(producerModel.getName())
                            .address(addressOptional.get())
                            .build();
            producerDao.save(producer);
            return ResponseModel.builder()
                    .status("success")
                    .message("Producer added successful with name : " + producer.getName())
                    .build();
        }else {
            return ResponseModel.builder()
                    .status("fail")
                    .message("Address id not found")
                    .build();

    }

}

    public ResponseModel getProducerByName(String name){
        Producer producer = producerDao.findByName(name);
        if(producer!= null){
            ProducerModel producerModel = ProducerModel.builder()
                    .id(producer.getId())
                    .name(producer.getName())

                    .build();
            return ResponseModel.builder()
                    .status("success")
                    .message("producer with name " + name + " was found")

                    .build();
        }else {
            return ResponseModel.builder()
                    .status("failed")
                    .message("error - producer with name " + name + " was not found")
                    .build();
        }
    }

}
