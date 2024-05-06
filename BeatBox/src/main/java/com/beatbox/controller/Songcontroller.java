package com.beatbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.beatbox.entity.Song;
import com.beatbox.service.Songservice;

@Controller
public class Songcontroller {
 
	
	@Autowired
	Songservice songservice;
	
	@PostMapping("/addsongs")
	public String addsong(@ModelAttribute Song song) {
		
		String name = song.getName();
		boolean songExits=songservice.songExits(name);
		if(songExits==false) {
			
			songservice.savesong(song);
		}else {
		   System.out.println("Duplicate entry");	
		}
		return "adminhome";
		
	}
	
	@GetMapping("/playsongs")
	public String playsongs(Model model) {
	    boolean premium = true; 
	    if (premium) {
	        List<Song> songList = Songservice.fetchAllSongs(); 
	        model.addAttribute("songs", songList);
	        System.out.println(songList); 
	        return "viewsongs"; 
	    } else {
	        return "pay"; 
	    }
	}
	
	
	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
	    
	    
	        List<Song> songList = Songservice.fetchAllSongs(); 
	        model.addAttribute("songs", songList);
	        System.out.println(songList); 
	        return "viewsongs"; 
	  
	}

	}
	

