package ru.itpark;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "owner")
@Builder
public class Car {
    private Long id;
    private String model;
    private String number;
    private String color;
    private User owner;
}