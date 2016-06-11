/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;

import org.junit.BeforeClass;

import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.service.IQuestionService;

/**
 *
 * @author Mariusz Czarny
 */
public class QuestionServiceTest {
    private static Logger logger = Logger.getLogger(QuestionServiceTest.class.getName());
    
    @BeforeClass
    private static void setUp() throws Exception {
    }

    /**
     * Test of loadQuestionInDB method, of class QuestionService.
     */
    public void testLoadQuestionInDB() throws Exception {
    	logger.info("loadQuestionInDB");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionService instance = (IQuestionService)container.getContext().lookup("java:global/classes/QuestionService");
        instance.loadQuestionInDB();
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveQuestionInDB method, of class QuestionService.
     */
    public void testSaveQuestionInDB() throws Exception {
    	logger.info("saveQuestionInDB");
        Question entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionService instance = (IQuestionService)container.getContext().lookup("java:global/classes/QuestionService");
        instance.saveQuestionInDB(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveAllQuestionInDB method, of class QuestionService.
     */
    public void testSaveAllQuestionInDB() throws Exception {
    	logger.info("saveAllQuestionInDB");
        List<Question> entityList = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionService instance = (IQuestionService)container.getContext().lookup("java:global/classes/QuestionService");
        instance.saveAllQuestionInDB(entityList);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteQuestionFromDB method, of class QuestionService.
     */
    public void testDeleteQuestionFromDB() throws Exception {
    	logger.info("deleteQuestionFromDB");
        Question entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionService instance = (IQuestionService)container.getContext().lookup("java:global/classes/QuestionService");
        instance.deleteQuestionFromDB(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
