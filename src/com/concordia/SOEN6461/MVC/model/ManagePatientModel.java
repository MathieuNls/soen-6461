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

import com.concordia.SOEN6461.DAO.PatientDAOImpl;
import com.concordia.SOEN6461.beans.human.Patient;
import java.util.List;

/**
 * @author Mathieu Nayrolles
 */
public class ManagePatientModel  implements IModel{
    
    private Patient selectedPatient;
    private List<Patient> patients;
    
    /**
     * 
     */
    public void init(){
        this.patients = PatientDAOImpl.getInstance().getPatients();
    }

    /**
     * 
     */
    public void deletePatient() {
        this.patients.remove(selectedPatient);
        //TODO: DELETE CASCADE ON DAO
        //PatientDAOImpl.getInstance().deletePatient(this.selectedPatient.getSin());
    }
    
    /**
     * 
     * @param patient_id 
     */
    public void setSelectedPatient(int patient_id){
        this.selectedPatient = patients.get(patient_id);
    }

    /**
     * 
     * @return 
     */
    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    /**
     * 
     * @return 
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * 
     * @param patients 
     */
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
