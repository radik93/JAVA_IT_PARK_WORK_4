package ru.itpark.repository;

import ru.itpark.models.Car;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    void save(T model);
}
