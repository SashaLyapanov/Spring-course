package ru.sashaLy;

public class MusicPlayer {
    //создаем общий для всех жанров музыки интерфейс
    private Music music;

    //В данном месте и применяется IoC (инверсия управления)
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }


}
