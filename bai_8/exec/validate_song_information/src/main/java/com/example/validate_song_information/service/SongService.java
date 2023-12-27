package com.example.validate_song_information.service;

import com.example.validate_song_information.model.Song;
import com.example.validate_song_information.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public Iterable<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return iSongRepository.findById(id);
    }
}
