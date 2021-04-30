package com.backend.main.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.main.DAO.UserDAO;
import com.backend.main.entity.UserEntity;
import com.backend.main.model.UserDetailModel;
import com.backend.main.model.UserModel;
import com.backend.main.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public List<UserModel> getAllUsers() throws Exception {
		
		ArrayList<UserModel> userList = new ArrayList<UserModel>();
		List<UserEntity> userData = userDAO.getAllUsers();
		for (UserEntity userEntity : userData) {
			UserModel userModel = new UserModel();
			userModel.setEmail(userEntity.getEmail());
			userModel.setUsertype(userEntity.getUsertype());
			userModel.setPassword(userEntity.getPassword());
			userList.add(userModel);
		}
		
		return userList;
	}
	
	public void saveUser(UserDetailModel userDetailModel) throws Exception {
		
        java.util.Date CurrentDate = new Date();
        Date timeStamp = new java.sql.Timestamp(CurrentDate.getTime());
        
		UserEntity newUser = new UserEntity();
		newUser.setEmail(userDetailModel.getEmail());
		newUser.setPassword(userDetailModel.getPassword());
		newUser.setUsertype("client");
		newUser.setCre_rec_ts(timeStamp);
		newUser.setUpd_rec_ts(timeStamp);
		
		userDAO.saveUser(newUser);
	}
	
	public void saveAdminUser(UserModel userModel) throws Exception {
		
        java.util.Date CurrentDate = new Date();
        Date timeStamp = new java.sql.Timestamp(CurrentDate.getTime());
        
		UserEntity newUser = new UserEntity();
		newUser.setEmail(userModel.getEmail());
		newUser.setPassword(userModel.getPassword());
		newUser.setUsertype("admin");
		newUser.setCre_rec_ts(timeStamp);
		newUser.setUpd_rec_ts(timeStamp);
		
		userDAO.saveUser(newUser);
	}
	
	public ArrayList<String> UsersAuthentication(UserModel userModel) throws Exception {
		
//		String status;
		ArrayList<String> status = new ArrayList<String>();
		UserEntity loginUser = userDAO.UserAuthentication(userModel.getEmail(), userModel.getPassword());
		if (loginUser==null) {
			status.add("failed");
//			status="failed";
			return status;
		}
		if (userModel.getEmail().equals(loginUser.getEmail()) && userModel.getPassword().equals(loginUser.getPassword())) {
			status.add("success");
//			status="success";
		} else {
			status.add("failed");
//			status="failed";
		}
		return status;
	}
}
