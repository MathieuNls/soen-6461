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

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name = "ADDRESS")
@XmlRootElement
public class Adresse implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private int id;
    
    @Column(name = "STREET_NUMBER")
    private int streetNumber;
    
    @Column(name = "APP_NUMBER")
    private int appNumber;
    
    @Column(name = "STREET")
    private String street;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "ZIPCODE")
    private String zipCode;
    
    @Column(name = "STATE")
    private String state;
    
    @Column(name = "COUNTRY")
    private String country;

    public Adresse() {
    }


    /**
     * Global constructor for adresses.
     * @param streetNumber
     * @param appNumber
     * @param street
     * @param city
     * @param zipCode
     * @param state
     * @param country 
     */
    public Adresse(int streetNumber, int appNumber, String street, String city, String zipCode, String state, String country) {
        this.streetNumber = streetNumber;
        this.appNumber = appNumber;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }
    
    /**
     * @return formatedAdresse
     */
    @Override
    public String toString(){
        return  this.streetNumber  + " " +  this.appNumber  + " " +  this.street  + " " +  this.city 
        + this.zipCode + " " + this.state  + " " + this.country;
    }

    /**
     * Standard equalis
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adresse other = (Adresse) obj;
        if (this.streetNumber != other.streetNumber) {
            return false;
        }
        if (this.appNumber != other.appNumber) {
            return false;
        }
        if ((this.street == null) ? (other.street != null) : !this.street.equals(other.street)) {
            return false;
        }
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)) {
            return false;
        }
        if ((this.zipCode == null) ? (other.zipCode != null) : !this.zipCode.equals(other.zipCode)) {
            return false;
        }
        if ((this.state == null) ? (other.state != null) : !this.state.equals(other.state)) {
            return false;
        }
        if ((this.country == null) ? (other.country != null) : !this.country.equals(other.country)) {
            return false;
        }
        return true;
    }

    /**
     * Standard hashCode
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.streetNumber;
        hash = 67 * hash + this.appNumber;
        hash = 67 * hash + (this.street != null ? this.street.hashCode() : 0);
        hash = 67 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 67 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        hash = 67 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 67 * hash + (this.country != null ? this.country.hashCode() : 0);
        return hash;
    }
    
    
    
    /**
     * 
     * @return appNumber
     */
    public int getAppNumber() {
        return appNumber;
    }

    /**
     * 
     * @param appNumber 
     */
    public void setAppNumber(int appNumber) {
        this.appNumber = appNumber;
    }

    /**
     * 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country 
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return getState
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state 
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * 
     * @param street 
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 
     * @return streetNumber
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * 
     * @param streetNumber 
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * 
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

       /**
     * 
     * @param zipCode 
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
    
    
}
