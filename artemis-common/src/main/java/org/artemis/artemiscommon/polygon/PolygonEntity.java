package org.artemis.artemiscommon.polygon;

import lombok.SneakyThrows;
import org.artemis.artemiscommon.exception.UnknownPolygonEntityException;

public enum PolygonEntity {
    POLYGON_ENTITY_END_OF_DAY("endOfDay"),
    POLYGON_ENTITY_INDICATOR("indicator");

    private final String name;

    PolygonEntity(String name) {
        this.name = name;
    }

    @SneakyThrows
    public static PolygonEntity getFromName(String name) {
        for (var entity : PolygonEntity.values()) {
            if (entity.name.equalsIgnoreCase(name)) {
                return entity;
            }
        }
        var message = String.format("Unknown entity was requested: %s", name);
        throw new UnknownPolygonEntityException(message);
    }
}
