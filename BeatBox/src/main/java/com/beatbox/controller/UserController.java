package com.beatbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beatbox.entity.Song;
import com.beatbox.entity.User;
import com.beatbox.service.Songservice;
import com.beatbox.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller

public class UserController {

	@Autowired
	UserService userservice;
    
	@Autowired
    Songservice songservice;

	@PostMapping("/register")
	public String userdata(@ModelAttribute User user) {


		//to check a user email is present or not
		boolean userExits = userservice.emailExit(user);
		if(userExits == false) {		
			userservice.saveuser(user);
			System.out.println("user addes sucess fully");
		}else {
			System.out.println("Duplicate user");
		}
		return "login";

	} 


	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession session, Model model) {

		if( userservice.validUser(email , password) == true) {
			
			session.setAttribute("email", email);
			
			 String role = userservice.getRole(email);								
			
			if(role.equals("Admin")) {
				return "adminhome";
			}else {
				User user =userservice.getUser(email);
				boolean userstatus = user.isPremium();
				List<Song> fetchAllSongs = Songservice.fetchAllSongs();
				model.addAttribute("songs", fetchAllSongs);
				
				model.addAttribute("ispremium", userstatus);
				return "customerhome";			}
		}else {

			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
		
	}
}
