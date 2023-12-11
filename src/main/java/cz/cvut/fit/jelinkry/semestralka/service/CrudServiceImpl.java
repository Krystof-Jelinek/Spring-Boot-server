package cz.cvut.fit.jelinkry.semestralka.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cz.cvut.fit.jelinkry.semestralka.domain.EntityWithId;

public abstract class CrudServiceImpl<T extends EntityWithId<ID> , ID>  implements CrudService<T, ID>{
    @Override
    public T create(T e) {
        /*
        if (getRepository().existsById(e.getId())){
            System.out.println("this was already added");
            throw new IllegalArgumentException("entity with this id already exists in the database");
        }*/
        return getRepository().save(e);
    }

    @Override
    public Optional<T> readById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public Iterable<T> readAll() {
        return getRepository().findAll();
    }

    @Override
    public void update(ID id, T e) {
        if (getRepository().existsById(id)) {
            getRepository().save(e);
        } else {
            throw new IllegalArgumentException("Entity with ID " + id + " not found");
        }
    }

    @Override
    public void deleteById(ID id) {
        if (!getRepository().existsById(id)){
            throw new IllegalArgumentException("Entity with ID " + id + " not found");
        }
        getRepository().deleteById(id);
    }

    protected abstract CrudRepository<T, ID> getRepository();

}
