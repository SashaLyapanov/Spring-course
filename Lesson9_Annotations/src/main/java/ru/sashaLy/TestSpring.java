package ru.sashaLy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //создаем контекст приложения (context), который будет хранить конфигурационный файл, в котором прописаны наши бины.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//      Т.к. в конфигурационном файле был создан бин musicPlayer, который в конструкторе ссылается на другой бин (конкретно
//      на какой-либо тип музыки, следует, что мы можем напрямую через контекст получить получившийся бин (объект) без зависимостей.
        Music music1 = context.getBean("classicalMusic", Music.class);
        Music music2 = context.getBean("rockMusic", Music.class);
        Music music3 = context.getBean("jazzMusic", Music.class);

        MusicPlayer musicPlayer1 = new MusicPlayer(music1);
        musicPlayer1.playMusic();

        MusicPlayer musicPlayer2 = new MusicPlayer(music2);
        musicPlayer2.playMusic();

        MusicPlayer musicPlayer3 = new MusicPlayer(music3);
        musicPlayer3.playMusic();


//        Обязательное закрытие контекста
        context.close();


    }
}
