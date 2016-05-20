/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.myproject.quiz.model.Theme;

/**
 *
 * @author XE050991049
 */
public class ThemeServiceTest extends TestCase {
    
    public ThemeServiceTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ThemeServiceTest.class);
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
        System.out.println("getThemes");
        ThemeService instance = new ThemeService();
        Map<String, Theme> expResult = null;
        Map<String, Theme> result = instance.getThemes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
