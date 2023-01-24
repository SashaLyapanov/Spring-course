package ru.sasha.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;


public class TestSpring {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        MusicPlayer musicPlayer1 = applicationContext.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer1.playMusic());



        applicationContext.close();

    }
}
