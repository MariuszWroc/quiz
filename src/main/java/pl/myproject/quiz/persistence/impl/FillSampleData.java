/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import pl.myproject.quiz.model.Answer;
import pl.myproject.quiz.model.ApplicationSetting;
import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.Question;
import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.model.RankingRow;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.util.RandomizeValue;
import static pl.myproject.quiz.util.SampleData.*;
import static pl.myproject.quiz.util.constant.ApplicationValues.*;

/**
 *
 * @author Mariusz Czarny
 */
@Deprecated
public final class FillSampleData {
    private static final Logger LOGGER = Logger.getLogger(FillSampleData.class.getName());
    
    public static Question getRandomQuestionFromPool(List<Question> questionPool) {
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

    public static Set<Question> populateQuestionsPool(int questionPoolSize) {
        return populateQuestionsPool(questionPoolSize, DEFAULT_ANSWER_POOL_SIZE.getNumber());
    }

    public static Set<Question> populateQuestionsPool(int questionPoolSize, int answersNumberPerQuestion) {
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
    
    public static List<Question> populateQuestions(ApplicationSetting settings) {
        int questionPoolSize = settings.getQuestionPoolSize();
        return populateQuestions(questionPoolSize);
    }
    
    public static List<Question> populateQuestions(int questionPoolSize, int answersNumberPerQuestion) {
        List<Question> questionSet = new ArrayList<>();
        for (int i = 0; i < questionPoolSize; i++) {
            Question question = new Question(i+1, RandomizeValue.getRandomString(QUESTION), populateRandomAnswer(answersNumberPerQuestion));
            questionSet.add(question);
        }
        return questionSet;
    }

    public static List<Question> populateQuestions(int questionPoolSize) {
        return populateQuestions(questionPoolSize, DEFAULT_ANSWER_POOL_SIZE.getNumber());
    }
    
    public static List<Answer> populateRandomAnswer(int answersNumberPerQuestion) {
        List<Answer> questionList = new ArrayList<>();
        for (int i = 0; i < answersNumberPerQuestion; i++) {
            Answer answer = new Answer(i+1, RandomizeValue.getRandomString(ANSWER), Boolean.TRUE);
            questionList.add(answer);
        }
        return questionList;
    }
    
    public static Ranking populateRandomRanking(int rankingId, int numberOfUsers, String description) {
        List<RankingRow> rankingRowList = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            User user = new User(RandomizeValue.getRandomString(USER_FIRSTNAME), RandomizeValue.getRandomString(USER_SECONDNAME), SAMPLE_EMAIL);
            RankingRow rankingRow = new RankingRow(i+1, user, RandomizeValue.getRandomData(), RandomizeValue.getRandomInt(10));
            rankingRowList.add(rankingRow);
        }
        Ranking ranking = new Ranking(rankingId, description, rankingRowList);
        return ranking;
    }

     public static List<Ranking> populateRandomRankings(int numberOfRankings, String description) {
        List<Ranking> rankingList = new ArrayList<>();
        for(int i = 0; i < numberOfRankings; i++) {
            Ranking ranking = populateRandomRanking(i+1, RandomizeValue.getRandomInt(10), SAMPLE_JOB_FAIR + i);
            rankingList.add(ranking);
        }
        return rankingList;
    }
     
    public static List<Game> populateRandomGame(int numberOfGames) {
        List<Game> gameList = new ArrayList<>();
        User user = new User(RandomizeValue.getRandomString(USER_FIRSTNAME), RandomizeValue.getRandomString(USER_FIRSTNAME), SAMPLE_EMAIL);
        for (int i = 0; i < numberOfGames; i++) {
            Game game = new Game(i, user);
            gameList.add(game);
        }
        return gameList;
    }
}
