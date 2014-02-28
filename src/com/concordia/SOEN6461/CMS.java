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

import com.concordia.SOEN6461.MVC.controller.LoginController;
import com.concordia.SOEN6461.MVC.controller.WelcomeController;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.appointment.Appointment;
import com.concordia.SOEN6461.beans.appointment.AppointmentDetails;
import com.concordia.SOEN6461.beans.human.AEmployee;
import com.concordia.SOEN6461.beans.human.Adresse;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.beans.human.Nurse;
import com.concordia.SOEN6461.beans.human.Patient;
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
        
        
        
        
        
        //new WelcomeController().start();
        //new LoginController().start();
        
    }
    
    public static void init(){
        Session session = null;
    	Transaction tx = null;
         session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
         Adresse a = new Adresse(12, 0, "sheppard", "MTL", "HZK3K9", "QC", "CA");
      
         session.save(a);
         
       final Doctor doctor = new Doctor("math", "math", "nayrolles", "mathieu", a);
       doctor.setId(1);
        
        session.save(doctor);
        
         final Nurse nurse = new Nurse("math_nurse", "math_nurse", "math_nurse", "math_nurse", a);
        
        session.save(nurse);
        
        final Patient p = new Patient(1, "math", "math", new Date(1989, 8, 2), "male", "5146902063");
        
        session.save(p);
        
        final Room room = new Room("Rose", "Ev", 5, 514);
        
        
        session.save(room);
        
        final PaiementMethod paiementMethod = new PaiementMethod("Credit", 2, 0);
        
        session.save(paiementMethod);
        
        Clinic c = new Clinic("HFClinic", 
                new ArrayList<Room>(){{add(room);}}, 
                new ArrayList<AEmployee>(){{add(doctor);add(nurse);}}, 
                new ArrayList<Patient>(){{add(p);}}, 
                new ArrayList<PaiementMethod>(){{add(paiementMethod);}});
       

     
        session.save(c);
      
        
        
        Appointment app = new Appointment(doctor, p, room , new Date(2014, 3, 5, 10, 0, 0), AppointmentDetails.NORMAL);
        
        session.save(app);
        
        tx.setTimeout(5);
                
    	tx.commit();
    }
    
}

//                Adresse a = new Adresse(12, 0, "sheppard", "MTL", "HZK3K9", "QC", "CA");
//        
//        
//        AEmployee doctor = new Doctor("math", "math", "nayrolles", "mathieu", a);
//        
//    
//          Session session = null;
//    	Transaction tx = null;
//         session = HibernateUtil.getSessionFactory().openSession();
//    		tx = session.beginTransaction();
//    		tx.setTimeout(5);
//                
//                session.save(a);
//    		session.save(doctor);
// 
//    		tx.commit();

