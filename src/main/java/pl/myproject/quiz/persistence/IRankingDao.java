package pl.myproject.quiz.persistence;

import java.util.List;

import javax.ejb.Local;

import pl.myproject.quiz.model.Ranking;

/**
*
* @author Mariusz Czarny
*/
@Local
public interface IRankingDao extends IAbstractDao<Ranking>{
	public static final int MAX_SCORE = 10;
	public List<Ranking> populateRandomRankings(int numberOfRankings, String description);
	public Ranking populateRandomRanking(int rankingId, int numberOfUsers, String description);
}
