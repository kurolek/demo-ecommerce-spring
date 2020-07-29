package org.kurolek.demo.springboot.demoecommerce.dao;

import org.kurolek.demo.springboot.demoecommerce.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerHibernateDAO extends JpaRepository<Producer, Long> {
    Producer findByName(String name);
}
