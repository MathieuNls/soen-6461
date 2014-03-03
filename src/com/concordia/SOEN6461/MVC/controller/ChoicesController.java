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

import com.concordia.SOEN6461.MVC.model.ChoicesModel;
import com.concordia.SOEN6461.MVC.view.ChoicesView;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.appointment.AppointmentDetails;
import com.concordia.SOEN6461.beans.human.Patient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mathieu Nayrolles
 */
public class ChoicesController implements IController{
    
    /**
     * Reference to the model
     */
    protected ChoicesModel model = new ChoicesModel();
    /**
     * Reference to the view
     */
    protected ChoicesView view = new ChoicesView();
    
    public ChoicesController(Patient patient, Clinic clinic){
        this.model.init(patient, clinic);
    }

    /**
     * Initialize the controller. Bind view & model, show the view
     */
    @Override
    public void start(){
        this.view.setModel(model);
        this.view.addMakeAppointmentListener(new MakeAppointment());       
        this.view.addMakeCheckupListener(new MakeCheckup());
        this.view.addManageAppointmentListener(new ManageAppointments());
        this.view.run();
    }
    
    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class MakeAppointment implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
           
            view.setVisible(false);
            new CalendarController(model.getClinic(), model.getPatient(), AppointmentDetails.NORMAL).start();
           
        }
        
    }
     
      /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class MakeCheckup implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
           
          
            if(model.isCheckupAuthorrized()){
                 new CalendarController(model.getClinic(), model.getPatient(), AppointmentDetails.CHECKUP).start();
                 view.setVisible(false);
            }else{
                view.showMessage("You have the right to one checkup a year only.");
            }
           
           
        }
        
    }
     
           /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class ManageAppointments implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
           
            view.setVisible(false);
            new ManageAppointmentController(model.getPatient()).start();

        }
        
    }
     
}