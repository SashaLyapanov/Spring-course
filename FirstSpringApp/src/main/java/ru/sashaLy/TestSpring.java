package ru.sashaLy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //создаем контекст приложения (context), который будет хранить конфигурационный файл, в котором прописаны наши бины.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        после создания контекста мы можем получить из него наш бин. В следующей строке представлено создание экземпляра класса TestBean
//        через специальный метод получения бина из контекста
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());

        Car BMW = context.getBean("carBean", Car.class);
        System.out.println(BMW.getName());

        System.out.println(testBean.getName() + " в скором времени купит " + BMW.getName() + ", возраст которой составляет " + BMW.getAge());



//        Обязательное закрытие контекста
        context.close();


    }
}
