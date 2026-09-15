package com.learning.inventory.repository;

import com.learning.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA generates the implementation of this interface at runtime.
 * You get save(), findById(), findAll(), deleteById(), etc. for free — this
 * is dependency inversion at the framework level: your Service depends on
 * this abstraction, not on JDBC/Hibernate details.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByNameContainingIgnoreCase(@Param("name") String name);
}
