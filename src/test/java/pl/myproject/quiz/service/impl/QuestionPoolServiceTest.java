/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.Set;
import javax.ejb.embeddable.EJBContainer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.service.IQuestionPoolService;

/**
 *
 * @author XE050991049
 */
public class QuestionPoolServiceTest extends TestCase {
    
    public QuestionPoolServiceTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(QuestionPoolServiceTest.class);
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
        System.out.println("getQuestionPool");
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
