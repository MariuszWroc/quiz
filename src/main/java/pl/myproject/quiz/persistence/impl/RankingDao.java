package pl.myproject.quiz.persistence.impl;

import static pl.myproject.quiz.util.SampleData.SAMPLE_EMAIL;
import static pl.myproject.quiz.util.SampleData.SAMPLE_JOB_FAIR;
import static pl.myproject.quiz.util.SampleData.USER_FIRSTNAME;
import static pl.myproject.quiz.util.SampleData.USER_SECONDNAME;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;

import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.model.RankingRow;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.persistence.IRankingDao;
import pl.myproject.quiz.util.RandomizeValue;

/**
*
* @author Mariusz Czarny
*/
@Stateless
public class RankingDao implements IRankingDao{
    private static final Logger LOGGER = Logger.getLogger(RankingDao.class.getName());
    
    @Override
    public Ranking populateRandomRanking(int rankingId, int numberOfUsers, String description) {
        List<RankingRow> rankingRowList = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            User user = new User(RandomizeValue.getRandomString(USER_FIRSTNAME), RandomizeValue.getRandomString(USER_SECONDNAME), SAMPLE_EMAIL);
            RankingRow rankingRow = new RankingRow(i+1, user, RandomizeValue.getRandomData(), RandomizeValue.getRandomInt(10));
            rankingRowList.add(rankingRow);
        }
        Ranking ranking = new Ranking(rankingId, description, rankingRowList);
        return ranking;
    }

    @Override
     public List<Ranking> populateRandomRankings(int numberOfRankings, String description) {
        List<Ranking> rankingList = new ArrayList<>();
        for(int i = 0; i < numberOfRankings; i++) {
            Ranking ranking = populateRandomRanking(i+1, RandomizeValue.getRandomInt(10), SAMPLE_JOB_FAIR + i);
            rankingList.add(ranking);
        }
        return rankingList;
    }
}
