/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service;

import java.util.List;

import javax.ejb.Local;

import pl.myproject.quiz.model.Ranking;

/**
 *
 * @author Mariusz Czarny
 */
@Local
public interface IRankingService {
    public static final String DEFAULT_DESCRIPTION = "jakis opis";

    /**
     *
     * @return
     */
    List<Ranking> getRankingList();

    /**
     *
     */
    void addRankingList();
}
