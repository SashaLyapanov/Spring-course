package ru.sasha.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music{
    List<String> classicalList = new ArrayList<>(Arrays.asList("First classical song", "Second classical song", "Third classical song"));


    public String getSong() {
        Random random = new Random();
        int randomNum = random.nextInt(3);
        return classicalList.get(randomNum);
    }
}
