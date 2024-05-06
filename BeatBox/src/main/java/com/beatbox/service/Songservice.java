package com.beatbox.service;

import java.util.List;

import com.beatbox.entity.Song;

public interface Songservice {

	void savesong(Song song);

	boolean songExits(String name);

	static List<Song> fetchAllSongs() {
		// TODO Auto-generated method stub
		return null;
	}

	void updateSong(Song song);

}
