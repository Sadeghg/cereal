package io.mars.cereal.service.generic;

import java.util.Collection;

public interface GenericService <T, ID>{

    T save(T t);

    Collection<T> saveAll(Collection<T> t);
}
