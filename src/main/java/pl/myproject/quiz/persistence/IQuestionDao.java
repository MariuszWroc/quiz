/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import pl.myproject.quiz.model.ApplicationSetting;
import pl.myproject.quiz.model.Question;

/**
 *
 * @author Mariusz Czarny
 */
@Local
public interface IQuestionDao extends IAbstractDao<Question>{
	public Question getRandomQuestionFromPool(List<Question> questionPool);
    public Set<Question> populateQuestionsPool(int questionPoolSize);
    public Set<Question> populateQuestionsPool(int questionPoolSize, int answersNumberPerQuestion);
    public List<Question> populateQuestions(ApplicationSetting settings);
    public List<Question> populateQuestions(int questionPoolSize, int answersNumberPerQuestion);
    public List<Question> populateQuestions(int questionPoolSize);
}
