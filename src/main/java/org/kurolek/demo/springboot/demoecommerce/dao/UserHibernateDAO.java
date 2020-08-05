package org.kurolek.demo.springboot.demoecommerce.dao;

import org.kurolek.demo.springboot.demoecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHibernateDAO extends JpaRepository<User, Long> {
    User findUserByName(String name);
}
