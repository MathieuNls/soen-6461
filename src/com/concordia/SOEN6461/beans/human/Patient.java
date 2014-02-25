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
package com.concordia.SOEN6461.beans.human;

import com.concordia.SOEN6461.beans.appointment.Appointment;
import com.concordia.SOEN6461.beans.paiement.Paiement;
import java.util.List;

/**
 * @author Mathieu Nayrolles
 */
public class Patient extends AHuman{
    
    private int age;
    private int sin;
    private List<Appointment> appointments;
    private List<Paiement> paiements;

    /**
     * Default Constructor
     * @param age
     * @param sin
     * @param familyName
     * @param givenName
     * @param adresse 
     */
    public Patient(int age, int sin, String familyName, String givenName, Adresse adresse) {
        super(familyName, givenName, adresse);
        this.age = age;
        this.sin = sin;
    }
    
    /**
     * add an appointment
     * @param appointment 
     */
    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }

    /**
     * Add a paiement for unattended appointment
     * @param paiement 
     */
   public void addPaiement(Paiement paiement){
       this.paiements.add(paiement);
   }

    /**
     * 
     * @return 
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * 
     * @param appointments 
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * 
     * @return 
     */
    public List<Paiement> getPaiements() {
        return paiements;
    }

    /**
     * 
     * @param paiements 
     */
    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
    
   /**
     * 
     * @return 
     */
    public int getAge() {
        return age;
    }

    /**
     * 
     * @param age 
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 
     * @return 
     */
    public int getSin() {
        return sin;
    }

    /**
     * 
     * @param sin 
     */
    public void setSin(int sin) {
        this.sin = sin;
    }
    
     @Override
    public String toString() {
        return "Patient{" + "age=" + age + ", sin=" + sin + '}';
    }
   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.sin != other.sin) {
            return false;
        }
        return true && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.age;
        hash = 41 * hash + this.sin;
        return hash + super.hashCode();
    }
    
}
