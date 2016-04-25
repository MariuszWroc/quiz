package pl.myproject.quiz.persistence;

import java.util.List;

import javax.ejb.Local;

import pl.myproject.quiz.model.Game;

@Local
public interface IGameDao {
	public List<Game> populateRandomGame(int numberOfGames);
}
