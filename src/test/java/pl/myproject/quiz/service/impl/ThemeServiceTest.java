/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.logging.Logger;

import org.junit.BeforeClass;

import pl.myproject.quiz.model.Theme;

/**
 *
 * @author Mariusz Czarny
 */
public class ThemeServiceTest {
    private static Logger logger = Logger.getLogger(ThemeServiceTest.class.getName());

    @BeforeClass
    private static void setUp() throws Exception {
    }

    /**
     * Test of init method, of class ThemeService.
     */
    public void testInit() {
        System.out.println("init");
        ThemeService instance = new ThemeService();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getThemes method, of class ThemeService.
     */
    public void testGetThemes() {
    	logger.info("getThemes");
        ThemeService instance = new ThemeService();
        Map<String, Theme> expResult = null;
        Map<String, Theme> result = instance.getThemes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
