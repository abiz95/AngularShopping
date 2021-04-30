package com.backend.main.DAO;

import java.util.List;

import com.backend.main.entity.CartEntity;

public interface CartDAO {

	public List<CartEntity> getUserCart(String email) throws Exception;
	public CartEntity getCartById(long cartId) throws Exception;
	public void saveCart(CartEntity cartEnt) throws Exception;
	public void deleteCart(long cartId) throws Exception;
}
