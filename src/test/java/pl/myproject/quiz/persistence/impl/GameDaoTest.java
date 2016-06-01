/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;
import java.util.List;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import pl.myproject.quiz.model.Game;

/**
 *
 * @author Mariusz Czarny
 */
public class GameDaoTest {
	private static final Logger logger = Logger.getLogger(GameDaoTest.class.getName());
	private static Game game;
	private static GameDao mockedGameDao;

	@BeforeClass
	protected void setUp() {
		mockedGameDao = mock(GameDao.class);
		
		game = new Game();
		
		doThrow(new Exception()).when(mockedGameDao).add(game);
	}
    /**
     * Test of convertObjectToXML method, of class GameDao.
     */
	@Test	
    public void testConvertObjectToXML() throws Exception {
		logger.info("convertObjectToXML");
        Game entity = null;
        String filePath = "";
        StringWriter expResult = null;
        StringWriter result = mockedGameDao.convertObjectToXML(entity, filePath);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertXMLToObject method, of class GameDao.
     */
	@Test
    public void testConvertXMLToObject() throws Exception {
		logger.info("convertXMLToObject");
        String path = "";
        Game expResult = null;
        Game result = mockedGameDao.convertXMLToObject(path);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteXMLFile method, of class GameDao.
     */
	@Test
    public void testDeleteXMLFile() throws Exception {
		logger.info("deleteXMLFile");
        String path = "";
        mockedGameDao.deleteXMLFile(path);
    }

    /**
     * Test of updateXMLFile method, of class GameDao.
     */
	@Test
    public void testUpdateXMLFile() throws Exception {
		logger.info("updateXMLFile");
        String path = "";
        mockedGameDao.updateXMLFile(path);
    }

    /**
     * Test of add method, of class GameDao.
     */
	@Test
    public void testAdd_3args() throws Exception {
		logger.info("add");
        Game entity = null;
        String path = "";
        String filename = "";
        mockedGameDao.add(entity, path, filename);
    }

    /**
     * Test of add method, of class GameDao.
     */
	@Test
    public void testAdd_GenericType() throws Exception {
		logger.info("add");
        Game entity = null;
        mockedGameDao.add(entity);
    }

    /**
     * Test of add method, of class GameDao.
     */
	@Test
    public void testAdd_GenericType_Integer() throws Exception {
		logger.info("add");
        Game entity = null;
        Integer id = null;
        mockedGameDao.add(entity, id);
    }

    /**
     * Test of update method, of class GameDao.
     */
	@Test
    public void testUpdate() throws Exception {
		logger.info("update");
        Game entity = null;
        mockedGameDao.update(entity);
    }

    /**
     * Test of findAll method, of class GameDao.
     */
	@Test
    public void testFindAll() throws Exception {
		logger.info("findAll");
        List<Game> expResult = null;
        List<Game> result = mockedGameDao.findAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class GameDao.
     */
	@Test
    public void testFindById() throws Exception {
		logger.info("findById");
        Integer id = null;
        String prefix = "";
        Game expResult = null;
        Game result = mockedGameDao.findById(id, prefix);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class GameDao.
     */
	@Test
    public void testDelete() throws Exception {
		logger.info("delete");
        Integer id = null;
        String prefix = "";
        mockedGameDao.delete(id, prefix);
    }

    /**
     * Test of choosePathForFile method, of class GameDao.
     */
	@Test
    public void testChoosePathForFile() throws Exception {
		logger.info("choosePathForFile");
        String expResult = "";
        String result = mockedGameDao.choosePathForFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of populateRandomGame method, of class GameDao.
     */
	@Test
    public void testPopulateRandomGame() throws Exception {
		logger.info("populateRandomGame");
        int numberOfGames = 0;
        List<Game> expResult = null;
        List<Game> result = mockedGameDao.populateRandomGame(numberOfGames);
        assertEquals(expResult, result);
    }
    
}
