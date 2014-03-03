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
import com.concordia.SOEN6461.database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Mathieu Nayrolles
 */
public class ManageClinicModel {

    private Clinic clinic;
    
    public void init(Clinic clinic){
        this.clinic = ClinicDAOImpl.getInstance().getClinicById(clinic.getId());
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public void addDoctor(String name, String lastname) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        this.clinic.addDoc(EmployeeDAOImpl.getInstance().persistDoctor(name, lastname));
        ClinicDAOImpl.getInstance().save(clinic);
        tx.setTimeout(5);        
    	tx.commit();
    }
    
    public void addRoom(String name, String building, String floor, String number){
         Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        this.clinic.addRoom(RoomDAOImpl.getInstance().addRoom(name, building, floor, number));
        ClinicDAOImpl.getInstance().save(clinic);
        ClinicDAOImpl.getInstance().save(clinic);
        tx.setTimeout(5);        
    	tx.commit();
    }
    
    
    
}
