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
import javax.persistence.CascadeType;
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
import javax.persistence.Table;

/**
 * Emploted Humain extends humain with credentials & planning
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name="EMPLOYED")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="EMPLOYEE_TYPE",
    discriminatorType=DiscriminatorType.STRING
)
public abstract class AEmployedHumain extends AHuman{

    @Id
    @GeneratedValue
    @Column(name="EMPLOYEE_ID")
    private int id;
    
    @Column(name="LOGIN")
    private String login;
     
    @Column(name="PASSWORD")
    private String password;
      
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="PLANNING_ID")
    private List<Planning> plannings;

    /**
     * Surcharged constructor
     * @param login
     * @param password
     * @param familyName
     * @param givenName
     * @param adresse 
     */
    public AEmployedHumain(String login, String password, String familyName, 
            String givenName, Adresse adresse) {
        super(familyName, givenName, adresse);
        this.login = login;
        this.password = password;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AEmployedHumain other = (AEmployedHumain) obj;
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
    public List<Planning> getPlannings() {
        return plannings;
    }

    /**
     * 
     * @param plannings 
     */
    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
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
    
}
