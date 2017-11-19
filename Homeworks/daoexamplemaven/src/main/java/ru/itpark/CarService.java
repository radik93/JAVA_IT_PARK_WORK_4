package ru.itpark;

public class CarService {

    private CarsDao carsDao;

    public CarService(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    public void registerCar(Car car) {

        String number = car.getNumber();

        Car existingCar = carsDao.findAllByNomber(number);

        if (existingCar != null) {
            // если есть - выбрасываем ошибку, если нет - сохраняем
            throw new IllegalArgumentException("Already exist");
        }

        carsDao.save(car);

    }
}
