/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import junit.framework.TestCase;
import pl.myproject.quiz.model.Game;
import pl.myproject.quiz.model.User;
import pl.myproject.quiz.service.IGameService;

/**
 *
 * @author XE050991049
 */
public class GameServiceTest extends TestCase {
    
    public GameServiceTest(String testName) {
        super(testName);
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
     * Test of init method, of class GameService.
     */
    public void testInit() throws Exception {
        System.out.println("init");
        GameService instance = new GameService();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameList method, of class GameService.
     */
    public void testGetGameList() throws Exception {
        System.out.println("getGameList");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IGameService instance = (IGameService)container.getContext().lookup("java:global/classes/GameService");
        List<Game> expResult = null;
        List<Game> result = instance.getGameList();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveGameResult method, of class GameService.
     */
    public void testSaveGameResult() throws Exception {
        System.out.println("saveGameResult");
        User user = null;
        Integer score = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IGameService instance = (IGameService)container.getContext().lookup("java:global/classes/GameService");
        Game expResult = null;
        Game result = instance.saveGameResult(user, score);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
