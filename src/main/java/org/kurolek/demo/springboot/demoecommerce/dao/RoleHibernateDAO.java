package org.kurolek.demo.springboot.demoecommerce.dao;

import org.kurolek.demo.springboot.demoecommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleHibernateDAO extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}