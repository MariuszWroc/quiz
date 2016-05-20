/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.service.IRankingService;

/**
 *
 * @author XE050991049
 */
public class RankingServiceTest extends TestCase {
    
    public RankingServiceTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(RankingServiceTest.class);
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
     * Test of getRankingList method, of class RankingService.
     */
    public void testGetRankingList() throws Exception {
        System.out.println("getRankingList");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IRankingService instance = (IRankingService)container.getContext().lookup("java:global/classes/RankingService");
        List<Ranking> expResult = null;
        List<Ranking> result = instance.getRankingList();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRankingList method, of class RankingService.
     */
    public void testAddRankingList() throws Exception {
        System.out.println("addRankingList");
        Ranking entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IRankingService instance = (IRankingService)container.getContext().lookup("java:global/classes/RankingService");
        instance.addRankingList(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
