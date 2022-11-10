package ru.sashaLy;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    //создаем общий для всех жанров музыки интерфейс
    private Music music;
    private String name;
    private int volume;

    public String str = "";

    //Пустой конструктор
    public MusicPlayer() {
    }

    public MusicPlayer(Music music) {
        this.music = music;
    }

//    public void setMusic(List<Music> musicList) {
//        this.musicList = musicList;
//    }

    public void setMusic(Music music) {
        this.music = music;
    }
    public String getMusic() {
        return this.music.getSong();
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

    public void setVolume(int volume) {
        this.volume = volume;
    }


    public void playMusic() {
        System.out.println("Playing: " + this.getMusic());
    }


}
