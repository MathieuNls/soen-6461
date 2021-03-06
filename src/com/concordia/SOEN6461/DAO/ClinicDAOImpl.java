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
import com.concordia.SOEN6461.database.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * @author Mathieu Nayrolles
 */
public class ClinicDAOImpl implements ClinicDAO{
    
    /**
     * Singleton Design Pattern
     */
    private static ClinicDAOImpl instance;
    
    /**
     * private constructor. Singleton DP
     */
    private ClinicDAOImpl(){}
    
    /**
     * Synchronized getInstance method. 
     * Multi thread proof singleton
     * @return 
     */
    public static ClinicDAOImpl getInstance(){
        synchronized(ClinicDAOImpl.class){
            if (instance == null){
                instance = new ClinicDAOImpl();
            }      
        }
        return instance;
    }
    
    /**
     * 
     * @param clinic_id
     * @return 
     */
    @Override
    public Clinic getClinicById(int clinic_id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String SQL_QUERY = " from Clinic where id  = " + clinic_id;
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Clinic clinic = (Clinic) query.list().get(0);
        session.close();
        return clinic;
    }
    
    /**
     * 
     * @param clinic
     */
    public void save(Clinic clinic){
        Transaction tx = null;
         Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(clinic);
        tx.setTimeout(5);        
    	tx.commit();
    }
    
}