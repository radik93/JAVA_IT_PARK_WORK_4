package ru.itpark.app.services;

import ru.itpark.app.models.Car;

import java.util.List;

public interface CarsService {
   List<Car> getAllCars();
   void addCar(Car car);
   Car getCarByBrand(String brand);
}
