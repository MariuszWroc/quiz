package pl.myproject.quiz.persistence;

import java.util.List;

import javax.ejb.Local;

import pl.myproject.quiz.model.Game;

/**
*
* @author Mariusz Czarny
*/
@Local
public interface IGameDao extends IAbstractDao<Game>{
	/**
	 * @param numberOfGames
	 * @return
	 */
	public List<Game> populateRandomGame(int numberOfGames);
}
