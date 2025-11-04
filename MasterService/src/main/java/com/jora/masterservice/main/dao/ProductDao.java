package com.jora.masterservice.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jora.masterservice.main.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
