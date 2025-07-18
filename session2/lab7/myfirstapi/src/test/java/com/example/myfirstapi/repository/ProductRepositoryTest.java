package com.example.myfirstapi.repository;

import com.example.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository productRepository;

    @BeforeEach
    void setup(){
        productRepository = new ProductRepository();
    }

    @Test
    void findAll() {
        List<Product> products = productRepository.findAll();
        assertFalse(productRepository.findAll().isEmpty());
        assertEquals(3, products.size());
    }

    @Test
    void findById() {
        Optional<Product> product = productRepository.findById(1L);
        assertTrue(product.isPresent());
        assertEquals("Laptop", product.get().getName());
    }

    @Test
    void testSaveNullId() {
        Product newProduct = new Product("Memory card", 500.00);
        Product saveProduct = productRepository.save(newProduct);

        assertEquals("Memory card", saveProduct.getName());
        assertEquals(4, productRepository.findAll().size());
    }

    @Test
    void testUpdate(){
        Product existingProduct = new Product(1L, "Laptop", 1500.00);
        Product updateProduct = productRepository.save(existingProduct);

        assertEquals(updateProduct, productRepository.findById(1L).get());
    }

    @Test
    void testNoProduct(){
        Product product = new Product(5L, "RAM", 2500.00);
        Product notProduct = productRepository.save(product);

        assertEquals(notProduct, product);
        assertEquals("RAM", notProduct.getName());

        assertThrows(NoSuchElementException.class, () -> productRepository.findById(5L).get());
    }
}