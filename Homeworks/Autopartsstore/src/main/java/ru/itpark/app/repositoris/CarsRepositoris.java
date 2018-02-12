package ru.itpark.app.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.app.models.Car;

import java.util.List;

public interface CarsRepositoris extends JpaRepository<Car, Long> {
    List<Car> findAllBy();
}
