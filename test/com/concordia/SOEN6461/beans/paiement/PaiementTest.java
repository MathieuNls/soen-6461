/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concordia.SOEN6461.beans.paiement;

import com.concordia.SOEN6461.beans.appointment.Appointment;
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
public class PaiementTest {
    
    public PaiementTest() {
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
     * Test of getAppointment method, of class Paiement.
     */
    @Test
    public void testGetAppointment() {
        System.out.println("getAppointment");
        Paiement instance = null;
        Appointment expResult = null;
        Appointment result = instance.getAppointment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppointment method, of class Paiement.
     */
    @Test
    public void testSetAppointment() {
        System.out.println("setAppointment");
        Appointment appointment = null;
        Paiement instance = null;
        instance.setAppointment(appointment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaiementMethod method, of class Paiement.
     */
    @Test
    public void testGetPaiementMethod() {
        System.out.println("getPaiementMethod");
        Paiement instance = null;
        PaiementMethod expResult = null;
        PaiementMethod result = instance.getPaiementMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaiementMethod method, of class Paiement.
     */
    @Test
    public void testSetPaiementMethod() {
        System.out.println("setPaiementMethod");
        PaiementMethod paiementMethod = null;
        Paiement instance = null;
        instance.setPaiementMethod(paiementMethod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Paiement.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Paiement instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Paiement.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Paiement instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Paiement.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Paiement instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
