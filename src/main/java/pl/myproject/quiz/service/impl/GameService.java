/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.service.IGameService;
/**
 *
 * @author Mariusz Czarny
 */
@Singleton
public class GameService implements IGameService{
	private List<Game> gameList;

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
        Game game = new Game(user, score);    
        gameList.add(game);
        return game;
    }
}
