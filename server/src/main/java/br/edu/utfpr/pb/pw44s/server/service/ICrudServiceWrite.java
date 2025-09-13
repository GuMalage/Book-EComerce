package br.edu.utfpr.pb.pw44s.server.service;

import java.io.Serializable;

public interface ICrudServiceWrite<T, ID extends Serializable> {

    T save(T entity);

    T saveAndFlush(T entity);

    Iterable<T> save(Iterable<T> iterable);

    void flush();

    void deleteById(ID id);

    void delete(Iterable<? extends T> iterable);

    void deleteAll();
}