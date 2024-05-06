package com.beatbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.beatbox.entity.Playlist;
import com.beatbox.entity.Song;
import com.beatbox.service.Playlistservice;
import com.beatbox.service.Songservice;

@Controller
public class Playlistcontroller {

	@Autowired
	Playlistservice playlistservice;

	@Autowired
	Songservice songservice;

	@GetMapping("/createplaylists")
	public String createplaylist(Model model) {      // model is used to get the data from the backend
		List<Song> songList = Songservice.fetchAllSongs();
		model.addAttribute("songs",songList);

		return "createplaylist";

	}

	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		playlistservice.addplaylist(playlist);
		
		List<Song> songs = playlist.getSongs();
		
		for(Song song:songs) {
		   song.getPlaylists().add(playlist);
		   songservice.updateSong(song);
		}
		return "adminhome";
	}

	
	@GetMapping("/viewplaylist")
	
	public String viewplaylist(Model model) {
	List<Playlist> allplaylist =playlistservice.fetchAllPlaylists();
	  model.addAttribute("playlists",allplaylist);
		return "viewplaylist";
		
	}
}
