/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.service.impl;

import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.myproject.quiz.model.User;

/**
 *
 * @author XE050991049
 */
public class UserServiceTest extends TestCase {
    
    public UserServiceTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(UserServiceTest.class);
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
     * Test of init method, of class UserService.
     */
    public void testInit() throws Exception {
        System.out.println("init");
        UserService instance = new UserService();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UserService.
     */
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        String firstname = "";
        String lastname = "";
        String email = "";
        UserService instance = new UserService();
        instance.addUser(firstname, lastname, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserService.
     */
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        Integer id = null;
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.getUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAndReturnUser method, of class UserService.
     */
    public void testAddAndReturnUser() throws Exception {
        System.out.println("addAndReturnUser");
        String firstname = "";
        String lastname = "";
        String email = "";
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.addAndReturnUser(firstname, lastname, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserList method, of class UserService.
     */
    public void testGetUserList() throws Exception {
        System.out.println("getUserList");
        UserService instance = new UserService();
        List<User> expResult = null;
        List<User> result = instance.getUserList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUserAndReturnId method, of class UserService.
     */
    public void testAddUserAndReturnId() throws Exception {
        System.out.println("addUserAndReturnId");
        String firstname = "";
        String lastname = "";
        String email = "";
        UserService instance = new UserService();
        Integer expResult = null;
        Integer result = instance.addUserAndReturnId(firstname, lastname, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
