package ru.itpark.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itpark.models.Autopart;
import ru.itpark.models.Car;


import java.util.HashSet;
import java.util.List;

@Repository
public class CarsRepositoryImpl implements CarsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_ALL_CARS = "SELECT  c.id AS CarId,\n" +
                    "  c.brand AS CarBrand,\n" +
                    "  c.model AS CarModel,\n" +
                    "  a.id AS AutopartId,\n" +
                    "  a.name AS AutopartName,\n" +
                    "  a.type AS AutopartType,\n" +
                    "  a.count AS AutopartCount,\n" +
                    "  a.car_id AS AutopartCar_Id,\n" +
                    "  a.reserve AS AutopartReserve\n" +
                    "\n" +
                    "FROM cars AS c \n"+
                    "LEFT JOIN autoparts AS a ON c.id = a.car_id;";




    @Override
    public List<Car> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CARS, rowMapper);
    }

    @Override
    public void save(Car model) {

    }
    private RowMapper<Car> rowMapper = (resultSet, rowNum) -> {
        // смотрим, нет ли уже пользователя с таким id в мапе
        Car car = Car.builder()
                .id(resultSet.getLong("CarId"))
                .brand(resultSet.getString("CarBrand"))
                .model(resultSet.getString("CarModel"))
                .autoparts(new HashSet<>())
                .build();


        if (resultSet.getLong("AutopartId") != 0) {
            Autopart autopart = Autopart.builder()
                    .id(resultSet.getLong("AutopartId"))
                    .name(resultSet.getString("AutopartName"))
                    .type(resultSet.getString("AutopartType"))
                    .count(resultSet.getInt("AutopartCount"))
                    .reserve(resultSet.getInt("AutopartReserve"))
                    .car_id(resultSet.getLong("AutopartCar_Id"))
                    .car(car)
                    .build();

            car.getAutoparts().add(autopart);
        }

        return car;
    };
}
