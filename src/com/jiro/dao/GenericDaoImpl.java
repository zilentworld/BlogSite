package com.jiro.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class GenericDaoImpl implements GenericDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Object get(Class<?> c, Serializable value) {
        try {            
            return c.cast(getCurrentSession().get(c, value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void save(Object pojoObject) {
        try {
            getCurrentSession().save(pojoObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void saveOrUpdate(Object pojoObject) {
        try {
            getCurrentSession().saveOrUpdate(pojoObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Transactional
    @Override
    public long persist(Object pojoObject) {
        try {
            return (long) getCurrentSession().save(pojoObject);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override
    @Transactional
    public void delete(Object pojoObject) {
        try {
            getCurrentSession().delete(pojoObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public List<?> getList(Class<?> c) {
        return getCurrentSession().createCriteria(c).list(); 
    }
    
    
}