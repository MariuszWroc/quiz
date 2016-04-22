/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import pl.myproject.quiz.model.Question;

/**
 *
 * @author Mariusz Czarny
 */
@Local
public interface IQuestionPoolService {
  /**
     *
     * @param size
     * @return
     */
    Set<Question> getQuestionPool(int size);

    List<Question> getQuestionPool();
    
    Question getQuestionFromPool(int id);
    
    Question getRandomQuestionFromPool(List<Question> questionPool);
    
    List<Question> getQuizFromPool();
    
    /**
     *
     * @param entity is a Question class
     */
    void addQuestionToPool(Question entity);
    
    /**
     *
     * @param entity is a Question class
     */
    void deleteQuestionFromPool(Question entity);
    
    void saveQuestionInDB(Question entity);
    
    void saveAllQuestionInDB(List<Question> entityList);
    
    void deleteQuestionFromDB(Question entity);    
}
