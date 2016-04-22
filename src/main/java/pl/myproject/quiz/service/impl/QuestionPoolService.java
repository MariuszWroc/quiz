/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.persistence.IQuestionDao;
import pl.myproject.quiz.service.IQuestionPoolService;
import pl.myproject.quiz.util.FillSampleData;
import static pl.myproject.quiz.util.constant.ApplicationValues.DEFAULT_QUESTION_POOL_SIZE;

/**
 *
 * @author Mariusz Czarny
 */
@Singleton
@Startup
//@ApplicationScoped
public class QuestionPoolService implements IQuestionPoolService{
    private static final Logger LOG = Logger.getLogger(QuestionPoolService.class.getName());
    
   @Inject
    private IQuestionDao dao;

    @PostConstruct
    public void init() {
        LOG.info("Question Pool init!");
    }
    
    @Override
    public Set<Question> getQuestionPool(int size) {
        return FillSampleData.populateQuestionsPool(size);
    }

    @Override
    public List<Question> getQuestionPool() {
        return FillSampleData.populateQuestions(DEFAULT_QUESTION_POOL_SIZE.getNumber());
    }
    
    @Override
    public Question getRandomQuestionFromPool(List<Question> questionPool) {
        return FillSampleData.getRandomQuestionFromPool(questionPool);
    }

    @Override
    public void addQuestionToPool(Question entity) {

    }

    @Override
    public void deleteQuestionFromPool(Question entity) {

    }
    
    public void loadQuestionInDB() {
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
//        dao.delete(entity.getId());
    }    

    @Override
    public Question getQuestionFromPool(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> getQuizFromPool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
