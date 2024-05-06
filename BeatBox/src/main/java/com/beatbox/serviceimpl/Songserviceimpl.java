package com.beatbox.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beatbox.entity.Song;
import com.beatbox.repositoty.Songrepository;
import com.beatbox.service.Songservice;

@Service
public class Songserviceimpl implements Songservice {
	
	@Autowired
	Songrepository songrepository;

	@Override
	public void savesong(Song song) {
		// TODO Auto-generated method stub
		songrepository.save(song);
		
	}

	@Override
	public boolean songExits(String name) {
		Song song = songrepository.findByName(name);
		if(song != null) {
			
			return true;
		}else {
			return false;
		}
	}

	public List<Song> fetchAllSongs() {
		
		List<Song> songs = songrepository.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song song) {
		// TODO Auto-generated method stub
		songrepository.save(song);
		
	}

}
