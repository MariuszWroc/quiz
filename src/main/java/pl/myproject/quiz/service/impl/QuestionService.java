/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Singleton;

import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.persistence.IQuestionDao;
import pl.myproject.quiz.service.IQuestionPoolService;
import pl.myproject.quiz.service.IQuestionService;

/**
 *
 * @author Mariusz Czarny
 */
@Singleton
@Startup
public class QuestionService implements IQuestionService {

    @Inject
    private IQuestionPoolService poolService;
    @Inject
    private IQuestionDao dao;

    @PostConstruct
    public void init() {
        poolService = new QuestionPoolService();
    }
    
    @Override
    public Question getRandomQuestionFromPool() {
        return dao.getRandomQuestionFromPool(poolService.getQuestionPool());
    }

}
