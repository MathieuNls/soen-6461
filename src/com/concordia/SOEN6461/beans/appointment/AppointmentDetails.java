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
package com.concordia.SOEN6461.beans.appointment;

/**
 * Defines different type of appointments
 * @author Mathieu Nayrolles
 */
public enum AppointmentDetails {
    NORMAL(15, 0, 100),
    CHECKUP(60, 0, 200);
    
    private int price;
    private int priceUnattended;
    private int duration;

    /**
     * Default constructor. The constructor is private as the values are in
     * the enum def. No one should be able to create type outside this scope.
     * @param duration
     * @param price
     * @param priceUnattended 
     */
    private AppointmentDetails(int duration, int price, int priceUnattended) {
        this.duration = duration;
        this.price = price;
        this.priceUnattended = priceUnattended;
    }

    /**
     * 
     * @return 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration 
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return 
     */
    public int getPrice() {
        return price;
    }

    /**
     * 
     * @param price 
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 
     * @return 
     */
    public int getPriceUnattended() {
        return priceUnattended;
    }

    /**
     * 
     * @param priceUnattended 
     */
    public void setPriceUnattended(int priceUnattended) {
        this.priceUnattended = priceUnattended;
    }
    
    
    
    
}
