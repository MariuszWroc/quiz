/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.service.IQuestionService;

/**
 *
 * @author XE050991049
 */
public class QuestionServiceTest extends TestCase {
    
    public QuestionServiceTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(QuestionServiceTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of loadQuestionInDB method, of class QuestionService.
     */
    public void testLoadQuestionInDB() throws Exception {
        System.out.println("loadQuestionInDB");
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
        System.out.println("saveQuestionInDB");
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
        System.out.println("saveAllQuestionInDB");
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
        System.out.println("deleteQuestionFromDB");
        Question entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionService instance = (IQuestionService)container.getContext().lookup("java:global/classes/QuestionService");
        instance.deleteQuestionFromDB(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
