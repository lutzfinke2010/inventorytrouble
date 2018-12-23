package de.maxya.inventorytrouble.entity.repository;

import de.maxya.inventorytrouble.entity.RBLSitzplatzEntity;
import org.springframework.data.repository.CrudRepository;

public interface RBLSitzplatzRepository extends CrudRepository<RBLSitzplatzEntity, Long> {
    long count();
}
