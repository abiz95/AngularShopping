package com.backend.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.main.model.UserDetailModel;
import com.backend.main.model.UserModel;
import com.backend.main.service.UserService;
import com.sun.net.httpserver.Authenticator.Success;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	static final Logger logger = LoggerFactory.getLogger(UserController.class);	
	
	@GetMapping(path="/helloworld")
	public String hello() {
		return "helloworld";
	}
	
	@GetMapping("/users")
    public ResponseEntity<?> getUsers() {
       
		List<UserModel> userList = null;
        try {
        	userList = userService.getAllUsers();
            logger.info("[UserController] [getUsers] getting user details");
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[UserController] [getUsers] error occured while retriving user details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
	
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDetailModel userDetailModel) {
       
        try {
        	userService.saveUser(userDetailModel);
            logger.info("[UserController] [saveUser] saving user details...");
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[UserController] [saveUser] error occured while saving user details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Success>(HttpStatus.OK);
    }
    
    @PostMapping("/AdminRegister")
    public ResponseEntity<?> saveAdminUser(@RequestBody UserModel userModel) {
       
        try {
        	userService.saveAdminUser(userModel);
            logger.info("[UserController] [saveAdminUser] saving admin user details...");
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[UserController] [saveAdminUser] error occured while saving admin user details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Success>(HttpStatus.OK);
    }
    
	@PostMapping("/login")
    public ResponseEntity<?> getUserAuthentication(@RequestBody UserModel userModel) {
       
		ArrayList<String> loginUser = null;
        try {
        	logger.info("[UserController] [getUserAuthentication] user details: "+userModel.getEmail()+" :: "+userModel.getPassword());
        	loginUser = userService.UsersAuthentication(userModel);
            logger.info("[UserController] [getUserAuthentication] getting user details");
            if (loginUser.contains("failed")) {
            	logger.error("[UserController] [getUserAuthentication] unauthorized access");
            	return new ResponseEntity<>(loginUser,HttpStatus.UNAUTHORIZED);
			}
           
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("[UserController] [getUserAuthentication] error occured while retriving user details"+e);
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }
}
