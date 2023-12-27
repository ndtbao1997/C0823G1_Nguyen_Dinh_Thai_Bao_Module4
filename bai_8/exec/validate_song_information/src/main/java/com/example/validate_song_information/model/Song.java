package com.example.validate_song_information.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "song_infor")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Không được để trống")
    @Size(min = 10, max = 800, message = "Tên bài hát phải có độ dài từ 10-800 kí tự")
    @Pattern(regexp = "^[\\p{L}\\d ]+$", message = "Tên bài hát không được chứa kí tự đặc biệt")
    @Column(columnDefinition = "longtext")
    private String nameSong;

    @NotBlank(message = "Không được để trống")
    @Size(min = 10, max = 300, message = "Nghệ sĩ thể hiện phải có độ dài từ 10-300 kí tự")
    @Pattern(regexp = "^[\\p{L}\\d ]+$", message = "Không chứa các kí tự đặc biệt như @;,.=-+, ….")
    @Column(columnDefinition = "longtext")
    private String artistsExpress;

    @NotBlank(message = "Không được để trống")
    @Size(min = 10, max = 1000, message = "Thể loại âm nhạc phải có độ dài từ 10-1000 kí tự")
    @Pattern(regexp = "^[\\p{L}\\d ]+$", message = "Không chứa các kí tự đặc biệt như @;,.=-+, …. ngoại trừ dấu phẩy")
    @Column(columnDefinition = "longtext")
    private String kindOfMusic;

    public Song() {
    }

    public Song(Integer id, String nameSong, String artistsExpress, String kindOfMusic) {
        this.id = id;
        this.nameSong = nameSong;
        this.artistsExpress = artistsExpress;
        this.kindOfMusic = kindOfMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtistsExpress() {
        return artistsExpress;
    }

    public void setArtistsExpress(String artistsExpress) {
        this.artistsExpress = artistsExpress;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
