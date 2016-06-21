/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.persistence.IQuestionDao;
import pl.myproject.quiz.service.IQuestionService;

/**
 *
 * @author Mariusz Czarny
 */
@Singleton
@Startup
public class QuestionService implements IQuestionService {

    @Inject
    private IQuestionDao dao;
    
    @Override
    public void getQuestionsFromDB() {
        dao.findAll();
    }

    @Override
    public void saveQuestionInDB(Question entity) {
        dao.add(entity);
    }
    
    @Override
    public void saveAllQuestionInDB(List<Question> entityList) {
        for (Question entity : entityList) {
            dao.add(entity);
        }
    }

    @Override
    public void deleteQuestionFromDB(Question entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    } 
    
    @Override
    public void deleteAllQuestionFromDB(Question entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    } 

}
