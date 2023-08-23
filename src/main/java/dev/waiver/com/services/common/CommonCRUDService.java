package dev.waiver.com.services.common;

import dev.waiver.com.models.common.AbstractEntity;

import java.util.List;

public interface CommonCRUDService<E extends AbstractEntity> {

    E get(int id);

    List<E> getAll();

    E create(E entity);

    E update(int id, E entity);

    void delete(int id);
}
