/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import java.io.StringWriter;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.myproject.quiz.model.ApplicationSetting;
import pl.myproject.quiz.model.Question;

/**
 *
 * @author Mariusz Czarny
 */
public class QuestionDaoTest {
	private static final Logger logger = Logger.getLogger(QuestionDaoTest.class.getName());
	private static Question question;
	private static QuestionDao mockedQuestionDao;
	
	@BeforeClass
	public static void setUp() throws Exception {
		mockedQuestionDao = mock(QuestionDao.class);	
		
		question = new Question(1, "pytanie?");
		Throwable throwables = new Throwable("coś nie tak");
		String filePath = "sciezka";
		
		when(mockedQuestionDao.convertObjectToXML(question, filePath)).thenThrow(throwables);
	}

    /**
     * Test of convertObjectToXML method, of class QuestionDao.
     */
	@Test
    public void testConvertObjectToXML() throws Exception {
		logger.info("convertObjectToXML");
        Question entity = null;
        String filePath = "";
        StringWriter expResult = null;
        StringWriter result = mockedQuestionDao.convertObjectToXML(entity, filePath);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertXMLToObject method, of class QuestionDao.
     */
	@Test
    public void testConvertXMLToObject() throws Exception {
		logger.info("convertXMLToObject");
        String path = "";
        Question expResult = null;
        Question result = mockedQuestionDao.convertXMLToObject(path);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteXMLFile method, of class QuestionDao.
     */
	@Test
    public void testDeleteXMLFile() throws Exception {
		logger.info("deleteXMLFile");
        String path = "";
        QuestionDao instance = new QuestionDao();
        instance.deleteXMLFile(path);
    }

    /**
     * Test of updateXMLFile method, of class QuestionDao.
     */
	@Test
    public void testUpdateXMLFile() throws Exception {
		logger.info("updateXMLFile");
        String path = "";
        QuestionDao instance = new QuestionDao();
        instance.updateXMLFile(path);
    }

    /**
     * Test of add method, of class QuestionDao.
     */
	@Test
    public void testAdd_3args() throws Exception {
		logger.info("add");
        Question entity = null;
        String path = "";
        String filename = "";
        mockedQuestionDao.add(entity, path, filename);
    }

    /**
     * Test of add method, of class QuestionDao.
     */
	@Test
    public void testAdd_GenericType() throws Exception {
		logger.info("add");
        Question entity = null;
        mockedQuestionDao.add(entity);
    }

    /**
     * Test of add method, of class QuestionDao.
     */
	@Test
    public void testAdd_GenericType_Integer() throws Exception {
		logger.info("add");
        Question entity = null;
        Integer id = null;
        mockedQuestionDao.add(entity, id);
    }

    /**
     * Test of update method, of class QuestionDao.
     */
	@Test
    public void testUpdate() throws Exception {
		logger.info("update");
        Question entity = null;
        mockedQuestionDao.update(entity);
    }

    /**
     * Test of findAll method, of class QuestionDao.
     */
	@Test
    public void testFindAll() throws Exception {
		logger.info("findAll");
        List<Question> expResult = null;
        List<Question> result = mockedQuestionDao.findAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class QuestionDao.
     */
	@Test
    public void testFindById() throws Exception {
		logger.info("findById");
        Integer id = null;
        String prefix = "";
        Question expResult = null;
        Question result = mockedQuestionDao.findById(id, prefix);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class QuestionDao.
     */	
	@Test
    public void testDelete() throws Exception {
		logger.info("delete");
        Integer id = null;
        String prefix = "";
        mockedQuestionDao.delete(id, prefix);
    }

    /**
     * Test of choosePathForFile method, of class QuestionDao.
     */
	@Test
	public void testChoosePathForFile() throws Exception {
		logger.info("choosePathForFile");
        String expResult = "";
        String result = mockedQuestionDao.choosePathForFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRandomQuestionFromPool method, of class QuestionDao.
     */
	@Test
    public void testGetRandomQuestionFromPool() throws Exception {
		logger.info("getRandomQuestionFromPool");
        List<Question> questionPool = null;
        Question expResult = null;
        Question result = mockedQuestionDao.getRandomQuestionFromPool(questionPool);
        assertEquals(expResult, result);
    }

    /**
     * Test of populateQuestionsPool method, of class QuestionDao.
     */
	@Test
    public void testPopulateQuestionsPool_int() throws Exception {
		logger.info("populateQuestionsPool");
        int questionPoolSize = 0;
        Set<Question> expResult = null;
        Set<Question> result = mockedQuestionDao.populateQuestionsPool(questionPoolSize);
        assertEquals(expResult, result);
    }

    /**
     * Test of populateQuestionsPool method, of class QuestionDao.
     */
	@Test
    public void testPopulateQuestionsPool_int_int() throws Exception {
		logger.info("populateQuestionsPool");
        int questionPoolSize = 0;
        int answersNumberPerQuestion = 0;
        Set<Question> expResult = null;
        Set<Question> result = mockedQuestionDao.populateQuestionsPool(questionPoolSize, answersNumberPerQuestion);
        assertEquals(expResult, result);
    }

    /**
     * Test of populateQuestions method, of class QuestionDao.
     */
	@Test
    public void testPopulateQuestions_ApplicationSetting() throws Exception {
		logger.info("populateQuestions");
        ApplicationSetting settings = null;
        List<Question> expResult = null;
        List<Question> result = mockedQuestionDao.populateQuestions(settings);
        assertEquals(expResult, result);
    }

    /**
     * Test of populateQuestions method, of class QuestionDao.
     */
	@Test
    public void testPopulateQuestions_int_int() throws Exception {
		logger.info("populateQuestions");
        int questionPoolSize = 0;
        int answersNumberPerQuestion = 0;
        List<Question> expResult = null;
        List<Question> result = mockedQuestionDao.populateQuestions(questionPoolSize, answersNumberPerQuestion);
        assertEquals(expResult, result);
    }

    /**
     * Test of populateQuestions method, of class QuestionDao.
     */
	@Test
    public void testPopulateQuestions_int() throws Exception {
		logger.info("populateQuestions");
        int questionPoolSize = 0;
        List<Question> expResult = null;
        List<Question> result = mockedQuestionDao.populateQuestions(questionPoolSize);
        assertEquals(expResult, result);
    }
    
}
