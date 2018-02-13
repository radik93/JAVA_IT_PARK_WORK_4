package ru.itpark.app.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.app.models.Car;
import ru.itpark.app.repositoris.CarsRepositoris;

import java.util.List;

@Service
public class CarsServicelmpl implements CarsService {

    @Autowired
    private CarsRepositoris carsRepositoris;

    @Override
    public List<Car> getAllCars() {
        List<Car> carList = carsRepositoris.findAllBy();
        return carList;
    }

    @Override
    public void addCar(Car car) {
        carsRepositoris.save(car);
    }

    @Override
    public Car getCarByBrand(String brand) {
        return carsRepositoris.findCarByBrand(brand);
    }
}
