package com.backend.main.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.main.DAO.CartDAO;
import com.backend.main.Repository.CartRepository;
import com.backend.main.entity.CartEntity;

@Component
public class CartDAOImpl implements CartDAO {

	@Autowired
	private CartRepository cartRepository;
	
	public List<CartEntity> getUserCart(String email) throws Exception {
		return cartRepository.findByEmailAndStatusInd(email);
	}
	
	public CartEntity getCartById(long cartId) throws Exception {
		return cartRepository.findByCartId(cartId);
	}
	
	public void saveCart(CartEntity cartEnt) throws Exception {
		cartRepository.save(cartEnt);
	}
	
	public void deleteCart(long cartId) throws Exception {
		cartRepository.deleteByCartId(cartId);
	}
}
