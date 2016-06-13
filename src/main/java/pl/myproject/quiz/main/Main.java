/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.main;

import static pl.myproject.quiz.util.SampleData.QUESTION;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import pl.myproject.quiz.model.Answer;
import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.persistence.IAnswerDao;
import pl.myproject.quiz.persistence.IQuestionDao;
import pl.myproject.quiz.persistence.impl.AnswerDao;
import pl.myproject.quiz.persistence.impl.QuestionDao;
import pl.myproject.quiz.service.IQuestionService;
import pl.myproject.quiz.service.impl.QuestionService;
import pl.myproject.quiz.util.RandomizeValue;

/**
 *
 * @author Mariusz Czarny
 */
public class Main {

	

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unused")
	public static void main(String[] args) {
        IQuestionDao dao = new QuestionDao();
		Set<Question> populateQuestionsPool = dao.populateQuestionsPool(10);
        IAnswerDao answerDao = new AnswerDao();
		answerDao.populateRandomAnswer(4);
		RandomizeValue.getRandomString(QUESTION);
		if (populateQuestionsPool != null) {
			System.out.println(populateQuestionsPool.size());
		}
		
    }

    @SuppressWarnings("unused")
	private static void printCollection(Collection<?> collection) {
        collection.forEach(p -> System.out.println(p.toString()));
    }

    @SuppressWarnings("unused")
	private static Question createQuestion() {
        List<Answer> answers = new ArrayList<>();
        Question question = new Question(1, "opis", answers);
        Answer answer = new Answer(1, "pyt", true, question);
        answers.add(answer);
        System.out.println("question " + question.toString());
        return question;
    }
}
