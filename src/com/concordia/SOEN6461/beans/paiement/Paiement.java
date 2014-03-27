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
package com.concordia.SOEN6461.beans.paiement;

import com.concordia.SOEN6461.beans.appointment.Appointment;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents the paiements of an appointment
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name="PAIEMENT")
@XmlRootElement
public class Paiement{
    
    @Id
    @GeneratedValue
    @Column(name="PAIEMENT_ID")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "PAIEMENTMETHOD_ID")
    private PaiementMethod paiementMethod;
    
    @OneToOne
    @JoinColumn(name = "APPOINTMENT_ID")
    private Appointment appointment;

    public Paiement() {
    }

    /**
     * Default Constructor
     * @param paiementMethod
     * @param appointment 
     */
    public Paiement(PaiementMethod paiementMethod, Appointment appointment) {
        this.paiementMethod = paiementMethod;
        this.appointment = appointment;
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
    

    /**
     * 
     * @return 
     */
    public Appointment getAppointment() {
        return appointment;
    }

    /**
     * 
     * @param appointment 
     */
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    /**
     * 
     * @return 
     */
    public PaiementMethod getPaiementMethod() {
        return paiementMethod;
    }

    /**
     * 
     * @param paiementMethod 
     */
    public void setPaiementMethod(PaiementMethod paiementMethod) {
        this.paiementMethod = paiementMethod;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paiement other = (Paiement) obj;
        if (this.paiementMethod != other.paiementMethod) {
            return false;
        }
        if (this.appointment != other.appointment && (this.appointment == null || !this.appointment.equals(other.appointment))) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.paiementMethod != null ? this.paiementMethod.hashCode() : 0);
        hash = 47 * hash + (this.appointment != null ? this.appointment.hashCode() : 0);
        return hash;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Paiement{" + "paiementMethod=" + paiementMethod + ", appointment=" + appointment + '}';
    }
    
}
