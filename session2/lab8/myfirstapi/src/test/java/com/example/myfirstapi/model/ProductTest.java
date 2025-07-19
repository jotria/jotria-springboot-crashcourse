package com.example.myfirstapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;
    Product product1;

    @BeforeEach
    void setUp(){
        product = new Product(1L, "Demo", 1500.00);
        product1 = new Product("JUnit Test", 500.00);
    }

    @Test
    void testGetId(){
        long id = product.getId();
        assertEquals(1L, id);
    }

    @Test
    void testGetIdBySetId(){
        product.setId(2L);
        assertEquals(2L, product.getId());
    }

    @Test
    void testGetName() {
        String name = product.getName();
        assertEquals("Demo", name);
    }

    @Test
    void testGetNameNoID() {
        assertEquals("JUnit Test", product1.getName());
    }

    @Test
    void testGetNameBySetName(){
        product.setName("Test");
        assertEquals("Test", product.getName());
    }

    @Test
    void testGetPrice() {
        double price = product.getPrice();
        assertEquals(1500.00, price);
    }

    @Test
    void testGetPriceNoID() {
        assertEquals(500.00, product1.getPrice());
    }

    @Test
    void testGetPriceBySetPrice(){
        product.setPrice(2500.00);
        assertEquals(2500.00, product.getPrice());
    }

    @Test
    void testToString(){
        String expectedString = "Product{id=1, name='Demo', price=1500.0}";
        String actualString = product.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    void testEquals(){
        Product product2 = new Product(1L, "Demo", 1500.00);
        assertTrue(product2.equals(product));
    }

    @Test
    void testHashCode(){
        int hashCode = Objects.hash(1L, "Demo", 1500.00);
        assertEquals(hashCode, product.hashCode());

        // or
        System.out.println(product.hashCode());
        assertEquals(1149613693, product.hashCode());

    }
}