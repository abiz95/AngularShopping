package com.backend.main.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.main.DAO.CartDAO;
import com.backend.main.DAO.ProductDAO;
import com.backend.main.entity.CartEntity;
import com.backend.main.entity.ProductEntity;
import com.backend.main.model.CartDetailModel;
import com.backend.main.model.CartMetaModel;
import com.backend.main.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	public List<CartDetailModel> getUserCarts(String email) throws Exception {
		
		ArrayList<CartDetailModel> userCartList = new ArrayList<CartDetailModel>();
		List<CartEntity> userCartData = cartDAO.getUserCart(email);
		for (CartEntity cartEntity : userCartData) {
			ProductEntity productData = productDAO.getProduct(cartEntity.getProductId());
			CartDetailModel cartDetailModel = new CartDetailModel();
			cartDetailModel.setCartId(cartEntity.getCartId());
			cartDetailModel.setEmail(cartEntity.getEmail());
			cartDetailModel.setProductId(cartEntity.getProductId());
			cartDetailModel.setProductName(productData.getProductName());
			cartDetailModel.setProductDescription(productData.getProductDescription());
			cartDetailModel.setProductPrice(productData.getProductPrice());
			cartDetailModel.setQty(cartEntity.getQty());
			cartDetailModel.setStatus(cartEntity.getStatus());
			cartDetailModel.setTotalPrice(cartEntity.getTotalPrice());
			userCartList.add(cartDetailModel);
		}
		
		return userCartList;
	}
	
	public void purchaseProduct(CartDetailModel cartDetailModel) throws Exception {
		
        java.util.Date CurrentDate = new Date();
        Date timeStamp = new java.sql.Timestamp(CurrentDate.getTime());
        System.out.println("from UI cart Id: "+cartDetailModel.getCartId());
        CartEntity cartData = cartDAO.getCartById(cartDetailModel.getCartId());
//        CartEntity addCart = new CartEntity();
        cartData.setEmail(cartDetailModel.getEmail());
        cartData.setProductId(cartDetailModel.getProductId());
        cartData.setQty(cartDetailModel.getQty());
        cartData.setTotalPrice(cartDetailModel.getQty()*cartDetailModel.getProductPrice());
        cartData.setStatus(1);
        cartData.setUpd_rec_ts(timeStamp);
		
        cartDAO.saveCart(cartData);
	}
	
	public void saveUserCart(CartMetaModel cartMetaModel) throws Exception {
		
        java.util.Date CurrentDate = new Date();
        Date timeStamp = new java.sql.Timestamp(CurrentDate.getTime());
        
        CartEntity addCart = new CartEntity();
        addCart.setEmail(cartMetaModel.getEmail());
        addCart.setProductId(cartMetaModel.getProductId());
        addCart.setQty(cartMetaModel.getQty());
        addCart.setTotalPrice(cartMetaModel.getTotalPrice());
        addCart.setStatus(0);
        addCart.setUpd_rec_ts(timeStamp);
        addCart.setCre_rec_ts(timeStamp);
		
        cartDAO.saveCart(addCart);
	}
	
	
	public CartDetailModel getCartDetails(long cartId) throws Exception {
		
		CartEntity userCartData = cartDAO.getCartById(cartId);
		ProductEntity productData = productDAO.getProduct(userCartData.getProductId());
		CartDetailModel cartDetailModel = new CartDetailModel();
		cartDetailModel.setCartId(userCartData.getCartId());
		cartDetailModel.setEmail(userCartData.getEmail());
		cartDetailModel.setProductId(userCartData.getProductId());
		cartDetailModel.setProductName(productData.getProductName());
		cartDetailModel.setProductDescription(productData.getProductDescription());
		cartDetailModel.setProductPrice(productData.getProductPrice());
		cartDetailModel.setQty(userCartData.getQty());
		cartDetailModel.setStatus(userCartData.getStatus());
		cartDetailModel.setTotalPrice(userCartData.getTotalPrice());
		
		return cartDetailModel;
	}
	
	public void deleteCart(long cartId) throws Exception {
		
		cartDAO.deleteCart(cartId);
		
	}
}
