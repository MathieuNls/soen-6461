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
import com.concordia.SOEN6461.beans.human.AEmployee;
import com.concordia.SOEN6461.beans.human.Adresse;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.database.HibernateUtil;
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
        //new LoginController().start();
        
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

