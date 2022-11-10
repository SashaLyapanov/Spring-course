package ru.sashaLy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comparison = (firstMusicPlayer == secondMusicPlayer);

        firstMusicPlayer.playMusic();
        secondMusicPlayer.playMusic();

        System.out.println(comparison);

        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());

        firstMusicPlayer.setVolume(10);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());

        ClassicalMusic classicalMusic = context.getBean("classicalBean", ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());
        ClassicalMusic classicalMusic1 = context.getBean("classicalBean", ClassicalMusic.class);
        System.out.println(classicalMusic1.getSong());

//        ClassicalMusic classicalMusic = context.getBean("classicalBean", ClassicalMusic.class);
//        ClassicalMusic classicalMusic1 = context.getBean("classicalBean",ClassicalMusic.class);
//        System.out.println(classicalMusic);
//        System.out.println(classicalMusic1);
//        System.out.println(classicalMusic.getSong());



        context.close();
    }
}
