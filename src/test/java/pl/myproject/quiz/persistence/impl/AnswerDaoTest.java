/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import java.util.Arrays;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.myproject.quiz.model.Answer;

/**
 *
 * @author Mariusz Czarny
 */
public class AnswerDaoTest {
	private static final Logger logger = Logger.getLogger(AnswerDaoTest.class.getName());
	private static Answer answerOne;
	private static Answer answerTwo;
	private static Answer answerThree;
	private static AnswerDao mockedAnswerDao;
	@BeforeClass
    public static void setUp() throws Exception {
		mockedAnswerDao = mock(AnswerDao.class);
		
		init();
		
		when(mockedAnswerDao.populateRandomAnswer(3)).thenReturn(Arrays.asList(answerOne, answerTwo, answerThree));
    }

	private static void init() {
		answerOne = new Answer(1, "opis1", true); 
		answerTwo = new Answer(2, "opis2", true); 
		answerThree = new Answer(3, "opis3", true); 
	}
    
    @Test
    public void testPopulateRandomAnswer() throws Exception {
    	logger.info("populateRandomAnswer");
        List<Answer> allAnswers = mockedAnswerDao.populateRandomAnswer(3);
        assertEquals(3, allAnswers.size());
    }
    
}
