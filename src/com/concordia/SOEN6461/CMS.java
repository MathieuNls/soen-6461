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
package com.concordia.SOEN6461;

import com.concordia.SOEN6461.MVC.controller.WelcomeController;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.appointment.Appointment;
import com.concordia.SOEN6461.beans.appointment.AppointmentDetails;
import com.concordia.SOEN6461.beans.human.Adresse;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.beans.human.Nurse;
import com.concordia.SOEN6461.beans.human.Patient;
import com.concordia.SOEN6461.beans.human.Planning;
import com.concordia.SOEN6461.beans.paiement.PaiementMethod;
import com.concordia.SOEN6461.database.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author math
 */
public class CMS {

    
    public static void main(String[] args) {
        // TO START THE DATABASE GO TO LIB/HSQDL-2.3.2/hsqldb/bin and 
        // run runServer.bat
        
        // Login is math / math.
        new WelcomeController().start();
    }   
    
     public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }
    
    public static void init(){
        Session session = null;
    	Transaction tx = null;
         session = HibernateUtil.getSessionFactory().openSession();
         tx = session.beginTransaction();
        
        final Room room = new Room("Blue", "Ev", 5, 528);
        
        
        session.save(room);
        
       
        Clinic c = new Clinic(1);
        c.addRoom(room);       
       
        session.save(c);

        tx.setTimeout(5);
                
    	tx.commit();
    }
    
}