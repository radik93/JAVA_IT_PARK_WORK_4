package ru.itpark.repository;

import ru.itpark.models.Car;

import javax.persistence.EntityManager;
import java.util.List;

public class CarsRepositoryEntityManagerImpl implements CarsRepository {

    private EntityManager entityManager;

    public CarsRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Car> findAll() {
        return entityManager
                .createQuery("from Car", Car.class)
                .getResultList();
    }

    @Override
    public void save(Car model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public Car findName(String brand, String model) {
         List<Car> carList = entityManager
                .createQuery("from Car car where car.brand = ? and car.model = ?", Car.class).setParameter(0, brand).setParameter(1, model)
                .getResultList();
         if(carList.iterator().hasNext())
         {
             return carList.iterator().next();
         }
        return null;
    }
}
