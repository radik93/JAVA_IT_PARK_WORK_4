package ru.itpark.repository;

import ru.itpark.models.Autopart;


import javax.persistence.EntityManager;
import java.util.List;

public class AutopartsRepositoryEntityManagerImpl implements AutopartsRepository {

    private EntityManager entityManager;


    public AutopartsRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Autopart> findAll() {
        return entityManager
                .createQuery("from Autopart", Autopart.class)
                .getResultList();
    }

    @Override
    public void save(Autopart model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }
}
