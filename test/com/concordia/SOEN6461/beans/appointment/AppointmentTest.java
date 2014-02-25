/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concordia.SOEN6461.beans.appointment;

import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.beans.human.Patient;
import java.util.Date;
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
public class AppointmentTest {
    
    public AppointmentTest() {
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
     * Test of equals method, of class Appointment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Appointment instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Appointment.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Appointment instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppointmentDetails method, of class Appointment.
     */
    @Test
    public void testGetAppointmentDetails() {
        System.out.println("getAppointmentDetails");
        Appointment instance = null;
        AppointmentDetails expResult = null;
        AppointmentDetails result = instance.getAppointmentDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppointmentDetails method, of class Appointment.
     */
    @Test
    public void testSetAppointmentDetails() {
        System.out.println("setAppointmentDetails");
        AppointmentDetails appointmentDetails = null;
        Appointment instance = null;
        instance.setAppointmentDetails(appointmentDetails);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDoctor method, of class Appointment.
     */
    @Test
    public void testGetDoctor() {
        System.out.println("getDoctor");
        Appointment instance = null;
        Doctor expResult = null;
        Doctor result = instance.getDoctor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDoctor method, of class Appointment.
     */
    @Test
    public void testSetDoctor() {
        System.out.println("setDoctor");
        Doctor doctor = null;
        Appointment instance = null;
        instance.setDoctor(doctor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatient method, of class Appointment.
     */
    @Test
    public void testGetPatient() {
        System.out.println("getPatient");
        Appointment instance = null;
        Patient expResult = null;
        Patient result = instance.getPatient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPatient method, of class Appointment.
     */
    @Test
    public void testSetPatient() {
        System.out.println("setPatient");
        Patient patient = null;
        Appointment instance = null;
        instance.setPatient(patient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoom method, of class Appointment.
     */
    @Test
    public void testGetRoom() {
        System.out.println("getRoom");
        Appointment instance = null;
        Room expResult = null;
        Room result = instance.getRoom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoom method, of class Appointment.
     */
    @Test
    public void testSetRoom() {
        System.out.println("setRoom");
        Room room = null;
        Appointment instance = null;
        instance.setRoom(room);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStart method, of class Appointment.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Appointment instance = null;
        Date expResult = null;
        Date result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStart method, of class Appointment.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        Date start = null;
        Appointment instance = null;
        instance.setStart(start);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
