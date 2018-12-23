package de.maxya.inventorytrouble.entity.projection;

import de.maxya.inventorytrouble.entity.RBLGameEntity;
import org.springframework.data.rest.core.config.Projection;


@Projection(
        name = "rblgameprojection",
        types = { RBLGameEntity.class })
public interface RblGameProjection {
    String getName();
}
