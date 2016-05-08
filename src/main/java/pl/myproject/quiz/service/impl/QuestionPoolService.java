/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.persistence.IQuestionDao;
import pl.myproject.quiz.service.IQuestionPoolService;

/**
 *
 * @author Mariusz Czarny
 */
@Singleton
@Startup
public class QuestionPoolService implements IQuestionPoolService{
    private static final Logger LOGGER = Logger.getLogger(QuestionPoolService.class.getName());
    
    @Inject
    private IQuestionDao dao;

    @PostConstruct
    public void init() {
        LOGGER.info("Question Pool init!");
    }
    
    @Override
    public Set<Question> getQuestionPool(int size) {
        return dao.populateQuestionsPool(size);
    }

}
