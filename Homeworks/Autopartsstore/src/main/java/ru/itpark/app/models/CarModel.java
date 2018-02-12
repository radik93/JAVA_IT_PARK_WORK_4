package ru.itpark.app.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars_model")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "cars")
@ToString(exclude = "cars")
@Builder
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id
    private Long id;
    // марка автомобиля
    private String model;


    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne(mappedBy = "carModel")
    private FileInfo image;
}
