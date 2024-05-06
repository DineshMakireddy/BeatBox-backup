package com.beatbox.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beatbox.entity.Playlist;

@Repository
public interface Playlistrepository extends JpaRepository<Playlist, Integer> {

	Playlist findByName(String name);

	

     
}
