package ru.itpark.app.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id
    private Long id;
    // марка автомобиля
    private String brand;

    @OneToMany(mappedBy = "car")
    private List<CarModel> carModelList;


}

