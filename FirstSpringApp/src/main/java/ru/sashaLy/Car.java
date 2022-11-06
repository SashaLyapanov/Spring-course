package ru.sashaLy;

public class Car {
    private String name;
    private String color;
    private int age;
    private int weight;
    private int engine_V;

    public Car (String name, String color, int age, int weight, int engine_V) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.weight = weight;
        this.engine_V = engine_V;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setEngine_V(int engine_V) {
        this.engine_V = engine_V;
    }

    public int getEngine_V() {
        return engine_V;
    }



}
