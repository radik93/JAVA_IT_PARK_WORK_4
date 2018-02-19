package ru.itpark.repository;

import ru.itpark.models.Car;

public interface CarsRepository extends CrudRepository<Car> {
    Car findName(String brand, String model);
}
