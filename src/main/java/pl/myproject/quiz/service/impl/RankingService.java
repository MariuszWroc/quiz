/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.List;

import javax.inject.Singleton;

import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.service.IRankingService;
import pl.myproject.quiz.persistence.impl.FillSampleData;

/**
 *
 * @author Mariusz Czarny
 */
@Singleton
public class RankingService implements IRankingService{

    @Override
    public List<Ranking> getRankingList() {
        List<Ranking> rankingList = FillSampleData.populateRandomRankings(3, DEFAULT_DESCRIPTION);
        return rankingList;
    }

    @Override
    public void addRankingList() {
        
    }    

}
