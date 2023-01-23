package ru.sasha.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class JazzMusic implements Music{
    List<String> jazzList = new ArrayList<>(Arrays.asList("First jazz song", "Second jazz song", "Third jazz song"));

    public String getSong() {
        Random random = new Random();
        int randomNum = random.nextInt(3);
        return jazzList.get(randomNum);
    }
}
