package com.backend.main.DAO;

import java.util.List;

import com.backend.main.entity.UserEntity;

public interface UserDAO {

	public List<UserEntity> getAllUsers() throws Exception;
	public void saveUser(UserEntity userEnt) throws Exception;
	public UserEntity UserAuthentication(String email, String password) throws Exception;
}
