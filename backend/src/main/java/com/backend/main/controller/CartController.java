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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.main.model.CartDetailModel;
import com.backend.main.model.CartMetaModel;
import com.backend.main.service.CartService;
import com.sun.net.httpserver.Authenticator.Success;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CartController {

	@Autowired
	private CartService CartService;
	
	static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@GetMapping("/cart/{email}")
    public ResponseEntity<?> getUserCarts(@PathVariable String email) {
       
		List<CartDetailModel> cartData = null;
        try {
        	cartData = CartService.getUserCarts(email);
            logger.info("[CartController] [getUserCarts] getting all cart details: "+email);
           
        }catch (NullPointerException e) {
            // TODO: handle exception
            logger.info("[CartController] [getUserCarts] no cart under user: "+email+" :: exception: "+e);
            return new ResponseEntity<>(cartData, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[CartController] [getUserCarts] error occured while retriving cart detail"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        } 
        return new ResponseEntity<>(cartData, HttpStatus.OK);
    }
	
    @PostMapping("/saveCart")
    public ResponseEntity<?> saveCart(@RequestBody CartMetaModel CartMetaModel) {
       
        try {

        	CartService.saveUserCart(CartMetaModel);
            logger.info("[CartController] [saveCart] saving cart details...");
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[CartController] [saveCart] error occured while saving cart details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Success>(HttpStatus.OK);
    }
    
    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseProduct(@RequestBody CartDetailModel CartMetaModel) {
       
        try {

        	CartService.purchaseProduct(CartMetaModel);
            logger.info("[CartController] [purchaseProduct] purchasing product...");
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[CartController] [purchaseProduct] error occured while saving purchase details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Success>(HttpStatus.OK);
    }
    
	@GetMapping("/checkout/{cartId}")
    public ResponseEntity<?> checkoutCarts(@PathVariable long cartId) {
       
		CartDetailModel cartData = null;
        try {
        	cartData = CartService.getCartDetails(cartId);
            logger.info("[CartController] [checkoutCarts] getting cart details for card Id: "+cartId);
           
        }catch (NullPointerException e) {
            // TODO: handle exception
            logger.info("[CartController] [checkoutCarts] no cart under id: "+cartId+" :: exception: "+e);
            return new ResponseEntity<>(cartData, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[CartController] [checkoutCarts] error occured while retriving cart detail"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        } 
        return new ResponseEntity<>(cartData, HttpStatus.OK);
    }
	
    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<?> deleteProduct(@PathVariable long cartId) {
       
        try {

        	CartService.deleteCart(cartId);
            logger.info("[CartController] [deleteProduct] deleting the cart id: "+cartId);
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[CartController] [deleteProduct] error occured while deleting purchase details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Success>(HttpStatus.OK);
    }
	
}
