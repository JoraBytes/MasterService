package com.jora.masterservice.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jora.masterservice.common.ErrorHandler;
import com.jora.masterservice.main.dao.ProductDao;
import com.jora.masterservice.main.entity.Product;
import com.jora.masterservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;

	private final Logger log = LogManager.getLogger(getClass());

	@Override
	public List<Product> getAllProducts() throws Exception {
		try {
			return productDao.findAll();
		} catch (Exception e) {
			log.error(ErrorHandler.errorTraceForLogger(e));
			throw e;
		}
	}

	@Override
	public Product save(Product product) throws Exception {
		try {
			return productDao.save(product);
		} catch (Exception e) {
			log.error(ErrorHandler.errorTraceForLogger(e));
			throw e;
		}
	}

}
