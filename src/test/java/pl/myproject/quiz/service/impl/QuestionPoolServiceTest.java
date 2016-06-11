/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;

import org.junit.BeforeClass;

import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.service.IQuestionPoolService;

/**
 *
 * @author Mariusz Czarny
 */
public class QuestionPoolServiceTest {
    private static Logger logger = Logger.getLogger(QuestionPoolServiceTest.class.getName());
    
    @BeforeClass
    private static void setUp() throws Exception {
    }

    /**
     * Test of init method, of class QuestionPoolService.
     */
    public void testInit() throws Exception {
        System.out.println("init");
        QuestionPoolService instance = new QuestionPoolService();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionPool method, of class QuestionPoolService.
     */
    public void testGetQuestionPool() throws Exception {
    	logger.info("getQuestionPool");
        int size = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionPoolService instance = (IQuestionPoolService)container.getContext().lookup("java:global/classes/QuestionPoolService");
        Set<Question> expResult = null;
        Set<Question> result = instance.getQuestionPool(size);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
