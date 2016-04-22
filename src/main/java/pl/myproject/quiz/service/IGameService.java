/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service;

import java.util.List;

import javax.ejb.Local;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.User;

/**
 *
 * @author Mariusz Czarny
 */
@Local
public interface IGameService {
    public static final int SAMPLE_GAME_ID = 1;
    public static final int BEGINNING_SCORE = 0;    
    /**
     *
     * @return
     */
    List<Game> getGameList();

    Game createNewGame(User user);
}
