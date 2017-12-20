package ru.itpark;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Buyer {

    // id
    private Long id;
    // Имя
    private String name;
    // намер телеофна
    private int phoneNumber;
    // модель email
    private String email;
}
