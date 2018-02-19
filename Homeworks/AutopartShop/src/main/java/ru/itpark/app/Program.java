package ru.itpark.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.repository.CarsRepository;


public class Program {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ru.itpark\\context.xml");
        CarsRepository carsRepository = context.getBean(CarsRepository.class);
        List<CarcarsRepository.findAll());

    }
}