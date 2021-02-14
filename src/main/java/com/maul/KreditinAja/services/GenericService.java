package com.maul.KreditinAja.services;

import java.util.List;

public interface GenericService<T> {
    public List<T> getAllData();
    public T getDataById(String id);
    public void insertData(T data);
    public void updateData(T data);
    public void deleteData(String id);
}
