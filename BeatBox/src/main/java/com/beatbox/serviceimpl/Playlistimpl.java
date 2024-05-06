package com.beatbox.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beatbox.entity.Playlist;
import com.beatbox.repositoty.Playlistrepository;
import com.beatbox.service.Playlistservice;

@Service
public class Playlistimpl implements Playlistservice {
	
	@Autowired
	Playlistrepository playlistrepository;

	@Override
	public void addplaylist(Playlist playlist) {
		Playlist exiplaylist=playlistrepository.findByName(playlist.getName());
		// TODO Auto-generated method stub
		if(exiplaylist==null) {
		playlistrepository.save(playlist);
		}else {
			System.out.println("Alredy exits");
		}
		
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		// TODO Auto-generated method stub
		List<Playlist> all = playlistrepository.findAll();
		return all ;
	}

	

}
