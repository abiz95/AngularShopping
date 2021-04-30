package com.backend.main.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.main.DAO.ProductDAO;
import com.backend.main.entity.ProductEntity;
import com.backend.main.model.ProductDetailsModel;
import com.backend.main.model.ProductModel;
import com.backend.main.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductModel> getAllproducts() throws Exception {
		
		ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
		List<ProductEntity> productData = productDAO.getAllProducts();
		for (ProductEntity productEntity : productData) {
			ProductModel productModel = new ProductModel();
			productModel.setProductId(productEntity.getProductId());
			productModel.setProductName(productEntity.getProductName());
			productModel.setProductDescription(productEntity.getProductDescription());
			productModel.setProductPrice(productEntity.getProductPrice());
			productList.add(productModel);
		}
		
		return productList;
	}
	
	public ProductModel getProduct(int productId) throws Exception {
		
		ProductEntity productData = productDAO.getProduct(productId);
		ProductModel productModel = new ProductModel();
		productModel.setProductId(productData.getProductId());
		productModel.setProductName(productData.getProductName());
		productModel.setProductDescription(productData.getProductDescription());
		productModel.setProductPrice(productData.getProductPrice());
		
		return productModel;
	}
	
	public void updateProduct(ProductModel productModel) throws Exception {
		
        java.util.Date CurrentDate = new Date();
        Date timeStamp = new java.sql.Timestamp(CurrentDate.getTime());
        
//        ProductEntity newProduct = new ProductEntity();
        ProductEntity productData = productDAO.getProduct(productModel.getProductId());
        productData.setProductName(productModel.getProductName());
        productData.setProductDescription(productModel.getProductDescription());
        productData.setProductPrice(productModel.getProductPrice());
        productData.setUpd_rec_ts(timeStamp);
		
        productDAO.saveProduct(productData);
	}
	
	public void saveProduct(ProductDetailsModel productDetailsModel) throws Exception {
		
        java.util.Date CurrentDate = new Date();
        Date timeStamp = new java.sql.Timestamp(CurrentDate.getTime());
        
        ProductEntity newProduct = new ProductEntity();
        newProduct.setProductName(productDetailsModel.getProductName());
        newProduct.setProductDescription(productDetailsModel.getProductDescription());
        newProduct.setProductPrice(productDetailsModel.getProductPrice());
        newProduct.setProductDate(timeStamp);
        newProduct.setCre_rec_ts(timeStamp);
        newProduct.setUpd_rec_ts(timeStamp);
		
        productDAO.saveProduct(newProduct);
	}
	
	public void deleteProduct(long productId) throws Exception {
		
		productDAO.deleteProduct(productId);
		
	}
	
	public List<ProductModel> getCartProducts(String email, List<Long> productId) throws Exception {
		
		ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
		for (Long productIdData : productId) {
			ProductEntity productData = productDAO.getProduct(productIdData);
			ProductModel productModel = new ProductModel();
			productModel.setProductId(productData.getProductId());
			productModel.setProductName(productData.getProductName());
			productModel.setProductDescription(productData.getProductDescription());
			productModel.setProductPrice(productData.getProductPrice());
			productList.add(productModel);
		}
//		List<ProductEntity> productData = productDAO.getAllProducts();
//		for (ProductEntity productEntity : productData) {
//			ProductModel productModel = new ProductModel();
//			productModel.setProductId(productEntity.getProductId());
//			productModel.setProductName(productEntity.getProductName());
//			productModel.setProductDescription(productEntity.getProductDescription());
//			productModel.setProductPrice(productEntity.getProductPrice());
//			productList.add(productModel);
//		}
		
		return productList;
	}
}
