package ru.sashaLy;

public class MusicPlayer {
    //создаем общий для всех жанров музыки интерфейс
    private Music music;
    private String name;
    private int volume;

//  Создаем пустой конструктор
    public MusicPlayer() {}

//  В данном месте и применяется IoC (инверсия управления)
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public Music getMusic() {
        return this.music;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return this.volume;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }


}
