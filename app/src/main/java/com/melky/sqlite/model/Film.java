package com.melky.sqlite.model;

public class Film {
    int id;
    String judul_film, genre;
    Integer tahun_release;

    public Film(int id, String judul_film, String genre, Integer tahun_release) {
        this.id = id;
        this.judul_film = judul_film;
        this.genre = genre;
        this.tahun_release = tahun_release;
    }

    public int getId() {
        return id;
    }

    public String getJudul_film() {
        return judul_film;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getTahun_release () {
        return tahun_release;
    }
}
