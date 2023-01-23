package ru.sasha.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {
    private Music music1;
    private Music music2;
    private Music music3;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("classicalMusic") Music music2,
                       @Qualifier("jazzMusic") Music music3) {
        this.music1 = music1;
        this.music2 = music2;
        this.music3 = music3;
    }



    public String playMusic(Genres genres) {
        if(genres == Genres.Classic) {
            return "Playing: " + music2.getSong();
        } else if (genres == Genres.Jazz) {
            return "Playing: " + music3.getSong();
        } else {
            return "Playing: " + music1.getSong();
        }
    }
}