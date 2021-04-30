package com.backend.main.service;

import java.util.List;

import com.backend.main.model.ProductDetailsModel;
import com.backend.main.model.ProductModel;

public interface ProductService {

	public List<ProductModel> getAllproducts() throws Exception;
	public ProductModel getProduct(int productId) throws Exception;
	public void updateProduct(ProductModel productModel) throws Exception;
	public void saveProduct(ProductDetailsModel productDetailsModel) throws Exception;
	public void deleteProduct(long productId) throws Exception;
	public List<ProductModel> getCartProducts(String email, List<Long> productId) throws Exception;
	
}
