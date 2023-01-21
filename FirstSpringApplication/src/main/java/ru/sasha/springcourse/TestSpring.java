package ru.sasha.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestSpring {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");


        MusicPlayer musicPlayer1 = applicationContext.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = applicationContext.getBean("musicPlayer", MusicPlayer.class);

        boolean comparison = musicPlayer1 == musicPlayer2;
        System.out.println(comparison);
        System.out.println(musicPlayer1);
        System.out.println(musicPlayer2);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите название плеера:");
        musicPlayer1.name = bufferedReader.readLine();

        System.out.println("Введите громкость");
        musicPlayer1.volume = Integer.parseInt(bufferedReader.readLine());


        System.out.println("Вот теперь мы типо проигрываем музыку с плеера: " + musicPlayer1.name + " с громкостью: " + musicPlayer1.volume + " со следующей поочередностью: ");
        musicPlayer1.play();




        applicationContext.close();

    }
}
