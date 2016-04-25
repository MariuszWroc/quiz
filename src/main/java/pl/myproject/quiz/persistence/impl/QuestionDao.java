/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.Stateless;

import pl.myproject.quiz.model.Answer;
import pl.myproject.quiz.model.ApplicationSetting;
import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.persistence.AbstractDao;
import pl.myproject.quiz.persistence.IQuestionDao;
import pl.myproject.quiz.util.RandomizeValue;
import static pl.myproject.quiz.util.SampleData.ANSWER;
import static pl.myproject.quiz.util.SampleData.QUESTION;
import static pl.myproject.quiz.util.constant.ApplicationStrings.*;
import static pl.myproject.quiz.util.constant.ApplicationValues.DEFAULT_ANSWER_POOL_SIZE;
/**
 *
 * @author Mariusz Czarny
 */
@Stateless
public class QuestionDao extends AbstractDao<Question> implements IQuestionDao{
    private static final Logger LOGGER = Logger.getLogger(QuestionDao.class.getName());
    
    @Override
    public String choosePathForFile() {
        String pathfile = DEFAULT_PATH.getName().concat(CATALOG_QUESTION.getName());

        return pathfile;
    }
    
    public Question getRandomQuestionFromPool(List<Question> questionPool) {
        Question randomQuestion = new Question();
        if (questionPool.isEmpty()) {
            LOGGER.warning("Question Pool is empty.");
        } else {
            int randomQuestionId = RandomizeValue.getRandomInt(questionPool.size());
            LOGGER.info("Question id afer randomize " + randomQuestionId);
            if ((randomQuestionId > 0) && (randomQuestionId < questionPool.size())) {
                randomQuestion = questionPool.get(randomQuestionId);
            } 
        }
        return randomQuestion;
    }

    public Set<Question> populateQuestionsPool(int questionPoolSize) {
        return populateQuestionsPool(questionPoolSize, DEFAULT_ANSWER_POOL_SIZE.getNumber());
    }

    public Set<Question> populateQuestionsPool(int questionPoolSize, int answersNumberPerQuestion) {
        Set<Question> questionSet = new HashSet<>();
        int i = 1;
        while (i != questionPoolSize) {
            Question question = new Question(i, RandomizeValue.getRandomString(QUESTION), populateRandomAnswer(answersNumberPerQuestion));
            questionSet.add(question);
            i = questionSet.size();
            LOGGER.info("Iteration number in set populate method " + i);
        }
        return questionSet;
    }
    
    public List<Question> populateQuestions(ApplicationSetting settings) {
        int questionPoolSize = settings.getQuestionPoolSize();
        return populateQuestions(questionPoolSize);
    }
    
    public List<Question> populateQuestions(int questionPoolSize, int answersNumberPerQuestion) {
        List<Question> questionSet = new ArrayList<>();
        for (int i = 0; i < questionPoolSize; i++) {
            Question question = new Question(i+1, RandomizeValue.getRandomString(QUESTION), populateRandomAnswer(answersNumberPerQuestion));
            questionSet.add(question);
        }
        return questionSet;
    }

    public List<Question> populateQuestions(int questionPoolSize) {
        return populateQuestions(questionPoolSize, DEFAULT_ANSWER_POOL_SIZE.getNumber());
    }
    
    public List<Answer> populateRandomAnswer(int answersNumberPerQuestion) {
        List<Answer> questionList = new ArrayList<>();
        for (int i = 0; i < answersNumberPerQuestion; i++) {
            Answer answer = new Answer(i+1, RandomizeValue.getRandomString(ANSWER), Boolean.TRUE);
            questionList.add(answer);
        }
        return questionList;
    }
}
