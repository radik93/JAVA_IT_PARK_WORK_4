package ru.itpark.app.services;

import org.springframework.stereotype.Service;
import ru.itpark.app.dto.CarModelsDto;
import ru.itpark.app.models.CarModel;

import java.util.List;

@Service
public interface CarModelsService {

    List<CarModelsDto> getAllCarsModelById(Long id);
    void addCarModel(CarModel carModel);
}
