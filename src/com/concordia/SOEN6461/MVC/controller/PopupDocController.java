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
import com.concordia.SOEN6461.MVC.view.calendar.PopupDocView;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.appointment.AppointmentDetails;
import com.concordia.SOEN6461.beans.human.Patient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    
    public PopupDocController(long gievnTime, Clinic clinic, Patient patient, AppointmentDetails appointmentDetails){
        this.model.init(clinic, gievnTime, patient, appointmentDetails);
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
            view.showMessage(model.persistAppointment());
            view.setVisible(false);
            new ChoicesController(model.getPatient(), model.getClinic()).start();
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