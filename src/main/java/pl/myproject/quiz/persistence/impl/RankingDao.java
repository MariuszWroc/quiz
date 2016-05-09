package pl.myproject.quiz.persistence.impl;

import static pl.myproject.quiz.util.SampleData.SAMPLE_EMAIL;
import static pl.myproject.quiz.util.SampleData.SAMPLE_JOB_FAIR;
import static pl.myproject.quiz.util.SampleData.USER_FIRSTNAME;
import static pl.myproject.quiz.util.SampleData.USER_SECONDNAME;
import static pl.myproject.quiz.util.constant.ApplicationStrings.CATALOG_RANKING;
import static pl.myproject.quiz.util.constant.ApplicationStrings.DEFAULT_PATH_LINUX;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.persistence.AbstractDao;
import pl.myproject.quiz.persistence.IRankingDao;
import pl.myproject.quiz.util.RandomizeValue;

/**
*
* @author Mariusz Czarny
*/
@Stateless
public class RankingDao extends AbstractDao<Ranking> implements IRankingDao{
    
    @Override
    public Ranking populateRandomRanking(int rankingId, int numberOfUsers, String description) {
        List<Game> gameList = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            User user = new User(RandomizeValue.getRandomString(USER_FIRSTNAME), RandomizeValue.getRandomString(USER_SECONDNAME), SAMPLE_EMAIL);
            Game game = new Game(i+1, user, RandomizeValue.getRandomInt(MAX_SCORE), RandomizeValue.getRandomData(), RandomizeValue.getRandomInt(MAX_SCORE));
            gameList.add(game);
        }
        Ranking ranking = new Ranking(rankingId, description, gameList);
        return ranking;
    }

    @Override
     public List<Ranking> populateRandomRankings(int numberOfRankings, String description) {
        List<Ranking> rankingList = new ArrayList<>();
        for(int i = 0; i < numberOfRankings; i++) {
            Ranking ranking = populateRandomRanking(i+1, RandomizeValue.getRandomInt(MAX_SCORE), SAMPLE_JOB_FAIR + i);
            rankingList.add(ranking);
        }
        return rankingList;
    }

	@Override
	public String choosePathForFile() {
        String pathfile = DEFAULT_PATH_LINUX.getName().concat(CATALOG_RANKING.getName());

        return pathfile;
	}
}
