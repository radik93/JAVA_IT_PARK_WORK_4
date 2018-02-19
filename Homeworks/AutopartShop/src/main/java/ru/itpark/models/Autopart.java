package ru.itpark.models;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "cars")
@Builder
public class Autopart {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    // id
    private Long id;
    // наименоание автозапчасти
    private String name;
    // тип автозапчасти
    private String type;
    // количество
    private int count;
    //в резерве
    private int reserve;
    //  id автомобиля
    private Long car_id;

    //@ManyToOne
    private Car car;
}
