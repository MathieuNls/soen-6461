/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concordia.SOEN6461.beans.appointment;

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
public class AppointmentDetailsTest {
    
    public AppointmentDetailsTest() {
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
     * Test of values method, of class AppointmentDetails.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        AppointmentDetails[] expResult = null;
        AppointmentDetails[] result = AppointmentDetails.values();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class AppointmentDetails.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        AppointmentDetails expResult = null;
        AppointmentDetails result = AppointmentDetails.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuration method, of class AppointmentDetails.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        AppointmentDetails instance = null;
        int expResult = 0;
        int result = instance.getDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDuration method, of class AppointmentDetails.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        int duration = 0;
        AppointmentDetails instance = null;
        instance.setDuration(duration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class AppointmentDetails.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        AppointmentDetails instance = null;
        int expResult = 0;
        int result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class AppointmentDetails.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int price = 0;
        AppointmentDetails instance = null;
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPriceUnattended method, of class AppointmentDetails.
     */
    @Test
    public void testGetPriceUnattended() {
        System.out.println("getPriceUnattended");
        AppointmentDetails instance = null;
        int expResult = 0;
        int result = instance.getPriceUnattended();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPriceUnattended method, of class AppointmentDetails.
     */
    @Test
    public void testSetPriceUnattended() {
        System.out.println("setPriceUnattended");
        int priceUnattended = 0;
        AppointmentDetails instance = null;
        instance.setPriceUnattended(priceUnattended);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
