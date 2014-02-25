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

import com.concordia.SOEN6461.beans.POJO;

/**
 * @author Mathieu Nayrolles
 * Defines every humans in the system
 */
public abstract class AHuman  implements POJO{
    
    private String familyName;
    private String givenName;
    private Adresse adresse;

    /**
     * Human constructor
     * @param familyName
     * @param givenName
     * @param adresse 
     */
    public AHuman(String familyName, String givenName, Adresse adresse) {
        this.familyName = familyName;
        this.givenName = givenName;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return familyName + " " + givenName + " " + adresse;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AHuman other = (AHuman) obj;
        if ((this.familyName == null) ? (other.familyName != null) : !this.familyName.equals(other.familyName)) {
            return false;
        }
        if ((this.givenName == null) ? (other.givenName != null) : !this.givenName.equals(other.givenName)) {
            return false;
        }
        if (this.adresse != other.adresse && (this.adresse == null || !this.adresse.equals(other.adresse))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.familyName != null ? this.familyName.hashCode() : 0);
        hash = 73 * hash + (this.givenName != null ? this.givenName.hashCode() : 0);
        hash = 73 * hash + (this.adresse != null ? this.adresse.hashCode() : 0);
        return hash;
    }
    
    

    /**
     * 
     * @return Adresse
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
     * @return familyName
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
     * @return getGivenName
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * 
     * @param setGivenName 
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    
}
