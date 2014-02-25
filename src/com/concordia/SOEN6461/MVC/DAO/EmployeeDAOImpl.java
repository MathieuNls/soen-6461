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

package com.concordia.SOEN6461.MVC.DAO;

import com.concordia.SOEN6461.beans.human.AEmployee;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.beans.human.Nurse;
import com.concordia.SOEN6461.database.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import static org.hsqldb.lib.tar.TarHeaderField.name;

/**
 * @author Mathieu Nayrolles
 */
public class EmployeeDAOImpl implements EmployeeDAO{

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
        String SQL_QUERY = " from Users u where u.uname='" + name + "' and u.pwd='" + password + "'";
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
    public AEmployee updateEmployee(AEmployee aEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEmployee(AEmployee aEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
