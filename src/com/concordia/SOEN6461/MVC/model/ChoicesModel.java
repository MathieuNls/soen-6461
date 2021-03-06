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

package com.concordia.SOEN6461.MVC.model;

import com.concordia.SOEN6461.DAO.AppointmentDAOImpl;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.human.Patient;

/**
 * @author Mathieu Nayrolles
 */
public class ChoicesModel  implements IModel{
    
    private Patient patient;
    private Clinic clinic;
    
    /**
     * 
     * @param patient
     * @param clinic 
     */
    public void init(Patient patient, Clinic clinic){
        this.patient = patient;
        this.clinic = clinic;
    }

    /**
     * 
     * @return 
     */
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
    public boolean isCheckupAuthorrized() {
        return AppointmentDAOImpl.getInstance().isCheckupAuthorizedByPatient(patient.getSin());
    }
   
}
