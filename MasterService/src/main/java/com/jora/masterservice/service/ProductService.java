package com.jora.masterservice.service;

import java.util.List;

import com.jora.masterservice.main.entity.Product;

public interface ProductService {

	List<Product> getAllProducts() throws Exception;

	Product save(Product product) throws Exception;

}
