package io.mars.cereal.service.generic;

public interface GenericService <T, ID>{

    T save(T t);

}
