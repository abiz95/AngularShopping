package com.backend.main.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.main.DAO.UserDAO;
import com.backend.main.Repository.UserRepository;
import com.backend.main.entity.UserEntity;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> getAllUsers() throws Exception {
		return userRepository.findAll();
	}
	public void saveUser(UserEntity userEnt) throws Exception {
		userRepository.save(userEnt);
	}
	public UserEntity UserAuthentication(String email, String password) throws Exception {
		return userRepository.findByEmailAndPassword(email, password);
	}
}
