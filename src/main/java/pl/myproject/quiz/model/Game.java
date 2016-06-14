package pl.myproject.quiz.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.myproject.quiz.util.DateAdapter;
/**
 *
 * @author Mariusz Czarny
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id", "user", "date", "score", "quizTime"})
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlAttribute 
	private Integer id;
    private User user;
    @XmlElement(name = "timestamp", required = true) 
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;
    private Integer resultTime;
    private Integer score;

    public Game() {
    }
    
    public Game(Integer id, User user, Date date, Integer resultTime, Integer score) {
		this.id = id;
		this.user = user;
		this.date = date;
		this.resultTime = resultTime;
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

	public Integer getResultTime() {
		return resultTime;
	}
	
	public void setResultTime(Integer resultTime) {
		this.resultTime = resultTime;
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
    
    @Override
    public String toString() {
        return "Game [user=" + user + ", resultTime=" + resultTime + ", score=" + score + "]";
    }

}
