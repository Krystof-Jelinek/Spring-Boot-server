package cz.cvut.fit.jelinkry.semestralka.service;

import java.util.Optional;

public interface CrudService <Type, Id>{
    Type create(Type e);
    Optional<Type> readById(Id id);
    Iterable<Type> readAll();
    void update(Id id, Type e);
    void deleteById(Id id);

}
