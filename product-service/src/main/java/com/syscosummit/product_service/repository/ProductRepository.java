package com.syscosummit.product_service.repository;

import com.syscosummit.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Repository interface for managing Product
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {
}
