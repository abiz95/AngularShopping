package com.backend.main.service;

import java.util.ArrayList;
import java.util.List;

import com.backend.main.model.UserDetailModel;
import com.backend.main.model.UserModel;

public interface UserService {

	public List<UserModel> getAllUsers() throws Exception;
	public void saveUser(UserDetailModel userDetailModel) throws Exception;
	public void saveAdminUser(UserModel userModel) throws Exception;
	public ArrayList<String> UsersAuthentication(UserModel userModel) throws Exception;
}
