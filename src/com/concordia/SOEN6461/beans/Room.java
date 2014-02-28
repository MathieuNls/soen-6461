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
package com.concordia.SOEN6461.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines a room
 * @author Mathieu Nayrolles
 */
@Entity
@Table(name="Room")
public class Room {
    
    @Id
    @GeneratedValue
    @Column(name="ROOM_ID")
    private int id;
    
    @Column(name="GIVEN_NAME")
    private String givenName;
    
    @Column(name="BUILDING")
    private String building;
    
    @Column(name="FLOOR")
    private int floor;
    
    @Column(name="NUMBER")
    private int number;
    
    protected Room(){};

    /**
     * default constructor
     * @param givenName
     * @param building
     * @param floor
     * @param number 
     */
    public Room(String givenName, String building, int floor, int number) {
        this.givenName = givenName;
        this.building = building;
        this.floor = floor;
        this.number = number;
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
    public String getBuilding() {
        return building;
    }

    /**
     * 
     * @param building 
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * 
     * @return 
     */
    public int getFloor() {
        return floor;
    }

    /**
     * 
     * @param floor 
     */
    public void setFloor(int floor) {
        this.floor = floor;
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
    public int getNumber() {
        return number;
    }

    /**
     * 
     * @param number 
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
    
    
    
}
