package ru.sasha.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestSpring {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");


        MusicPlayer musicPlayer = applicationContext.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        Music classicalMusic1 = applicationContext.getBean("classicalMusic", Music.class);


        applicationContext.close();

    }
}
