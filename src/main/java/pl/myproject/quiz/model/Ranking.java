/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mariusz Czarny
 */
public class Ranking implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String place;
    private String description;
    private List<RankingRow> rankingList;
    
    public Ranking() {}

    public Ranking(Integer id, String place, String description, List<RankingRow> rankingList) {
        this.id = id;
        this.place = place;
        this.description = description;
        this.rankingList = rankingList;
    }

    public Ranking(Integer id, String description, List<RankingRow> rankingList) {
        this.id = id;
        this.description = description;
        this.rankingList = rankingList;
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

    public List<RankingRow> getRankingList() {
        return rankingList;
    }

    public void setRankingList(List<RankingRow> rankingList) {
        this.rankingList = rankingList;
    }

    @Override
    public String toString() {
        return "Ranking{" + "id=" + id + ", place=" + place + ", description=" + description + ", rankingList=" + rankingList + '}';
    }
    
}
