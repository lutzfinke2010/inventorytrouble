package de.maxya.inventorytrouble.entity.repository;

import de.maxya.inventorytrouble.entity.RBLGameEntity;
import de.maxya.inventorytrouble.entity.projection.RblGameProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;


@RepositoryRestResource(excerptProjection = RblGameProjection.class)
public interface RBLGameRepository extends CrudRepository<RBLGameEntity, Long> {
    List<RBLGameEntity> findByPlaetzeBereichBetween(String von, String bis);

    List<RBLGameEntity> findByStartDateAfter(Date after);

    long count();

    long countByName(String name);
}
