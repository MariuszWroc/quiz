package pl.myproject.quiz.persistence.impl;

import static pl.myproject.quiz.util.SampleData.ANSWER;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import pl.myproject.quiz.model.Answer;
import pl.myproject.quiz.persistence.IAnswerDao;
import pl.myproject.quiz.util.RandomizeValue;

/**
*
* @author Mariusz Czarny
*/
@Stateless
public class AnswerDao implements IAnswerDao {
	@Override
    public List<Answer> populateRandomAnswer(int answersNumberPerQuestion) {
        List<Answer> questionList = new ArrayList<>();
        for (int i = 0; i < answersNumberPerQuestion; i++) {
            Answer answer = new Answer(i+1, RandomizeValue.getRandomString(ANSWER), Boolean.TRUE);
            questionList.add(answer);
        }
        return questionList;
    }
}
