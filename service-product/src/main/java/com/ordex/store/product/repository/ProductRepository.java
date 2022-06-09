package com.ordex.store.product.repository;

import com.ordex.store.product.entity.Category;
import com.ordex.store.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findByCategory(Category category);
}
