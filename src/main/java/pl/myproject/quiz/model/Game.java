package pl.myproject.quiz.model;

import java.io.Serializable;
import java.util.Date;

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
    private Date date;
    private Integer timeForAnswer;
    private Integer score;

    public Game() {
    }
    
    public Game(Integer id, User user, Date date, Integer resultTime, Integer score) {
		this.id = id;
		this.user = user;
		this.date = date;
		this.timeForAnswer = resultTime;
		this.score = score;
	}
    
	public Game(Integer id, User user, Integer score) {
		this.id = id;
		this.user = user;
		this.score = score;
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
    
    public Date getDate() {
		return date;
	}
    
    public void setDate(Date date) {
		this.date = date;
	}
}