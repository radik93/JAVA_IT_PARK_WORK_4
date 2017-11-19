package ru.itpark;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class CarDaoJdbcTemplatelmpl implements CarsDao {

    //language=SQL
    private static final String SQL_SELECT_BY_NOMBER =
            "SELECT * FROM car WHERE number = ?";

    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO owner(age, name, citizen) VALUES (?, ?, ?)";

    //language=SQL
    private static final String SQL_INSERT_CAR =
            "INSERT INTO car(model, number, color, owner_id) VALUES (?, ?, ?, ?)";

    private JdbcTemplate template;

    private RowMapper<Car> rowMapper = (resultSet, rowNum) -> {
        Car result = Car.builder()
                .id(resultSet.getLong("id"))
                .number(resultSet.getString("number"))
                .model(resultSet.getString("color"))
                .owner_id(resultSet.getLong("owner_id"))
                .build();
        return result;
    };

    public CarDaoJdbcTemplatelmpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Car findAllByNomber(String number) {
        List<Car> result = template.query(SQL_SELECT_BY_NOMBER, rowMapper, number);
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public void save(Car model) {
        template.update(SQL_INSERT_CAR, model.getModel(), model.getNumber(), model.getColor(), model.getOwner_id());

    }

    @Override
    public Car find(Long id) {
        return null;
    }

    @Override
    public void update(Car model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Car> findAll() {
        return null;
    }
}
