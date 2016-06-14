/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.persistence.IGameDao;
import pl.myproject.quiz.service.IGameService;
/**
 *
 * @author Mariusz Czarny
 */
@Singleton
public class GameService implements IGameService{
    private static final Logger LOGGER = Logger.getLogger(GameService.class.getName());
	private List<Game> gameList;
	
	@Inject
	private IGameDao dao;

	@PostConstruct
	public void init() {
		gameList = new ArrayList<Game>();
	}
	
    @Override
    public List<Game> getGameList() {
        return gameList;
    }    

    @Override
    public Game saveGameResult(User user, Integer score) {
    	LOGGER.info("Running saveGameResult, score is " + score);
    	int id = 1; //TODO: generate incrementation
        Game game = new Game(id, user, score);    
        gameList.add(game);
        dao.add(game);
        return game;
    }
}
