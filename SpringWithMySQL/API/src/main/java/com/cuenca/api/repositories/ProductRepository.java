package com.cuenca.api.repositories;

import com.cuenca.api.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
