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
import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.database.HibernateUtil;
import java.util.ArrayList;
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
    
      public List<Room> freeRoomAtaGivenTime(int clinic_id, long givenTime){
        
         Session session = HibernateUtil.getSessionFactory().openSession();
               
        String query = "SELECT r_.ROOM_ID FROM ROOM r_ , CLINIC_ROOM cr_ WHERE " 
                + "cr_.CLINIC_CLINIC_ID = " + clinic_id + " AND cr_.ROOMS_ROOM_ID = r_.ROOM_ID AND r_.ROOM_ID"
                + " NOT IN (SELECT app.ROOM_ID FROM APPOINTMENT app WHERE START_DATE = "+givenTime
                + " and app.CLINIC_ID = " + clinic_id + ")";
        
        List<Integer> rooms = session.createSQLQuery(query).list();
        
         List<Room> availableRoom = new ArrayList<Room>();
        
        for(Integer room : rooms){
             String SQL_QUERY = " from Room where ROOM_ID =" + room;
             Query query_sql = session.createQuery(SQL_QUERY);
             availableRoom.add((Room)query_sql.list().get(0));
        }
        
        session.close();
        
        return availableRoom;
    }
    

}
