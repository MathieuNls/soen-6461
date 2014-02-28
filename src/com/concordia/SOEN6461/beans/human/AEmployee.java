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

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * employed Human extends human with credentials & planning
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name="EMPLOYEE")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="EMPLOYEE_TYPE",
    discriminatorType=DiscriminatorType.STRING
)
public abstract class AEmployee{

    @Column(name="FAMILY_NAME")
    private String familyName;
    
    @Column(name="GIVEN_NAME")
    private String givenName;
    
    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Adresse adresse;
    
    @Column(name="LOGIN")
    private String login;
     
    @Column(name="PASSWORD")
    private String password;
      
    @OneToOne
    @JoinColumn(name="PLANNING_ID")
    private Planning planning;
    
    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    protected int id;

    /**
     * Default constructor
     */
    protected AEmployee() {
    }
   
    /**
     * Surcharged constructor
     * @param login
     * @param password
     * @param familyName
     * @param givenName
     * @param adresse 
     */
    public AEmployee(String login, String password, String familyName, 
            String givenName, Adresse adresse) {
        this.login = login;
        this.password = password;
        this.familyName = familyName;
        this.givenName = givenName;
        this.adresse = adresse;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AEmployee other = (AEmployee) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        return true && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 7 + super.hashCode();
        hash = 97 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 97 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
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
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * 
     * @param adresse 
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    

    /**
     * 
     * @return 
     */
    public Planning getPlanning() {
        return planning;
    }

    /**
     * 
     * @param plannings 
     */
    public void setPlanning(Planning planning) {
        this.planning = planning;
    }
    
    /**
     * 
     * @return 
     */
    public String getLogin() {
        return login;
    }

    /**
     * 
     * @param login 
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * 
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
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
