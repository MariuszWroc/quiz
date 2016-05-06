/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariusz Czarny
 */
@XmlRootElement
public class Ranking implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String place;
    private String description;
    private List<Game> gameList;
    
    public Ranking() {}

    public Ranking(Integer id, String place, String description, List<Game> gameList) {
        this.id = id;
        this.place = place;
        this.description = description;
        this.gameList = gameList;
    }

    public Ranking(Integer id, String description, List<Game> gameList) {
        this.id = id;
        this.description = description;
        this.gameList = gameList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    @Override
    public String toString() {
        return "Ranking{" + "id=" + id + ", place=" + place + ", description=" + description + ", gameList=" + gameList + '}';
    }
    
}
