package com.example.validate_song_information.service;

import com.example.validate_song_information.model.Song;

import java.util.Optional;

public interface ISongService {
    Iterable<Song> findAll();

    void save(Song song);

    Optional<Song> findById(Integer id);
}
