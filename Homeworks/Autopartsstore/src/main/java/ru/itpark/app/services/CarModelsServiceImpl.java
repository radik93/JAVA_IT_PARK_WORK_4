package ru.itpark.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SocketUtils;
import ru.itpark.app.dto.CarModelsDto;
import ru.itpark.app.models.CarModel;
import ru.itpark.app.repositoris.CarsModelRepositoris;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarModelsServiceImpl implements CarModelsService {

    List<CarModelsDto> carModelsDtos = new ArrayList<>();

    @Autowired
    private CarsModelRepositoris carsModelRepositoris;

    @Override
    public List<CarModelsDto> getAllCarsModelById(Long id) {
        List<CarModel> carModelList = carsModelRepositoris.findByCar_Id(id);

        for (CarModel carModel : carModelList) {
            carModelsDtos.add(new CarModelsDto(carModel));
        }
        return carModelsDtos;
    }

    @Override
    public void addCarModel(CarModel carModel) {
        carsModelRepositoris.save(carModel);
    }
}
