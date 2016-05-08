/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.persistence.IRankingDao;
import pl.myproject.quiz.service.IGameService;
import pl.myproject.quiz.service.IRankingService;

/**
 *
 * @author Mariusz Czarny
 */
@Singleton
public class RankingService implements IRankingService{
	private List<Ranking> rankingList;
	@Inject
	private IRankingDao dao;
	@Inject
	private IGameService gameService;
	
	@PostConstruct
	public void init() {
		rankingList = new ArrayList<Ranking>();
	}

    @Override
    public List<Ranking> getRankingList() {
    	//TODO: Should be read from catalog
    	List<Ranking> rankingList = dao.populateRandomRankings(DEFAULT_NUMBER_OF_EVENTS, DEFAULT_DESCRIPTION);
    	
        return rankingList;
    }

    @Override
    public void addRankingList(Ranking entity) {
    	dao.add(entity);
    }    

}
