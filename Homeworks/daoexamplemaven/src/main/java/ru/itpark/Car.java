package ru.itpark;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Car {

    private Long id;
    private String model;
    private String number;
    private String color;
    private Long owner_id;
}
