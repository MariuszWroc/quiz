package pl.myproject.quiz.persistence.impl;

import static pl.myproject.quiz.util.SampleData.SAMPLE_EMAIL;
import static pl.myproject.quiz.util.SampleData.USER_FIRSTNAME;
import static pl.myproject.quiz.util.constant.ApplicationStrings.CATALOG_RANKING;
import static pl.myproject.quiz.util.constant.ApplicationStrings.DEFAULT_PATH_LINUX;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.persistence.AbstractDao;
import pl.myproject.quiz.persistence.IGameDao;
import pl.myproject.quiz.util.RandomizeValue;

/**
*
* @author Mariusz Czarny
*/
@Stateless
public class GameDao extends AbstractDao<Game> implements IGameDao{
    private static final int MAX_POINTS_IN_QUIZ = 10;

	@Override
    public String choosePathForFile() {
        String pathfile = DEFAULT_PATH_LINUX.getName().concat(CATALOG_RANKING.getName());

        return pathfile;
    }
    
    @Override
    public List<Game> populateRandomGame(int numberOfGames) {
        List<Game> gameList = new ArrayList<>();
        User user = new User(RandomizeValue.getRandomString(USER_FIRSTNAME), RandomizeValue.getRandomString(USER_FIRSTNAME), SAMPLE_EMAIL);
        for (int i = 0; i < numberOfGames; i++) {
            Game game = new Game(i, user, RandomizeValue.getRandomInt(MAX_POINTS_IN_QUIZ));
            gameList.add(game);
        }
        return gameList;
    }
}
