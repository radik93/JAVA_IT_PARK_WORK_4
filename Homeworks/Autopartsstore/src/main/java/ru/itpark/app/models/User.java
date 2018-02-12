package ru.itpark.app.models;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "app_admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hashPassword;

    private String login;

    @Enumerated(EnumType.ORDINAL)
    private State state;

  //  @Enumerated(EnumType.STRING)
    //private Role role;
}
