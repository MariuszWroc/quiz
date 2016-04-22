/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mariusz Czarny
 */
public class RankingRow implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
    private User user;
    private Date date;
    private Integer points;
    
    public RankingRow() {}

    public RankingRow(Integer id, User user, Date date) {
        this.id = id;
        this.user = user;
        this.date = date;
    }

    public RankingRow(Integer id, User user, Date date, Integer points) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.points = points;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "RankingRow{" + "id=" + id + ", user=" + user + ", date=" + date + ", points=" + points + '}';
    }

}
