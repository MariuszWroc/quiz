/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence;

import java.util.List;

/**
 *
 * @author Mariusz Czarny
 * @param <T>
 */
public interface IAbstractDao<T> {

    /**
     *
     * @param entity
     * @param prefix
     * @param number
     */
    void add(T entity, String prefix, String number);

    /**
     *
     * @param entity
     */
    void add(T entity);

    void add(T entity, Integer id);
    /**
     *
     * @param id
     * @param prefix
     */
    void delete(Integer id, String prefix);

    /**
     *
     * @return
     */
    List<T> findAll();

    /**
     *
     * @param id
     * @param prefix
     * @return
     */
    T findById(Integer id, String prefix);

    /**
     *
     * @param entity
     */
    void update(T entity);
    
}
