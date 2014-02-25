/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concordia.SOEN6461.beans.human;

import com.concordia.SOEN6461.beans.appointment.Appointment;
import com.concordia.SOEN6461.beans.paiement.Paiement;
import java.util.List;
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
public class PatientTest {
    
    public PatientTest() {
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
     * Test of addAppointment method, of class Patient.
     */
    @Test
    public void testAddAppointment() {
        System.out.println("addAppointment");
        Appointment appointment = null;
        Patient instance = null;
        instance.addAppointment(appointment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPaiement method, of class Patient.
     */
    @Test
    public void testAddPaiement() {
        System.out.println("addPaiement");
        Paiement paiement = null;
        Patient instance = null;
        instance.addPaiement(paiement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppointments method, of class Patient.
     */
    @Test
    public void testGetAppointments() {
        System.out.println("getAppointments");
        Patient instance = null;
        List expResult = null;
        List result = instance.getAppointments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppointments method, of class Patient.
     */
    @Test
    public void testSetAppointments() {
        System.out.println("setAppointments");
        List<Appointment> appointments = null;
        Patient instance = null;
        instance.setAppointments(appointments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaiements method, of class Patient.
     */
    @Test
    public void testGetPaiements() {
        System.out.println("getPaiements");
        Patient instance = null;
        List expResult = null;
        List result = instance.getPaiements();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaiements method, of class Patient.
     */
    @Test
    public void testSetPaiements() {
        System.out.println("setPaiements");
        List<Paiement> paiements = null;
        Patient instance = null;
        instance.setPaiements(paiements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Patient.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Patient instance = null;
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAge method, of class Patient.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 0;
        Patient instance = null;
        instance.setAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSin method, of class Patient.
     */
    @Test
    public void testGetSin() {
        System.out.println("getSin");
        Patient instance = null;
        int expResult = 0;
        int result = instance.getSin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSin method, of class Patient.
     */
    @Test
    public void testSetSin() {
        System.out.println("setSin");
        int sin = 0;
        Patient instance = null;
        instance.setSin(sin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Patient.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Patient instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Patient.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Patient instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Patient.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Patient instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
