package ru.sasha.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//@Component
//@Scope("prototype")
public class ClassicalMusic implements Music{
    List<String> classicalList = new ArrayList<>(Arrays.asList("First classical song", "Second classical song", "Third classical song"));

    //пока будет стоять scope("prototype") данный Init метод не будет отрабатывать!
    @PostConstruct
    public void doMuInit() {
        System.out.println("Doing my init");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }


    public String getSong() {
        Random random = new Random();
        int randomNum = random.nextInt(classicalList.size());
        return classicalList.get(randomNum);
    }
}
