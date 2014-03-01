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
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


/**
 * @author Mathieu Nayrolles
 */
public class RoomDAOImpl{
    
    /**
     * Singleton Design Pattern
     */
    private static RoomDAOImpl instance;
    
    /**
     * private constructor. Singleton DP
     */
    private RoomDAOImpl(){}
    
    /**
     * Synchronized getInstance method. 
     * Multi thread proof singleton
     * @return RoomDAOImpl
     */
    public static RoomDAOImpl getInstance(){
        synchronized(RoomDAOImpl.class){
            if (instance == null){
                instance = new RoomDAOImpl();
            }      
        }
        return instance;
    }
    
    public int countRoomBy(int clinic_id){
        Session session = HibernateUtil.getSessionFactory().openSession();
       Integer count = new Integer(session.createCriteria(Clinic.class)
               .setProjection(Projections.count("rooms"))
               .add(Restrictions.eq("id", clinic_id))
       .list().get(0).toString());
                    
        session.close();
        return count;
        
    }
    

}
