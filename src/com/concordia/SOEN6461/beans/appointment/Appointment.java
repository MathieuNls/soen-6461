//The MIT License (MIT)
//
//Copyright (c) 2014 - Mathieu Nayrolles
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in
//all copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//THE SOFTWARE.
package com.concordia.SOEN6461.beans.appointment;

import com.concordia.SOEN6461.beans.POJO;
import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.beans.human.Patient;
import java.util.Date;

/**
 * Defines an Appointment
 * @author Mathieu Nayrolles
 */
public class Appointment  implements POJO{
    
    private Doctor doctor;
    private Patient patient;
    private Room room;
    private Date start;
    private AppointmentDetails appointmentDetails;

    /**
     * Default constructor
     * @param doctor
     * @param patient
     * @param room
     * @param start 
     */
    public Appointment(Doctor doctor, Patient patient, Room room, Date start, AppointmentDetails appointmentDetails) {
        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
        this.start = start;
        this.appointmentDetails = appointmentDetails;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appointment other = (Appointment) obj;
        if (this.doctor != other.doctor && (this.doctor == null || !this.doctor.equals(other.doctor))) {
            return false;
        }
        if (this.patient != other.patient && (this.patient == null || !this.patient.equals(other.patient))) {
            return false;
        }
        if (this.room != other.room && (this.room == null || !this.room.equals(other.room))) {
            return false;
        }
        if (this.start != other.start && (this.start == null || !this.start.equals(other.start))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.doctor != null ? this.doctor.hashCode() : 0);
        hash = 97 * hash + (this.patient != null ? this.patient.hashCode() : 0);
        hash = 97 * hash + (this.room != null ? this.room.hashCode() : 0);
        hash = 97 * hash + (this.start != null ? this.start.hashCode() : 0);
        return hash;
    }

   /**
     * 
     * @return 
     */
    public AppointmentDetails getAppointmentDetails() {
        return appointmentDetails;
    }

    /**
     * 
     * @param appointmentDetails 
     */
    public void setAppointmentDetails(AppointmentDetails appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }
    
    
    /**
     * 
     * @return 
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * 
     * @param doctor 
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * 
     * @return 
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * 
     * @param patient 
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * 
     * @return 
     */
    public Room getRoom() {
        return room;
    }

    /**
     * 
     * @param room 
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * 
     * @return 
     */
    public Date getStart() {
        return start;
    }

    /**
     * 
     * @param start 
     */
    public void setStart(Date start) {
        this.start = start;
    }
    
   
}
