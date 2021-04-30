package com.backend.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.main.model.ProductDetailsModel;
import com.backend.main.model.ProductModel;
import com.backend.main.service.ProductService;
import com.sun.net.httpserver.Authenticator.Success;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	static final Logger logger = LoggerFactory.getLogger(ProductController.class);	
	
	@GetMapping("/allProducts/")
    public ResponseEntity<?> getAllProducts() {
       
		List<ProductModel> productList = null;
        try {
        	productList = productService.getAllproducts();
            logger.info("[ProductController] [getAllProducts] getting all product details");
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[ProductController] [getAllProducts] error occured while retriving products details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
	
	@GetMapping("/products/{productId}")
    public ResponseEntity<?> getProducts(@PathVariable int productId) {
       
		ProductModel productData = null;
        try {
        	productData = productService.getProduct(productId);
            logger.info("[ProductController] [getProducts] getting all product detail: "+productId);
           
        }catch (NullPointerException e) {
            // TODO: handle exception
            logger.info("[ProductController] [getProducts] no product under Id: "+productId+" :: exception: "+e);
            return new ResponseEntity<>(productData, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[ProductController] [getProducts] error occured while retriving products detail"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        } 
        return new ResponseEntity<>(productData, HttpStatus.OK);
    }
	
    @PutMapping("/updateProduct/")
    public ResponseEntity<?> updateProduct(@RequestBody ProductModel productModel) {
       
        try {

        	productService.updateProduct(productModel);
            logger.info("[ProductController] [updateProduct] update product details: ",productModel);
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[ProductController] [updateProduct] error occured while saving product details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Success>(HttpStatus.OK);
    }
    
    @PostMapping("/saveProduct/")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDetailsModel productDetailsModel) {
       
        try {

        	productService.saveProduct(productDetailsModel);
            logger.info("[ProductController] [saveProduct] saving product details...");
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[ProductController] [saveProduct] error occured while saving product details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Success>(HttpStatus.OK);
    }
    
	@DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> deleteProducts(@PathVariable long productId) {
		
        try {
        	productService.deleteProduct(productId);
            logger.info("[ProductController] [deleteProducts] deleting product detail: "+productId);
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[ProductController] [deleteProducts] error occured while deleting product detail"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@GetMapping("/cartProducts/{email}")
    public ResponseEntity<?> getCartProducts(@PathVariable String email, @RequestBody List<Long> productId) {
       
		List<ProductModel> productData = null;
        try {
        	productData = productService.getCartProducts(email, productId);
            logger.info("[ProductController] [getProducts] getting all product detail: "+productId);
           
        }catch (NullPointerException e) {
            // TODO: handle exception
            logger.info("[ProductController] [getProducts] no product under Id: "+productId+" :: exception: "+e);
            return new ResponseEntity<>(productData, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[ProductController] [getProducts] error occured while retriving products detail"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        } 
        return new ResponseEntity<>(productData, HttpStatus.OK);
    }
    
}
