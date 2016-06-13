/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doThrow;
import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.persistence.IRankingDao;

/**
 *
 * @author Mariusz Czarny
 */
public class RankingDaoTest {
	private static final Logger logger = Logger.getLogger(RankingDaoTest.class.getName());
	private static Ranking ranking;
	private static IRankingDao mockedRankingDao;

	@BeforeClass
	public static void setUp() {
		mockedRankingDao = mock(RankingDao.class);
		
		ranking = new Ranking();
		
	}

    /**
     * Test of add method, of class RankingDao.
     */
	@Test
    public void testAdd_3args() throws Exception {
		logger.info("add");
        Ranking entity = null;
        String path = "";
        String filename = "";
        mockedRankingDao.add(entity, path, filename);
    }

    /**
     * Test of add method, of class RankingDao.
     */
	@Test
    public void testAdd_GenericType() throws Exception {
		logger.info("add");
        Ranking entity = null;
        mockedRankingDao.add(entity);
    }

    /**
     * Test of add method, of class RankingDao.
     */
	@Test
    public void testAdd_GenericType_Integer() throws Exception {
		logger.info("add");
        Ranking entity = null;
        Integer id = null;
        mockedRankingDao.add(entity, id);
    }

    /**
     * Test of update method, of class RankingDao.
     */
	@Test
    public void testUpdate() throws Exception {
		logger.info("update");
        Ranking entity = null;
        mockedRankingDao.update(entity);
    }

    /**
     * Test of findAll method, of class RankingDao.
     */
	@Test
    public void testFindAll() throws Exception {
		logger.info("findAll");
        List<Ranking> expResult = null;
        List<Ranking> result = mockedRankingDao.findAll();
    }

    /**
     * Test of findById method, of class RankingDao.
     */
	@Test
    public void testFindById() throws Exception {
		logger.info("findById");
        Integer id = null;
        String prefix = "";
        Ranking expResult = null;
        Ranking result = mockedRankingDao.findById(id, prefix);
    }

    /**
     * Test of delete method, of class RankingDao.
     */
	@Test
    public void testDelete() throws Exception {
		logger.info("delete");
        Integer id = null;
        String prefix = "";
        mockedRankingDao.delete(id, prefix);
    }

    /**
     * Test of populateRandomRanking method, of class RankingDao.
     */
	@Test
    public void testPopulateRandomRanking() throws Exception {
		logger.info("populateRandomRanking");
        int rankingId = 0;
        int numberOfUsers = 0;
        String description = "";
        Ranking expResult = null;
        Ranking result = mockedRankingDao.populateRandomRanking(rankingId, numberOfUsers, description);
    }

    /**
     * Test of populateRandomRankings method, of class RankingDao.
     */
	@Test
    public void testPopulateRandomRankings() throws Exception {
		logger.info("populateRandomRankings");
        int numberOfRankings = 0;
        String description = "";
        List<Ranking> expResult = null;
        List<Ranking> result = mockedRankingDao.populateRandomRankings(numberOfRankings, description);
    }
    
}
