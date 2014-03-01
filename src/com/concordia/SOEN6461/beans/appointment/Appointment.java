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

import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.beans.human.Patient;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Defines an Appointment
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name="APPOINTMENT")
public class Appointment{
    
    @Id
    @GeneratedValue
    @Column(name="APPOINTMENT_ID")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Doctor doctor;
    
    @OneToOne
    @JoinColumn(name="PATIENT_ID")
    private Patient patient;
    
    @OneToOne
    @JoinColumn(name="CLINIC_ID")
    private Clinic clinic;
    
    @OneToOne
    @JoinColumn(name="ROOM_ID")
    private Room room;
    
    @Column(name="START_DATE")
    private long start;
    
    @Column(name="TYPE") 
    @Enumerated(EnumType.ORDINAL) 
    private AppointmentDetails appointmentDetails;
    

    public Appointment() {
    }

    /**
     * Default constructor
     * @param doctor
     * @param patient
     * @param room
     * @param start 
     * @param appointmentDetails 
     * @param clinic 
     */
    public Appointment(Doctor doctor, Patient patient, Room room, long start, AppointmentDetails appointmentDetails, Clinic clinic) {
        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
        this.start = start;
        this.clinic = clinic;
        this.appointmentDetails = appointmentDetails;
    }

    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
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
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.doctor != null ? this.doctor.hashCode() : 0);
        hash = 97 * hash + (this.patient != null ? this.patient.hashCode() : 0);
        hash = 97 * hash + (this.room != null ? this.room.hashCode() : 0);
        return hash;
    }

    /**
     * 
     * @return 
     */
    public Clinic getClinic() {
        return clinic;
    }

    /**
     * 
     * @param clinic 
     */
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
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
    public long getStart() {
        return start;
    }

    /**
     * 
     * @param start 
     */
    public void setStart(long start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Appointment{" + "id=" + id + ", doctor=" + doctor + ", patient=" + patient + ", clinic=" + clinic + ", room=" + room + ", start=" + start + ", appointmentDetails=" + appointmentDetails + '}';
    }
    
    
    
   
}
