package org.kurolek.demo.springboot.demoecommerce.dao;

import org.kurolek.demo.springboot.demoecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {
}
