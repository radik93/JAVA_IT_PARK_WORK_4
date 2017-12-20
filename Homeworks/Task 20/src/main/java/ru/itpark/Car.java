package ru.itpark;

import lombok.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Car {
    // id
    private Long id;
    // марка автомобиля
    private String brand;
    // модель автомобиля
    private String model;

    private List<Autopart> autopart;
}
