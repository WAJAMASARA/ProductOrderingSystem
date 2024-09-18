package com.syscosummit.product_service.service;

import com.syscosummit.product_service.dto.ProductRequest;
import com.syscosummit.product_service.dto.ProductRespond;
import com.syscosummit.product_service.exception.ProductNotFoundException;
import com.syscosummit.product_service.model.Product;
import com.syscosummit.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void createProduct(ProductRequest productRequest) {
        try {
            Product product = Product.builder()
                    .product_name(productRequest.getProduct_name())
                    .product_description(productRequest.getProduct_description())
                    .product_price(productRequest.getProduct_price())
                    .build();

            productRepository.save(product);
            log.info("Product created with ID: {}", product.getId());
        } catch (Exception e) {
            log.error("Error occurred while creating product", e);
            throw e; // rethrow the exception if needed
        }
    }

    public List<ProductRespond> getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            return products.stream()
                    .map(this::mapToProductResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error occurred while retrieving all products", e);
            throw e;
        }
    }

    public ProductRespond getProductById(Long id) {
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
            return mapToProductResponse(product);
        } catch (Exception e) {
            log.error("Error occurred while retrieving product with ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public void updateProduct(Long id, ProductRequest productRequest) {
        try {
            Product existingProduct = productRepository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

            // Update product details
            existingProduct.setProduct_name(productRequest.getProduct_name());
            existingProduct.setProduct_description(productRequest.getProduct_description());
            existingProduct.setProduct_price(productRequest.getProduct_price());

            // Save the updated product
            productRepository.save(existingProduct);
            log.info("Product updated with ID: {}", id);
        } catch (Exception e) {
            log.error("Error occurred while updating product with ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public void deleteProduct(Long id) {
        try {
            if (!productRepository.existsById(id)) {
                throw new ProductNotFoundException("Cannot delete, Product not found with ID: " + id);
            }
            productRepository.deleteById(id);
            log.info("Product deleted with ID: {}", id);
        } catch (Exception e) {
            log.error("Error occurred while deleting product with ID: {}", id, e);
            throw e;
        }
    }

    private ProductRespond mapToProductResponse(Product product) {
        return ProductRespond.builder()
                .product_id(product.getId())
                .product_name(product.getProduct_name())
                .product_description(product.getProduct_description())
                .product_price(product.getProduct_price())
                .build();
    }
}
