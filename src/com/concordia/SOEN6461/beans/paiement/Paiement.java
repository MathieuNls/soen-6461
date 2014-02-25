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

import com.concordia.SOEN6461.beans.POJO;
import com.concordia.SOEN6461.beans.appointment.Appointment;

/**
 * Represents the paiements of an appointment
 * @author Mathieu Nayrolles
 */
public class Paiement implements POJO{
    
    private PaiementMethod paiementMethod;
    private Appointment appointment;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.paiementMethod != null ? this.paiementMethod.hashCode() : 0);
        hash = 47 * hash + (this.appointment != null ? this.appointment.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Paiement{" + "paiementMethod=" + paiementMethod + ", appointment=" + appointment + '}';
    }
    
}
