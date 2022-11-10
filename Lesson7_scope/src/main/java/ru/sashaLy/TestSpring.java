package ru.sashaLy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //создаем контекст приложения (context), который будет хранить конфигурационный файл, в котором прописаны наши бины.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        после создания контекста мы можем получить из него наш бин. В следующей строке представлено создание экземпляра класса TestBean
//        через специальный метод получения бина из контекста
        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comparison = (firstMusicPlayer == secondMusicPlayer);
        System.out.println(comparison);
        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());
        firstMusicPlayer.setVolume(10);
        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());



//        Обязательное закрытие контекста
        context.close();


    }
}
