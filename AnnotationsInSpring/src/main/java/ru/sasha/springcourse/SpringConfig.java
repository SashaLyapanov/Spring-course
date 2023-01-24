package ru.sasha.springcourse;

import org.springframework.context.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("ru.sasha.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    @Scope("prototype")
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public JazzMusic jazzMusic() {
        return new JazzMusic();
    }

    @Bean
    public List<Music> musicList() {
        //Тут генерируется неизменяемый список (immutable)
        return new ArrayList<>(Arrays.asList(classicalMusic(), rockMusic(), jazzMusic()));
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }
}
