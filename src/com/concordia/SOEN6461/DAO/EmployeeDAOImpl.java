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

package com.concordia.SOEN6461.DAO;

import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.appointment.Appointment;
import com.concordia.SOEN6461.beans.human.AEmployee;
import com.concordia.SOEN6461.beans.human.Adresse;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.beans.human.Nurse;
import com.concordia.SOEN6461.beans.human.Planning;
import com.concordia.SOEN6461.database.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * @author Mathieu Nayrolles
 */
public class EmployeeDAOImpl implements EmployeeDAO{
    
     /**
     * Singleton Design Pattern
     */
    private static EmployeeDAOImpl instance;
    
    /**
     * private constructor. Singleton DP
     */
    private EmployeeDAOImpl(){}
    
    /**
     * Synchronized getInstance method. 
     * Multi thread proof singleton
     * @return 
     */
    public static EmployeeDAOImpl getInstance(){
        synchronized(AppointmentDAOImpl.class){
            if (instance == null){
                instance = new EmployeeDAOImpl();
            }      
        }
        return instance;
    }

    @Override
    public List<AEmployee> getAllEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doctor> getAllDoctor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nurse> getAllNurses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doctor getDoctor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nurse getNurse(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AEmployee login(String login, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String SQL_QUERY = " from AEmployee e where e.login='" + login + "' and e.password='" + password + "'";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<AEmployee> it = query.iterate();
        List<AEmployee> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }
    
    @Override
    public int countDoctorsByClinic(int clinic_id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String SQL_QUERY = " from AEmployee where EMPLOYEE_TYPE = 'DOCTOR' and DOCTORS_CLINIC_ID = " + clinic_id;
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        int count = query.list().size();
        session.close();
        return count;
    }
    
    public Doctor persistDoctor(String name, String lastname){
        Transaction tx = null;
         Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
       
        Adresse a = new Adresse(12, 0, "default", "MTL", "HZK3K9", "QC", "CA");
      
        session.save(a);
        final Doctor doctor = new Doctor(name, lastname, name, lastname, a);

        Planning pla = new Planning();
       
        session.save(pla);
        doctor.setPlanning(pla);
        
        session.save(doctor);
        tx.setTimeout(5);
                
    	tx.commit();
        
        return doctor;
    }
    
    public List<Doctor> freeDoctorFromAClinicAtaGivenTime(int clinic_id, long givenTime){
        
         Session session = HibernateUtil.getSessionFactory().openSession();
               
        String query = "SELECT emp.EMPLOYEE_ID FROM Employee emp where EMPLOYEE_TYPE = 'DOCTOR' and DOCTORS_CLINIC_ID = " + clinic_id 
                + " and emp.EMPLOYEE_ID NOT IN (SELECT app.EMPLOYEE_ID FROM APPOINTMENT app WHERE START_DATE = "+givenTime
                + " and app.CLINIC_ID = " + clinic_id + ")";
        
        List<Integer> docs = session.createSQLQuery(query).list();
        List<Doctor> availableDoctor = new ArrayList<Doctor>();
        
        for(Integer doc : docs){
             String SQL_QUERY = " from AEmployee where EMPLOYEE_ID =" + doc;
             Query query_sql = session.createQuery(SQL_QUERY);
             availableDoctor.add((Doctor)query_sql.list().get(0));
        }

        session.close();
        
        return availableDoctor;
    }

    @Override
    public AEmployee updateEmployee(AEmployee aEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEmployee(AEmployee aEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
