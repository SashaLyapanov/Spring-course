package ru.sashaLy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //создаем контекст приложения (context), который будет хранить конфигурационный файл, в котором прописаны наши бины.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//      Т.к. в конфигурационном файле был создан бин musicPlayer, который в конструкторе ссылается на другой бин (конкретно
//      на какой-либо тип музыки, следует, что мы можем напрямую через контекст получить получившийся бин (объект) без зависимостей.
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());
//        Обязательное закрытие контекста
        context.close();


    }
}
