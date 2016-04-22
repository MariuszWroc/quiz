package pl.myproject.quiz.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariusz Czarny
 */

@XmlRootElement
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
    private User user;
    private List<Question> questionList;
    private Integer timeForAnswer;
    private Integer score;

    public Game() {
    }
    
    public Game(Integer id, User user, List<Question> questionList, Integer timeForAnswer) {
        this.id = id;
        this.user = user;
        this.questionList = questionList;
        this.timeForAnswer = timeForAnswer;
    }

    public Game(Integer id, User user, Integer score, List<Question> questionList) {
        this.id = id;
        this.user = user;
        this.questionList = questionList;
        this.score = score;
    }
    
    public Game(Integer id, User user, Integer score, Integer timeForAnswer) {
        this.id = id;
        this.user = user;
        this.score = score;
        this.timeForAnswer = timeForAnswer;
    }
    
    public Game(Integer id, User user) {
        this.id = id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Integer getTimeForAnswer() {
        return timeForAnswer;
    }

    public void setTimeForAnswer(Integer timeForAnswer) {
        this.timeForAnswer = timeForAnswer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    
    @Override
    public String toString() {
        return "Game [user=" + user + ", questions=" + questionList + ", timeForAnswer=" + timeForAnswer + ", score=" + score + "]";
    }

}
