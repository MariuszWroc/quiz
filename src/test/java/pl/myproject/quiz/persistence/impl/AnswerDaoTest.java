/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.myproject.quiz.model.Answer;
import pl.myproject.quiz.persistence.IAnswerDao;

/**
 *
 * @author XE050991049
 */
public class AnswerDaoTest extends TestCase {
    
    public AnswerDaoTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(AnswerDaoTest.class);
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
     * Test of populateRandomAnswer method, of class AnswerDao.
     */
    public void testPopulateRandomAnswer() throws Exception {
        System.out.println("populateRandomAnswer");
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
