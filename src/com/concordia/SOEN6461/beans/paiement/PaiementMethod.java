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

/**
 * DifferentPaiementMethods. Paiement Method has fixed Fees (2$ per transaction)
 * and variableFees (5% of the amount)
 * @author Mathieu Nayrolles
 */
public enum PaiementMethod  implements POJO{
    CREDIT(2, 5), DEBIT(0, 0), CHECK(0, 0);
    
    private double fixedFess;
    private double variableFees;

    /**
     * Default Constructor
     * @param fixedFess
     * @param variableFees 
     */
    private PaiementMethod(double fixedFess, double variableFees) {
        this.fixedFess = fixedFess;
        this.variableFees = variableFees;
    }

    /**
     * 
     * @return 
     */
    public double getFixedFess() {
        return fixedFess;
    }

    /**
     * 
     * @param fixedFess 
     */
    public void setFixedFess(double fixedFess) {
        this.fixedFess = fixedFess;
    }

    /**
     * 
     * @return 
     */
    public double getVariableFees() {
        return variableFees;
    }

    /**
     * 
     * @param variableFees 
     */
    public void setVariableFees(double variableFees) {
        this.variableFees = variableFees;
    }
    
}
