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
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name = "PLANNING")
public class Planning  implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="PLANNING_ID")
    private int id;
    
    @Column(name="FROM_DATE")
    @Temporal(TemporalType.DATE)
    private Date from;
    
    @Column(name="TO")
    @Temporal(TemporalType.DATE)
    private Date to;

    public Planning() {
    }

    /**
     * Default constructor
     * @param from
     * @param to 
     */
    public Planning(Date from, Date to) {
        this.from = from;
        this.to = to;
    }
   

    /**
     * 
     * @return 
     */
    public Date getFrom() {
        return from;
    }

    /**
     * 
     * @param from 
     */
    public void setFrom(Date from) {
        this.from = from;
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
     * @return formatted String
     */
    @Override
    public String toString() {
        return "Planning{" + "id=" + id + ", from=" + from + ", to=" + to + '}';
    }

}
