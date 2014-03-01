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

import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.human.Doctor;
import java.util.List;

/**
 * @author Mathieu Nayrolles
 * This bean isn't persisted into database. It serves only at
 * defining free / not free time slots.
 */
public class TimeSlot {
    
    
    private boolean free;
    
    private long time;
    
    private List<Doctor> availableDoctors;
    
    private List<Room> availableRooms;
    
    
    /**
     * Default constructor
     * @param free
     * @param time
     * @param availableDoctors
     * @param availableRooms 
     */
    public TimeSlot(boolean free, long time, List<Doctor> availableDoctors, List<Room> availableRooms) {
        this.free = free;
        this.time = time;
        this.availableDoctors = availableDoctors;
        this.availableRooms = availableRooms;
    }

    /**
     * 
     * @return free?
     */
    public boolean isFree() {
        return free;
    }

   /**
    * 
    * @param free 
    */
    public void setFree(boolean free) {
        this.free = free;
    }

    /**
     * 
     * @return time
     */
    public long getTime() {
        return time;
    }

    /**
     * 
     * @param time 
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * 
     * @return Doctors
     */
    public List<Doctor> getAvailableDoctors() {
        return availableDoctors;
    }

    /**
     * 
     * @param availableDoctors 
     */
    public void setAvailableDoctors(List<Doctor> availableDoctors) {
        this.availableDoctors = availableDoctors;
    }

    /**
     * 
     * @return availableRooms
     */
    public List<Room> getAvailableRooms() {
        return availableRooms;
    }

    /**
     * 
     * @param availableRooms 
     */
    public void setAvailableRooms(List<Room> availableRooms) {
        this.availableRooms = availableRooms;
    }

    /**
     * 
     * @return toString
     */
    @Override
    public String toString() {
        return "TimeSlot{" + "free=" + free + ", time=" + time + ", availableDoctors=" + availableDoctors + ", availableRooms=" + availableRooms + '}';
    }

    /**
     * 
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.free ? 1 : 0);
        hash = 79 * hash + (int) (this.time ^ (this.time >>> 32));
        hash = 79 * hash + (this.availableDoctors != null ? this.availableDoctors.hashCode() : 0);
        hash = 79 * hash + (this.availableRooms != null ? this.availableRooms.hashCode() : 0);
        return hash;
    }

    /**
     * 
     * @param obj
     * @return equals
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeSlot other = (TimeSlot) obj;
        if (this.free != other.free) {
            return false;
        }
        if (this.time != other.time) {
            return false;
        }
        if (this.availableDoctors != other.availableDoctors && (this.availableDoctors == null || !this.availableDoctors.equals(other.availableDoctors))) {
            return false;
        }
        return this.availableRooms == other.availableRooms || (this.availableRooms != null && this.availableRooms.equals(other.availableRooms));
    }
    
}
