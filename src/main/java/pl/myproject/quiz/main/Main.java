/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import pl.myproject.quiz.model.Answer;
import pl.myproject.quiz.model.ApplicationSetting;
import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.persistence.IQuestionDao;
import pl.myproject.quiz.persistence.impl.QuestionDao;
import pl.myproject.quiz.service.IQuestionService;
import pl.myproject.quiz.service.impl.QuestionService;
import pl.myproject.quiz.persistence.impl.FillSampleData;
import static pl.myproject.quiz.util.constant.ApplicationValues.DEFAULT_QUESTION_POOL_SIZE;

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
        IQuestionService service = new QuestionService();
        IQuestionDao dao = new QuestionDao();
//        ISettingDao dao = new SettingDao();
//        dao.add(createQuestion(), ApplicationStrings.DEFAULT_CATALOG.getName(), createQuestion().getId().toString());

        List<Question> questionPool = QuestionDao.populateQuestions(DEFAULT_QUESTION_POOL_SIZE.getNumber());
        ApplicationSetting setting = new ApplicationSetting();

        
//        for (Question entity : questionPool) {
//            dao.add(questionPool.get(0), entity.getId());
//        }
//        dao.add(setting);
        Set<Question> populateQuestionsPool = QuestionDao.populateQuestionsPool(10);
                printCollection(populateQuestionsPool);
    }

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
