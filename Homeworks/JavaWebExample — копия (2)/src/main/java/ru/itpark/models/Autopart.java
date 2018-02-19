package ru.itpark.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "autoparts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Autopart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Long car_id;
  //  private Car car;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
