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

import com.concordia.SOEN6461.beans.appointment.Appointment;
import com.concordia.SOEN6461.beans.appointment.TimeSlot;
import com.concordia.SOEN6461.database.HibernateUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 * @author Mathieu Nayrolles
 */
public class AppointmentDAOImpl implements AppointmentDAO{
    
    /**
     * Singleton Design Pattern
     */
    private static AppointmentDAOImpl instance;
    
    /**
     * private constructor. Singleton DP
     */
    private AppointmentDAOImpl(){}
    
    /**
     * Synchronized getInstance method. 
     * Multi thread proof singleton
     * @return 
     */
    public static AppointmentDAOImpl getInstance(){
        synchronized(AppointmentDAOImpl.class){
            if (instance == null){
                instance = new AppointmentDAOImpl();
            }      
        }
        return instance;
    }

    @Override
    public List<Appointment> getAppointmentsByClinic(int clinic_id, long from) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String SQL_QUERY = " from Appointment a where a.clinic = " + clinic_id + " and a.start >= '" + from + "' order by a.start asc";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        List<Appointment> list = query.list();
        
        session.close();
        return list;
        
    }
    
    @Override
    public List<TimeSlot> getFreeAppointmentsByClinic(int clinic_id) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
   
        int totalRoom = RoomDAOImpl.getInstance().countRoomBy(clinic_id);
        int totalDoc = EmployeeDAOImpl.getInstance().countDoctorsByClinic(clinic_id);
        int lenghtAppointment = 20;
        int periodOfDays=20;
        
        // Creates a date rounded down to the last <code>lenghtAppointment</code>. 20h37 became 20h20.
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new Date()); To uncomment after test
        calendar.setTimeInMillis(1393522 * 1000000); // Thu Feb 27 2014 12:40:00 GMT-0500 (EST)
        int unroundedMinutes = calendar.get(Calendar.MINUTE);
        int mod = unroundedMinutes % lenghtAppointment;
        calendar.set(Calendar.MINUTE, unroundedMinutes + mod);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        
        // All the appointments booked after the rounded date
        List<Appointment> list = getAppointmentsByClinic(clinic_id, calendar.getTimeInMillis()); 
        Map<Long, List<Appointment>> appointmentsByDate = new HashMap<Long, List<Appointment>>();
        
        
        
        // Group the appointments by timestamp
        for(Appointment ap : list){ 
            // Create the list if not yet created
            if(!appointmentsByDate.containsKey(ap.getStart())){ 
               appointmentsByDate.put(ap.getStart(), new ArrayList<Appointment>());
            }
             // Add the current appointment to the ordered list
            appointmentsByDate.get(ap.getStart()).add(ap);
        }
        
        List<Long> fullSpot = new ArrayList<Long>(); // List of full spot
        
        for(Map.Entry<Long, List<Appointment>> entry : appointmentsByDate.entrySet()){
            if(entry.getValue().size() == totalDoc || entry.getValue().size() == totalRoom){
                // A spot is said full is either the number of appointment per timeslot is 
                // equal to the max number of doctor or to the max number of room.
                fullSpot.add(entry.getKey());
            }
        }
        
        // Creates a new Calendar extended from <code>periodOfDays</code>
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(calendar.getTime());
        calendarEnd.add(Calendar.MINUTE, 60*periodOfDays);
        
        List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
        
        // While we do not exceed a <code>periodOfDays</code>
        while(calendar.compareTo(calendarEnd) < 0){

            if(fullSpot.contains(calendar.getTimeInMillis())){ // FULL
                timeSlots.add(new TimeSlot(false, calendar.getTimeInMillis(), null, null));
                 System.out.println(calendar.getTimeInMillis() + " FULL");
            }else{
                timeSlots.add(new TimeSlot(false, calendar.getTimeInMillis(), null, null));
                System.out.println(calendar.getTimeInMillis() + " OK");
            }
            calendar.add(Calendar.MINUTE, lenghtAppointment);
        }
        
        session.close();
        return timeSlots;
        
    }

}
