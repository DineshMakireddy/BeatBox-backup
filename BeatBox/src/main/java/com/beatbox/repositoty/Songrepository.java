package com.beatbox.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beatbox.entity.Song;

@Repository
public interface Songrepository  extends JpaRepository<Song, Integer>{

	Song findByName(String name);

	

}
