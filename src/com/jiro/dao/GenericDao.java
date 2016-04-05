package com.jiro.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao {
    
    public Object get (Class<?> c, Serializable value);

    public void save(Object pojoObject);

    public void saveOrUpdate(Object pojoObject);
    
    public long persist(Object pojoObject);
    
    public void delete(Object pojoObject);

    public List<?> getList(Class<?> c);
    
}