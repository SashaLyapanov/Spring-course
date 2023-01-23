package ru.sasha.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestSpring {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        MusicPlayer musicPlayer = applicationContext.getBean("musicPlayer", MusicPlayer.class);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Выберите, какой жанр вы бы хотели прослушать? \n" +
                    "1: Классика\n" +
                    "2: Джаз\n" +
                    "3: Рок-н-рол");

            int fact = Integer.parseInt(bufferedReader.readLine());
            if (fact == 1) {
                System.out.println(musicPlayer.playMusic(Genres.Classic));
            } else if (fact == 2) {
                System.out.println(musicPlayer.playMusic(Genres.Jazz));
            } else if (fact == 3) {
                System.out.println(musicPlayer.playMusic(Genres.Rock));
                break;
            }
        }
        applicationContext.close();

    }
}
