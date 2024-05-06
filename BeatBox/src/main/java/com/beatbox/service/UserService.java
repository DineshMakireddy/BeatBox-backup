package com.beatbox.service;

import org.springframework.stereotype.Service;

import com.beatbox.entity.User;

@Service
public interface UserService {

	
	void saveuser(User user);

	boolean emailExit(User user);

	boolean validUser(String email, String password);

	String getRole(String email);

	User getUser(String mail);

	void updateUser(User user);

	

}
