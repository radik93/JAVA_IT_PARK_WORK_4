package ru.itpark.models;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "autoparts")
@Builder
public class Car {

   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id
    private Long id;
    // марка автомобиля
    private String brand;
    // модель автомобиля
    private String model;

    //@OneToMany
    private Set<Autopart> autoparts;

}

