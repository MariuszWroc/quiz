/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import static pl.myproject.quiz.util.constant.ApplicationValues.DEFAULT_STARTING_SCORE;
import static pl.myproject.quiz.util.constant.ApplicationValues.DEFAULT_TIME_FOR_ANSWER;

import java.util.List;

import javax.ejb.Stateless;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.service.IGameService;
import pl.myproject.quiz.util.FillSampleData;
/**
 *
 * @author Mariusz Czarny
 */
@Stateless
public class GameService implements IGameService{

    @Override
    public List<Game> getGameList() {
        List<Game> gameList = FillSampleData.populateRandomGame(5);
        return gameList;
    }    

    @Override
    public Game createNewGame(User user) {
        Game game = new Game(SAMPLE_GAME_ID, user, DEFAULT_STARTING_SCORE.getNumber(), DEFAULT_TIME_FOR_ANSWER.getNumber());
        return game;
    }
}
