package ru.itpark;

import lombok.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Autopart {
    // id
    private Long id;
    // наименование автозапчасти
    private String name;
    // тип автозапчасти
    private String type;
    // количество
    private int count;
    //резерв
    private int reserve;
    //автозапчасти
    private Car car;

}