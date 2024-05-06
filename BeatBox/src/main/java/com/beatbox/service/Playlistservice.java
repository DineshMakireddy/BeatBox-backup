package com.beatbox.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beatbox.entity.Playlist;

@Service
public interface Playlistservice {

	
	void addplaylist(Playlist playlist);

	List<Playlist> fetchAllPlaylists();

	

	

}
