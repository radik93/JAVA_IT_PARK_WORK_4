package ru.itpark;


import java.util.List;

public interface CarsDao extends CrudDao<Car>{
  Car findAllByNomber(String nomber);

}
