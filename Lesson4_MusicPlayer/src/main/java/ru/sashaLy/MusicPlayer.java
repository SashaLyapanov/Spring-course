package ru.sashaLy;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    //создаем общий для всех жанров музыки интерфейс
    private List<Music> musicList = new ArrayList<>();
    private String name;
    private int volume;

    public String str = "";

    //Пустой конструктор
    public MusicPlayer() {
    }

//    public void setMusic(List<Music> musicList) {
//        this.musicList = musicList;
//    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getMusicList() {
        for (Music music: musicList) {
            str += music.getSong() + ", ";
        };
        return str;
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
        System.out.println("Playing: " + this.getMusicList());
    }


}
