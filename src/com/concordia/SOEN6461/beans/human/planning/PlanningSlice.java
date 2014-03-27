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

package com.concordia.SOEN6461.beans.human.planning;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name = "PLANNING_SLICE")
@XmlRootElement
public class PlanningSlice implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="PLANNING_SLICE_ID")
    private int id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FROM_DATE")
    private Date from_date;
    
    @Column(name="TO_DATE")
    @Temporal(TemporalType.DATE)
    private Date to;

    /**
     * default constructor for hibernate
     */
    public PlanningSlice() {
    }
    
    /**
     * PlanningSlice
     * @param from
     * @param to
     * @throws ParseException 
     */
    public PlanningSlice(String from, String to) throws ParseException{
        //22/10/2014 09:20
        this.from_date = new SimpleDateFormat("d/M/y H:m", Locale.ENGLISH).parse(from);
        this.from_date = new Date(from);
        this.to = new Date(to);
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
    public Date getFrom() {
        return from_date;
    }

    /**
     * 
     * @param from 
     */
    public void setFrom(Date from) {
        this.from_date = from;
    }

    /**
     * 
     * @return 
     */
    public Date getTo() {
        return to;
    }

    /**
     * 
     * @param to 
     */
    public void setTo(Date to) {
        this.to = to;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Available from " + from_date + " to " + to + '}';
    }
    
}
