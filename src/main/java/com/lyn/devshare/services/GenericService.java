package com.lyn.devshare.services;

import java.util.List;

public interface GenericService<T, I> {
    List<T> findAll();
    T findById(I id);

    T save(T t);
    boolean delete(T t);
}
