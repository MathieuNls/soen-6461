/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concordia.SOEN6461.beans;

import com.concordia.SOEN6461.beans.human.Planning;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author math
 */
public class RoomTest {
    
    public RoomTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPlanning method, of class Room.
     */
    @Test
    public void testGetPlanning() {
        System.out.println("getPlanning");
        Room instance = null;
        Planning expResult = null;
        Planning result = instance.getPlanning();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlanning method, of class Room.
     */
    @Test
    public void testSetPlanning() {
        System.out.println("setPlanning");
        Planning planning = null;
        Room instance = null;
        instance.setPlanning(planning);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuilding method, of class Room.
     */
    @Test
    public void testGetBuilding() {
        System.out.println("getBuilding");
        Room instance = null;
        String expResult = "";
        String result = instance.getBuilding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBuilding method, of class Room.
     */
    @Test
    public void testSetBuilding() {
        System.out.println("setBuilding");
        String building = "";
        Room instance = null;
        instance.setBuilding(building);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFloor method, of class Room.
     */
    @Test
    public void testGetFloor() {
        System.out.println("getFloor");
        Room instance = null;
        int expResult = 0;
        int result = instance.getFloor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFloor method, of class Room.
     */
    @Test
    public void testSetFloor() {
        System.out.println("setFloor");
        int floor = 0;
        Room instance = null;
        instance.setFloor(floor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGivenName method, of class Room.
     */
    @Test
    public void testGetGivenName() {
        System.out.println("getGivenName");
        Room instance = null;
        String expResult = "";
        String result = instance.getGivenName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGivenName method, of class Room.
     */
    @Test
    public void testSetGivenName() {
        System.out.println("setGivenName");
        String givenName = "";
        Room instance = null;
        instance.setGivenName(givenName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumber method, of class Room.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        Room instance = null;
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber method, of class Room.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 0;
        Room instance = null;
        instance.setNumber(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
