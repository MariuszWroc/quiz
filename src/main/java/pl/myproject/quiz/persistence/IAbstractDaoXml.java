/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence;

import java.io.StringWriter;

/**
 *
 * @author Mariusz Czarny
 * @param <T>
 */
public interface IAbstractDaoXml<T> {

    /**
     *
     * @param entity
     * @param filePath
     * @return
     */
    public StringWriter convertObjectToXML(T entity, String filePath);

    /**
     *
     * @param path
     * @return
     */
    public T convertXMLToObject(String path);
}
