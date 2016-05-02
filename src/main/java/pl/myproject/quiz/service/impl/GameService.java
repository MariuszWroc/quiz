/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.persistence.IGameDao;
import pl.myproject.quiz.service.IGameService;
/**
 *
 * @author Mariusz Czarny
 */
@Stateless
public class GameService implements IGameService{
	
	@Inject
	IGameDao dao;

    @Override
    public List<Game> getGameList() {
        List<Game> gameList = dao.populateRandomGame(5);
        return gameList;
    }    

    @Override
    public Game saveGameResult(User user, Integer score) {
        Game game = new Game(user, score);
        return game;
    }
}
