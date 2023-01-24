package ru.sasha.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//@Component
public class RockMusic implements Music{
    List<String> rockList = new ArrayList<>(Arrays.asList("First rock song", "Second rock song", "Third rock song"));

    public String getSong(){
        Random random = new Random();
        int randomNum = random.nextInt(rockList.size());
        return rockList.get(randomNum);
    }
}
