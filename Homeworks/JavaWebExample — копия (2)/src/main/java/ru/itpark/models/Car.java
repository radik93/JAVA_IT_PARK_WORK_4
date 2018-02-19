package ru.itpark.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "cars")
@ToString(exclude = "cars")
@Builder
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // id
  private Long id;
  // марка автомобиля
  private String brand;
  // модель автомобиля
  private String model;

  @OneToMany
  private Set<Autopart> autoparts;
}
