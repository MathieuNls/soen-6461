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
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name = "PLANNING")
@XmlRootElement
public class Planning implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="PLANNING_ID")
    private int id;
    
 
    @ManyToMany(targetEntity=PlanningSlice.class, fetch=FetchType.EAGER)
    private Set<PlanningSlice> planningSlices = new HashSet<PlanningSlice>();

    public Planning() {
    }

    /**
     * 
     * @return id
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
     * @return PlanningSlice
     */
    public Set<PlanningSlice> getPlanningSlices() {
        return planningSlices;
    }
    
    /**
     * 
     * @param planningSlice 
     */
    public void addSlice(PlanningSlice planningSlice){
        this.planningSlices.add(planningSlice);
    }
    
    /**
     * 
     * @param planningSlice 
     */
    public void deleteSlice(PlanningSlice planningSlice){
        this.planningSlices.remove(planningSlice);
    }

    /**
     * 
     * @param planningSlices 
     */
    public void setPlanningSlices(Set<PlanningSlice> planningSlices) {
        this.planningSlices = planningSlices;
    }

    @Override
    public String toString() {
        return "Planning{" + "id=" + id + ", planningSlices=" + planningSlices + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + (this.planningSlices != null ? this.planningSlices.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Planning other = (Planning) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.planningSlices != other.planningSlices && (this.planningSlices == null || !this.planningSlices.equals(other.planningSlices))) {
            return false;
        }
        return true;
    }
    
    


}
