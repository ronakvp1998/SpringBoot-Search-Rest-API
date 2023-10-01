package com.example.springboot.repository;

import com.example.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {


    // using JPQL Query
    @Query("SELECT p FROM Product p where " +
            "p.name LIKE CONCAT('%',:query,'%')"+
            " or p.description LIKE CONCAT('%',:query,'%')")

    List<Product> searchProducts(String query);

    // native SQL Query
    @Query(value = "SELECT * FROM products p where " +
            "p.name LIKE CONCAT('%',:query,'%')"+
            " or p.description LIKE CONCAT('%',:query,'%')",nativeQuery = true)

    List<Product> searchProductsSQL(String query);
}
