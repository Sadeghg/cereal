package io.mars.cereal.service.generic;

import java.util.Collection;

public interface GenericService <T, ID>{

    T save(T t);

    Collection<T> saveAll(Collection<T> t);

    Collection<T> saveAll(T... t);

    T findById(ID id);

    Collection<T> findAll(Collection<ID> ids);

    Collection<T> findAll(ID... ids);
}
