package ru.sasha.springcourse;

public class ClassicalMusic implements Music{
    public String getSong() {
        return "Some classical song";
    }

    public void doMyInit() {
        System.out.println("Doing my bean's creating");
    }

    public void doMyDestroy() {
        System.out.println("А сейчас мы крякнули бин");
    }

    private ClassicalMusic() { }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }
}
