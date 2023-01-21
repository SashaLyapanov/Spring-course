package ru.sasha.springcourse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    public String name;
    public int volume;

    private List<Music> musicList = new ArrayList<>();

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void play() {
        for (Music music: musicList) {
            System.out.println("Играеееет: " + music.getSong());
        }
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return volume;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}