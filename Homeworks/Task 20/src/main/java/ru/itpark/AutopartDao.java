
package ru.itpark;

import java.util.List;

public interface AutopartDao extends CrudDao<Car> {
    List<Car> findOneByName(String name);
    Car findOneById(Long id);
}