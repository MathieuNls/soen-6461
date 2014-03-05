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
package com.concordia.SOEN6461.MVC.controller;

import com.concordia.SOEN6461.MVC.model.PopupDocModel;
import com.concordia.SOEN6461.MVC.model.calendar.CalendarVector;
import com.concordia.SOEN6461.MVC.view.calendar.PopupDocView;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.appointment.AppointmentDetails;
import com.concordia.SOEN6461.beans.human.Patient;
import com.concordia.SOEN6461.messaging.Server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Mathieu Nayrolles
 */
public class PopupDocController implements IController{
    
    /**
     * Reference to the model
     */
    protected PopupDocModel model = new PopupDocModel();
    /**
     * Reference to the view
     */
    protected PopupDocView view = new PopupDocView();
    
    
    public PopupDocController(long gievnTime, Clinic clinic, Patient patient, AppointmentDetails appointmentDetails, int index){
        
        this.model.init(clinic, gievnTime, patient, appointmentDetails, index);
        System.out.println(gievnTime);   
    }

    /**
     * Initialize the controller. Bind view & model, show the view
     */
    @Override
    public void start(){
    
        this.view.setModel(model);
        this.view.addBookListener(new BookListener());
        this.view.addDoctorsListener(new DoctorChangeListener());
        this.view.addRoomsListener(new RoomChangeListener());
        this.view.run();
    }
    
    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class BookListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            List<String> userInputs = view.userInputs();
            Boolean validCredit = true;
            
            for(String str : userInputs){
                if(str.isEmpty()){
                    view.showMessage("There is something wrong with your credit card");
                    validCredit = false;
                    return;
                }
            }
            
            if(validCredit){
                 view.showMessage(model.persistAppointment());
            
                CalendarVector.m_vItemList.get(model.getIndexSelected()).setColor(0x00ffe0e0);

                try {

                    // Let other clients know that we are updating the calendar
                    new Server(model.getIndexSelected()).start();


                } catch (IOException ex) {
                    Logger.getLogger(PopupDocController.class.getName()).log(Level.SEVERE, null, ex);
                }

                 view.setVisible(false);

                new ChoicesController(model.getPatient(), model.getClinic()).start();
            }
            
           
        }
        
    }
     
     private class DoctorChangeListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent lse) {
          
            model.setSelectedDoctor(view.getSelectedDoctorIndex());
        }
     }
     
       private class RoomChangeListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            model.setSelectedRoom(view.getSelectedRoomIndex());
        }

     }   
       
}