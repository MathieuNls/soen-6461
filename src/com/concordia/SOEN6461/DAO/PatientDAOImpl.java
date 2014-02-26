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

import com.concordia.SOEN6461.beans.human.Patient;
import com.concordia.SOEN6461.database.HibernateUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Mathieu Nayrolles
 */
public class PatientDAOImpl implements PatientDAO{

    @Override
    public Patient getPatient(String sin, String name, String birthdate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String SQL_QUERY = " from Patient p where p.sin='" + sin + "' and p.familyName='" 
                + name + "' and p.birthdate ='" + birthdate + "'";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<Patient> it = query.iterate();
        List<Patient> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }

    @Override
    public String registerPatient(String sin, String familyName,
            String givernName, String birthdate, String phoneNumber, String gender) {
        
        Session session;
    	Transaction tx;
        
        try {
             Patient p = new Patient(new Integer(sin), familyName, givernName, 
                new Date(birthdate), gender,  phoneNumber);
     
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tx.setTimeout(5);

            session.save(p);

            tx.commit();
            
            return "sucess";
        } catch (NumberFormatException e) {
            return e.getMessage();
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

}
