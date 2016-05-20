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
import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.persistence.IRankingDao;

/**
 *
 * @author XE050991049
 */
public class RankingDaoTest extends TestCase {
    
    public RankingDaoTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(RankingDaoTest.class);
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
     * Test of convertObjectToXML method, of class RankingDao.
     */
    public void testConvertObjectToXML() throws Exception {
        System.out.println("convertObjectToXML");
        Ranking entity = null;
        String filePath = "";
        RankingDao instance = new RankingDao();
        StringWriter expResult = null;
        StringWriter result = instance.convertObjectToXML(entity, filePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertXMLToObject method, of class RankingDao.
     */
    public void testConvertXMLToObject() throws Exception {
        System.out.println("convertXMLToObject");
        String path = "";
        RankingDao instance = new RankingDao();
        Ranking expResult = null;
        Ranking result = instance.convertXMLToObject(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteXMLFile method, of class RankingDao.
     */
    public void testDeleteXMLFile() throws Exception {
        System.out.println("deleteXMLFile");
        String path = "";
        RankingDao instance = new RankingDao();
        instance.deleteXMLFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateXMLFile method, of class RankingDao.
     */
    public void testUpdateXMLFile() throws Exception {
        System.out.println("updateXMLFile");
        String path = "";
        RankingDao instance = new RankingDao();
        instance.updateXMLFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class RankingDao.
     */
    public void testAdd_3args() throws Exception {
        System.out.println("add");
        Ranking entity = null;
        String path = "";
        String filename = "";
        RankingDao instance = new RankingDao();
        instance.add(entity, path, filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class RankingDao.
     */
    public void testAdd_GenericType() throws Exception {
        System.out.println("add");
        Ranking entity = null;
        RankingDao instance = new RankingDao();
        instance.add(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class RankingDao.
     */
    public void testAdd_GenericType_Integer() throws Exception {
        System.out.println("add");
        Ranking entity = null;
        Integer id = null;
        RankingDao instance = new RankingDao();
        instance.add(entity, id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class RankingDao.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
        Ranking entity = null;
        RankingDao instance = new RankingDao();
        instance.update(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class RankingDao.
     */
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        RankingDao instance = new RankingDao();
        List<Ranking> expResult = null;
        List<Ranking> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class RankingDao.
     */
    public void testFindById() throws Exception {
        System.out.println("findById");
        Integer id = null;
        String prefix = "";
        RankingDao instance = new RankingDao();
        Ranking expResult = null;
        Ranking result = instance.findById(id, prefix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RankingDao.
     */
    public void testDelete() throws Exception {
        System.out.println("delete");
        Integer id = null;
        String prefix = "";
        RankingDao instance = new RankingDao();
        instance.delete(id, prefix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateRandomRanking method, of class RankingDao.
     */
    public void testPopulateRandomRanking() throws Exception {
        System.out.println("populateRandomRanking");
        int rankingId = 0;
        int numberOfUsers = 0;
        String description = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IRankingDao instance = (IRankingDao)container.getContext().lookup("java:global/classes/RankingDao");
        Ranking expResult = null;
        Ranking result = instance.populateRandomRanking(rankingId, numberOfUsers, description);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateRandomRankings method, of class RankingDao.
     */
    public void testPopulateRandomRankings() throws Exception {
        System.out.println("populateRandomRankings");
        int numberOfRankings = 0;
        String description = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IRankingDao instance = (IRankingDao)container.getContext().lookup("java:global/classes/RankingDao");
        List<Ranking> expResult = null;
        List<Ranking> result = instance.populateRandomRankings(numberOfRankings, description);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choosePathForFile method, of class RankingDao.
     */
    public void testChoosePathForFile() throws Exception {
        System.out.println("choosePathForFile");
        RankingDao instance = new RankingDao();
        String expResult = "";
        String result = instance.choosePathForFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
