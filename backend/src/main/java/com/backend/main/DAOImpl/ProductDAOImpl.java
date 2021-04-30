package com.backend.main.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.main.DAO.ProductDAO;
import com.backend.main.Repository.ProductRepository;
import com.backend.main.entity.ProductEntity;

@Component
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductEntity> getAllProducts() throws Exception {
		return productRepository.findAllByOrderByProductIdDesc();
	}
	
	public ProductEntity getProduct(long productId) throws Exception {
		return productRepository.findByProductId(productId);
	}
	
	public void saveProduct(ProductEntity prdEnt) throws Exception {
		productRepository.save(prdEnt);
	}
	
	public void deleteProduct(long productId) throws Exception {
		productRepository.deleteByProductId(productId);
	}
	
}
