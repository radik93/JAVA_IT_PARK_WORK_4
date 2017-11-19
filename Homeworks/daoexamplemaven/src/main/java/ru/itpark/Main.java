package ru.itpark;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {

  private static final String URL = "jdbc:postgresql://localhost:5432/Abdullin_db";
  private static final String USER = "postgres";
  private static final String PASSWORD = "214365";

  public static void main(String[] args) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(URL);
    dataSource.setUsername(USER);
    dataSource.setPassword(PASSWORD);

    HumansDao humansDao = new HumansDaoJdbcTemplateImpl(dataSource);

    HumanService service = new HumanService(humansDao);

    Human human = Human.builder()
        .age(23)
        .citizen("Россия")
        .name("Ашот")
        .build();

    service.registerUser(human);

    CarsDao carsDao = new CarDaoJdbcTemplatelmpl(dataSource);

    CarService service1 = new CarService(carsDao);

    Car car = Car.builder()
            .number("777")
            .model("Калина")
            .color("Синий")
            .owner_id((long) 2)
            .build();
    service1.registerCar(car);
  }
}
