package com.backend.main.service;

import java.util.List;

import com.backend.main.model.CartDetailModel;
import com.backend.main.model.CartMetaModel;

public interface CartService {

	public List<CartDetailModel> getUserCarts(String email) throws Exception;
	public void purchaseProduct(CartDetailModel cartDetailModel) throws Exception;
	public void saveUserCart(CartMetaModel cartMetaModel) throws Exception;
	public CartDetailModel getCartDetails(long cartId) throws Exception;
	public void deleteCart(long cartId) throws Exception;
	
}
