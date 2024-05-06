package com.beatbox.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beatbox.entity.User;
import com.beatbox.repositoty.UserRepository;
import com.beatbox.service.UserService;


@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userrepository;
 
	

	@Override
	public void saveuser(User user) {
		// TODO Auto-generated method stub
		userrepository.save(user);
	}



	@Override
	public boolean emailExit(User user) {
		// TODO Auto-generated method stub
		User existinguser =userrepository.findByEmail(user.getEmail());
		if(existinguser != null) {
			System.out.println("present");
			return true;
		}else {
			System.out.println("absent");
			return false;
		}
		
		
	}



	@Override
	public boolean validUser(String email, String password) {
		 User user = userrepository.findByEmail(email);
		
		 String dbpwd = user.getPassword();
		 
		 if(password.equals(dbpwd)) {
			 return true;
		 }else {
			 
			 return false;
		 }
	}



	@Override
	public String getRole(String email) {
	 
		User user = userrepository.findByEmail(email);
		return user.getRole();
	}



	@Override
	public User getUser(String mail) {
		return userrepository.findByEmail(mail);
	}



	@Override
	public void updateUser(User user) {
		userrepository.save(user);
		
	}

}
