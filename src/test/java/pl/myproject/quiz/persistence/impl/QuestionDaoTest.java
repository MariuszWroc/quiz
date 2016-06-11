/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;

import org.junit.BeforeClass;

import pl.myproject.quiz.model.ApplicationSetting;
import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.persistence.IQuestionDao;

/**
 *
 * @author Mariusz Czarny
 */
public class QuestionDaoTest {
    private static Logger logger = Logger.getLogger(QuestionDaoTest.class.getName());
    
    @BeforeClass
    private static void setUp() throws Exception {
    }

    /**
     * Test of convertObjectToXML method, of class QuestionDao.
     */
    public void testConvertObjectToXML() throws Exception {
    	logger.info("convertObjectToXML");
        Question entity = null;
        String filePath = "";
        QuestionDao instance = new QuestionDao();
        StringWriter expResult = null;
        StringWriter result = instance.convertObjectToXML(entity, filePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertXMLToObject method, of class QuestionDao.
     */
    public void testConvertXMLToObject() throws Exception {
        System.out.println("convertXMLToObject");
        String path = "";
        QuestionDao instance = new QuestionDao();
        Question expResult = null;
        Question result = instance.convertXMLToObject(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteXMLFile method, of class QuestionDao.
     */
    public void testDeleteXMLFile() throws Exception {
        System.out.println("deleteXMLFile");
        String path = "";
        QuestionDao instance = new QuestionDao();
        instance.deleteXMLFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateXMLFile method, of class QuestionDao.
     */
    public void testUpdateXMLFile() throws Exception {
        System.out.println("updateXMLFile");
        String path = "";
        QuestionDao instance = new QuestionDao();
        instance.updateXMLFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class QuestionDao.
     */
    public void testAdd_3args() throws Exception {
        System.out.println("add");
        Question entity = null;
        String path = "";
        String filename = "";
        QuestionDao instance = new QuestionDao();
        instance.add(entity, path, filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class QuestionDao.
     */
    public void testAdd_GenericType() throws Exception {
        System.out.println("add");
        Question entity = null;
        QuestionDao instance = new QuestionDao();
        instance.add(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class QuestionDao.
     */
    public void testAdd_GenericType_Integer() throws Exception {
        System.out.println("add");
        Question entity = null;
        Integer id = null;
        QuestionDao instance = new QuestionDao();
        instance.add(entity, id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class QuestionDao.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
        Question entity = null;
        QuestionDao instance = new QuestionDao();
        instance.update(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class QuestionDao.
     */
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        QuestionDao instance = new QuestionDao();
        List<Question> expResult = null;
        List<Question> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class QuestionDao.
     */
    public void testFindById() throws Exception {
        System.out.println("findById");
        Integer id = null;
        String prefix = "";
        QuestionDao instance = new QuestionDao();
        Question expResult = null;
        Question result = instance.findById(id, prefix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class QuestionDao.
     */
    public void testDelete() throws Exception {
        System.out.println("delete");
        Integer id = null;
        String prefix = "";
        QuestionDao instance = new QuestionDao();
        instance.delete(id, prefix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choosePathForFile method, of class QuestionDao.
     */
    public void testChoosePathForFile() throws Exception {
        System.out.println("choosePathForFile");
        QuestionDao instance = new QuestionDao();
        String expResult = "";
        String result = instance.choosePathForFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomQuestionFromPool method, of class QuestionDao.
     */
    public void testGetRandomQuestionFromPool() throws Exception {
        System.out.println("getRandomQuestionFromPool");
        List<Question> questionPool = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionDao instance = (IQuestionDao)container.getContext().lookup("java:global/classes/QuestionDao");
        Question expResult = null;
        Question result = instance.getRandomQuestionFromPool(questionPool);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateQuestionsPool method, of class QuestionDao.
     */
    public void testPopulateQuestionsPool_int() throws Exception {
        System.out.println("populateQuestionsPool");
        int questionPoolSize = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionDao instance = (IQuestionDao)container.getContext().lookup("java:global/classes/QuestionDao");
        Set<Question> expResult = null;
        Set<Question> result = instance.populateQuestionsPool(questionPoolSize);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateQuestionsPool method, of class QuestionDao.
     */
    public void testPopulateQuestionsPool_int_int() throws Exception {
        System.out.println("populateQuestionsPool");
        int questionPoolSize = 0;
        int answersNumberPerQuestion = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionDao instance = (IQuestionDao)container.getContext().lookup("java:global/classes/QuestionDao");
        Set<Question> expResult = null;
        Set<Question> result = instance.populateQuestionsPool(questionPoolSize, answersNumberPerQuestion);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateQuestions method, of class QuestionDao.
     */
    public void testPopulateQuestions_ApplicationSetting() throws Exception {
        System.out.println("populateQuestions");
        ApplicationSetting settings = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionDao instance = (IQuestionDao)container.getContext().lookup("java:global/classes/QuestionDao");
        List<Question> expResult = null;
        List<Question> result = instance.populateQuestions(settings);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateQuestions method, of class QuestionDao.
     */
    public void testPopulateQuestions_int_int() throws Exception {
        System.out.println("populateQuestions");
        int questionPoolSize = 0;
        int answersNumberPerQuestion = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionDao instance = (IQuestionDao)container.getContext().lookup("java:global/classes/QuestionDao");
        List<Question> expResult = null;
        List<Question> result = instance.populateQuestions(questionPoolSize, answersNumberPerQuestion);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateQuestions method, of class QuestionDao.
     */
    public void testPopulateQuestions_int() throws Exception {
        System.out.println("populateQuestions");
        int questionPoolSize = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IQuestionDao instance = (IQuestionDao)container.getContext().lookup("java:global/classes/QuestionDao");
        List<Question> expResult = null;
        List<Question> result = instance.populateQuestions(questionPoolSize);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
