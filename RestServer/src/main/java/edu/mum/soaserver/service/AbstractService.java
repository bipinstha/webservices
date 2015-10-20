package edu.mum.soaserver.service;

import java.util.List;

/**
 *
 * @author bipin
 * @param <T>
 * @param <PK>
 */
public interface AbstractService<T, PK> {

    public void add(T t);
    
    public void update(T t);
    
    public T findOne(PK obj);
    
    public List<T> findAll();
    
    public void delete(T t);
    
    public void deleteById(PK obj);
    
    public void deleteAll();
    
}
