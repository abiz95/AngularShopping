package com.backend.main.DAO;

import java.util.List;

import com.backend.main.entity.ProductEntity;

public interface ProductDAO {

	public List<ProductEntity> getAllProducts() throws Exception;
	public ProductEntity getProduct(long productId) throws Exception;
	public void saveProduct(ProductEntity prdEnt) throws Exception;
	public void deleteProduct(long productId) throws Exception;
}

