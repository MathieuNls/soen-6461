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

package com.concordia.SOEN6461.MVC.model;

import com.concordia.SOEN6461.DAO.ClinicDAOImpl;
import com.concordia.SOEN6461.DAO.EmployeeDAOImpl;
import com.concordia.SOEN6461.DAO.RoomDAOImpl;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.human.AEmployee;
import com.concordia.SOEN6461.database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Mathieu Nayrolles
 */
public class ManageClinicModel  implements IModel{

    private Clinic clinic;
    private AEmployee aEmployee;
    
    /**
     * 
     * @param clinic 
     */
    public void init(Clinic clinic, AEmployee aEmployee){
        this.aEmployee = aEmployee;
        this.clinic = ClinicDAOImpl.getInstance().getClinicById(clinic.getId());
        this.clinic.getDoctors();
        this.clinic.getRooms();
        this.clinic.getNurses();

    }

    /**
     * 
     * @return 
     */
    public Clinic getClinic() {
        return clinic;
    }

    /**
     * 
     * @param clinic 
     */
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    /**
     * 
     * @param name
     * @param lastname 
     */
    public void addDoctor(String name, String lastname) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        this.clinic.addDoc(EmployeeDAOImpl.getInstance().persistDoctor(name, lastname));
        ClinicDAOImpl.getInstance().save(clinic);
        tx.setTimeout(5);        
    	tx.commit();
    }
    
    /**
     * 
     * @param name
     * @param building
     * @param floor
     * @param number 
     */
    public void addRoom(String name, String building, String floor, String number){
            Session session = null;
    	Transaction tx = null;
         session = HibernateUtil.getSessionFactory().openSession();
         tx = session.beginTransaction();
        
        final Room room = new Room(name, building, new Integer(floor), new Integer(number));
        
        
        
        session.save(room);
        
        
        clinic.addRoom(room);       
       
        session.save(clinic);

                
    	tx.commit();
        
        session.close();
        
    }

    public AEmployee getaEmployee() {
        return aEmployee;
    }

    public void setaEmployee(AEmployee aEmployee) {
        this.aEmployee = aEmployee;
    }
    
    
    
    
    
}
