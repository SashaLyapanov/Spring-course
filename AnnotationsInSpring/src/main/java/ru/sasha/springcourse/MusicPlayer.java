package ru.sasha.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    List<Music> musicList = new ArrayList<>();

    public MusicPlayer(List<Music> musicList) {
           this.musicList = musicList;
    }

    public String playMusic() {
        Random random = new Random();
        int randomNum = random.nextInt(musicList.size());
        return musicList.get(randomNum).getSong() + " with volume: " + this.volume;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }
    public void setVolume() {
        this.volume = volume;
    }
}