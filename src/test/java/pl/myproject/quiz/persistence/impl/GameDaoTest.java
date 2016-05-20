/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.persistence.impl;

import java.io.StringWriter;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.persistence.IGameDao;

/**
 *
 * @author XE050991049
 */
public class GameDaoTest extends TestCase {
    
    public GameDaoTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(GameDaoTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of convertObjectToXML method, of class GameDao.
     */
    public void testConvertObjectToXML() throws Exception {
        System.out.println("convertObjectToXML");
        Game entity = null;
        String filePath = "";
        GameDao instance = new GameDao();
        StringWriter expResult = null;
        StringWriter result = instance.convertObjectToXML(entity, filePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertXMLToObject method, of class GameDao.
     */
    public void testConvertXMLToObject() throws Exception {
        System.out.println("convertXMLToObject");
        String path = "";
        GameDao instance = new GameDao();
        Game expResult = null;
        Game result = instance.convertXMLToObject(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteXMLFile method, of class GameDao.
     */
    public void testDeleteXMLFile() throws Exception {
        System.out.println("deleteXMLFile");
        String path = "";
        GameDao instance = new GameDao();
        instance.deleteXMLFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateXMLFile method, of class GameDao.
     */
    public void testUpdateXMLFile() throws Exception {
        System.out.println("updateXMLFile");
        String path = "";
        GameDao instance = new GameDao();
        instance.updateXMLFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class GameDao.
     */
    public void testAdd_3args() throws Exception {
        System.out.println("add");
        Game entity = null;
        String path = "";
        String filename = "";
        GameDao instance = new GameDao();
        instance.add(entity, path, filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class GameDao.
     */
    public void testAdd_GenericType() throws Exception {
        System.out.println("add");
        Game entity = null;
        GameDao instance = new GameDao();
        instance.add(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class GameDao.
     */
    public void testAdd_GenericType_Integer() throws Exception {
        System.out.println("add");
        Game entity = null;
        Integer id = null;
        GameDao instance = new GameDao();
        instance.add(entity, id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class GameDao.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
        Game entity = null;
        GameDao instance = new GameDao();
        instance.update(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class GameDao.
     */
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        GameDao instance = new GameDao();
        List<Game> expResult = null;
        List<Game> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class GameDao.
     */
    public void testFindById() throws Exception {
        System.out.println("findById");
        Integer id = null;
        String prefix = "";
        GameDao instance = new GameDao();
        Game expResult = null;
        Game result = instance.findById(id, prefix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class GameDao.
     */
    public void testDelete() throws Exception {
        System.out.println("delete");
        Integer id = null;
        String prefix = "";
        GameDao instance = new GameDao();
        instance.delete(id, prefix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choosePathForFile method, of class GameDao.
     */
    public void testChoosePathForFile() throws Exception {
        System.out.println("choosePathForFile");
        GameDao instance = new GameDao();
        String expResult = "";
        String result = instance.choosePathForFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateRandomGame method, of class GameDao.
     */
    public void testPopulateRandomGame() throws Exception {
        System.out.println("populateRandomGame");
        int numberOfGames = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IGameDao instance = (IGameDao)container.getContext().lookup("java:global/classes/GameDao");
        List<Game> expResult = null;
        List<Game> result = instance.populateRandomGame(numberOfGames);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
