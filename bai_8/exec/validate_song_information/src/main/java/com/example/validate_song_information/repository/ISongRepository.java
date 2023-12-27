package com.example.validate_song_information.repository;

import com.example.validate_song_information.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface ISongRepository extends CrudRepository<Song,Integer> {
}
