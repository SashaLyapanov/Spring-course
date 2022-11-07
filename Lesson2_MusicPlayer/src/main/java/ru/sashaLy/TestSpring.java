package ru.sashaLy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //создаем контекст приложения (context), который будет хранить конфигурационный файл, в котором прописаны наши бины.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        после создания контекста мы можем получить из него наш бин. В следующей строке представлено создание экземпляра класса TestBean
//        через специальный метод получения бина из контекста
        Music music = context.getBean("musicBean", Music.class);


        MusicPlayer musicPlayer = new MusicPlayer(music);
        musicPlayer.playMusic();

//        Обязательное закрытие контекста
        context.close();


    }
}
