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
package com.concordia.SOEN6461.beans;

import com.concordia.SOEN6461.beans.human.AEmployee;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.beans.human.Nurse;
import com.concordia.SOEN6461.beans.human.Patient;
import com.concordia.SOEN6461.beans.paiement.PaiementMethod;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Defines a clinic
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name="CLINIC")
public class Clinic implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="CLINIC_ID")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @OneToMany(targetEntity=Room.class)
    private List<Room> rooms;
    
    @OneToMany(targetEntity=AEmployee.class)
    private List<AEmployee> employees;
    
    @ManyToMany(targetEntity=Patient.class)
    private List<Patient> patients;
    
    @OneToMany(targetEntity=PaiementMethod.class)
    @Enumerated(EnumType.ORDINAL) 
    private List<PaiementMethod> paiementMethods;

    public Clinic() {
    }

    /**
     * Default COnstuctor
     * @param id
     * @param name
     * @param rooms
     * @param doctors
     * @param nurses
     * @param patients
     * @param paiementMethods 
     */
    public Clinic(String name, List<Room> rooms,List<AEmployee> employees, List<Patient> patients, List<PaiementMethod> paiementMethods) {
        this.name = name;
        this.rooms = rooms;
        this.employees = employees;
        this.patients = patients;
        this.paiementMethods = paiementMethods;
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
    public List<AEmployee> getEmployees() {
        return employees;
    }

    /**
     * 
     * @param employees 
     */
    public void setEmployees(List<AEmployee> employees) {
        this.employees = employees;
    }
    
   

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

     /* 
     * @return 
     */
    public List<PaiementMethod> getPaiementMethods() {
        return paiementMethods;
    }

    /**
     * 
     * @param paiementMethods 
     */
    public void setPaiementMethods(List<PaiementMethod> paiementMethods) {
        this.paiementMethods = paiementMethods;
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

    /**
     * 
     * @return 
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * 
     * @param rooms 
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    
}
