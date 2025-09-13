package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceWrite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class CrudServiceWriteImpl<T, ID extends Serializable> implements ICrudServiceWrite<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T saveAndFlush(T entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    public Iterable<T> save(Iterable<T> iterable) {
        return getRepository().saveAll(iterable);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }


    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public void delete(Iterable<? extends T> iterable) {
        getRepository().deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }
} 
