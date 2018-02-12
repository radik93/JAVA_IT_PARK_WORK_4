package ru.itpark.app.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.itpark.app.models.CarModel;

import java.util.List;

public interface CarsModelRepositoris extends JpaRepository<CarModel, Long> {
    List<CarModel> findByCar_Id(Long id);
}
