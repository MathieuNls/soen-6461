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
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name="PATIENT")
@XmlRootElement
public class Patient implements Serializable{
    
    @Column(name="BIRTH_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthdate;
    
    @Column(name="NAME")
    private String familyName;
    
    @Column(name="GIVEN_NAME")
    private String givenName;
    
    @Id
    @Column(name="PATIENT_SIN")
    private int sin;
      
    @OneToMany
    @JoinColumn(name = "APPOINTMENT_ID")
    private List<Appointment> appointments;
    
    @OneToMany
    @JoinColumn(name = "PAIEMENT_ID")
    private List<Paiement> paiements;
    
    @Column(name = "GENDER")
    private String gender;
    
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public Patient() {
    }

    /**
     * Id based contruction
     * @param sin 
     */
    public Patient(int sin){
        this.sin = sin;
    }
    
    /**
     * Default Constructor
     * @param birthdate
     * @param sin
     * @param familyName
     * @param phoneNumber 
     * @param gender
     * @param givenName
     */
    public Patient(int sin, String familyName, String givenName, Date birthdate, String gender, String phoneNumber) {
        this.familyName = familyName;
        this.givenName = givenName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   /**
    * 
    * @return 
    */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender 
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

   /**
    * 
    * @return 
    */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * 
     * @param familyName 
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * 
     * @return 
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * 
     * @param givenName 
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * 
     * @return 
     */
    @XmlTransient
    @JsonIgnore
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
    @XmlTransient
    @JsonIgnore
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
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * 
     * @param birthdate 
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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
        return "Patient{" + "date=" + birthdate + ", sin=" + sin + '}';
    }
    
    public String toStringName(){
        return this.givenName + " " + this.familyName;
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
        if (this.birthdate != other.birthdate) {
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
        hash = 41 * hash + this.birthdate.hashCode();
        hash = 41 * hash + this.sin;
        return hash + super.hashCode();
    }

    public Object readableToString() {
        return this.sin + " " + this.familyName + " " + this.givenName;
    }

}
