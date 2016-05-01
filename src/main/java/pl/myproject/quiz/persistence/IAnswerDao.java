package pl.myproject.quiz.persistence;

import java.util.List;

import javax.ejb.Local;

import pl.myproject.quiz.model.Answer;

/**
*
* @author Mariusz Czarny
*/
@Local
public interface IAnswerDao {
	public List<Answer> populateRandomAnswer(int answersNumberPerQuestion);
}