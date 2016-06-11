/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;


import org.junit.BeforeClass;

import pl.myproject.quiz.model.Ranking;
import pl.myproject.quiz.service.IRankingService;

/**
 *
 * @author Mariusz Czarny
 */
public class RankingServiceTest {
    private static Logger logger = Logger.getLogger(RankingServiceTest.class.getName());
    
    @BeforeClass
    private static void setUp() throws Exception {
    }

    /**
     * Test of getRankingList method, of class RankingService.
     */
    public void testGetRankingList() throws Exception {
    	logger.info("getRankingList");
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
    	logger.info("addRankingList");
        Ranking entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IRankingService instance = (IRankingService)container.getContext().lookup("java:global/classes/RankingService");
        instance.addRankingList(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
