package ru.itpark;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import javax.sql.DataSource;
import java.util.*;

public class AutopartDaoJdbcTemplateImpl implements AutopartDao {

    private JdbcTemplate template;

    private Map<Long, Car> autopartMap = new HashMap<>();

    //language=SQL
    private static final String SQL_SELECT_ALL_AUTOPART_All = "SELECT   Autopart.id AS AutopartId,\n" +
            "  Autopart.name AS AutopartName,\n" +
            "  Autopart.type AS AutopartType,\n" +
            "  Car.id AS CarId,\n" +
            "  Car.brand AS CarBrand,\n" +
            "  Car.model AS CarModel,\n" +
            "  Autopart.count AS AutopartCount,\n" +
            "  AutopartCarId.count AS AutopartCarId,\n" +
            "  Autopart.reserve AS AutopartReserve,\n" +
            "FROM Autopart AS Autopart \n"+
            "LEFT JOIN Car AS Car ON o.id = c.owner_id;";

    //language=SQL
    private static final String SQL_SELECT_ALL_AUTOPART_BY_NAME = "SELECT   Autopart.id AS AutopartId,\n" +
            "  Autopart.name AS AutopartName,\n" +
            "  Autopart.type AS AutopartType,\n" +
            "  Car.id AS CarId,\n" +
            "  Car.brand AS CarBrand,\n" +
            "  Car.model AS CarModel,\n" +
            "  Autopart.count AS AutopartCount,\n" +
            "  AutopartCarId.count AS AutopartCarId,\n" +
            "  Autopart.reserve AS AutopartReserve,\n" +
            "FROM Autopart AS Autopart WHERE AutopartName = ?\n"+
            "LEFT JOIN Car AS Car ON o.id = c.owner_id;";
    //language=SQL
    private static final String SQL_SELECT_ALL_AUTOPART_BY_ID = "SELECT   Autopart.id AS AutopartId,\n" +
            "  Autopart.name AS AutopartName,\n" +
            "  Autopart.type AS AutopartType,\n" +
            "  Car.id AS CarId,\n" +
            "  Car.brand AS CarBrand,\n" +
            "  Car.model AS CarModel,\n" +
            "  Autopart.count AS AutopartCount,\n" +
            "  AutopartCarId.count AS AutopartCarId,\n" +
            "  Autopart.reserve AS AutopartReserve,\n" +
            "FROM Autopart AS Autopart WHERE AutopartId = ?\n"+
            "LEFT JOIN Car AS Car ON o.id = c.owner_id;";

    //language=SQL
    private static final String SQL_INSERT_AUTOPART = "INSERT INTO Autopart(\n" +
            "name,\n" +
            "type,\n" +
            "carId,\n" +
            "count,\n" +
            "reserve)\n" +
            "VALUES (?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_INSERT_CAR = "INSERT INTO Car(\n" +
            "brand,\n" +
            "model,\n" +
            "VALUES (?, ?)";

    //language=SQL

    public AutopartDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public Car findOneById(Long id) {
        List<Car> result = template.query(SQL_SELECT_ALL_AUTOPART_BY_ID, rowMapper, id);
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    public List<Car> findOneByName(String name) {
        List<Car> result = template.query(SQL_SELECT_ALL_AUTOPART_BY_NAME, rowMapper, name);
        if (result.size() > 0) {
            return result;
        }
        return null;
    }

    public void save(Car model) {
        template.update(SQL_INSERT_CAR, model.getBrand()
                                      , model.getModel());
    }

    public Car find(Long id) {
        return null;
    }

    public void update(Car model) {

    }

    public void delete(Long id) {

    }

    public List<Car> findAll() {
        List<Car> result = template.query(SQL_SELECT_ALL_AUTOPART_All, rowMapper);
        if (result.size() > 0) {
            return result;
        }
        return null;
    }

    private RowMapper<Car> rowMapper = (resultSet, rowNum) -> {
        // смотрим, нет ли уже автомобиля с таким id в мапе
            if (autopartMap.get(resultSet.getLong("CarId")) == null) {
                Car car = Car.builder()
                        .id(resultSet.getLong("CarId"))
                        .brand(resultSet.getString("CarBrand"))
                        .model(resultSet.getString("CarModel"))
                        .build();

                autopartMap.put(car.getId(), car);
            }
        // смотрим, нет ли уже автозапчасти с таким id в мапе
        if (autopartMap.get(resultSet.getLong("AutopartId")) == null) {
            Autopart autopart = Autopart.builder()
                    .id(resultSet.getLong("AutopartId"))
                    .name(resultSet.getString("AutopartName"))
                    .type(resultSet.getString("AutopartType"))
                    .count(resultSet.getInt("AutopartCount"))
                    .reserve(resultSet.getInt("AutopartReserve"))
                    .car(autopartMap.get(resultSet.getLong("CarId")))
                    .build();

            autopartMap.get(autopart.getCar().getId()).getAutopart().add(autopart);
        }
        return autopartMap.get(resultSet.getLong("CarId"));
    };
}
