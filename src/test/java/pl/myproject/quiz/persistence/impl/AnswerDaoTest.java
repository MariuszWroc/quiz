/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;

import org.junit.BeforeClass;

import pl.myproject.quiz.model.Answer;
import pl.myproject.quiz.persistence.IAnswerDao;

/**
 *
 * @author Mariusz Czarny
 */
public class AnswerDaoTest {
    private static Logger logger = Logger.getLogger(AnswerDaoTest.class.getName());
    
    @BeforeClass
    private static void setUp() throws Exception {
    }
    

    /**
     * Test of populateRandomAnswer method, of class AnswerDao.
     */
    public void testPopulateRandomAnswer() throws Exception {
    	logger.info("populateRandomAnswer");
        int answersNumberPerQuestion = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IAnswerDao instance = (IAnswerDao)container.getContext().lookup("java:global/classes/AnswerDao");
        List<Answer> expResult = null;
        List<Answer> result = instance.populateRandomAnswer(answersNumberPerQuestion);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
