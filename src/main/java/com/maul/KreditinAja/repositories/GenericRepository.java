package com.maul.KreditinAja.repositories;

import java.util.List;

public interface GenericRepository<T> {
    public List<T> findAll();
    public T findById(String id);
    public void save(T data);
    public void update(T data);
    public void deleteById(String id);
}
