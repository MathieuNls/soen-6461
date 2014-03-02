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

import com.concordia.SOEN6461.MVC.model.ManageAppointmentModel;
import com.concordia.SOEN6461.MVC.view.ManageAppointmentView;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.human.Patient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Mathieu Nayrolles
 */
public class ManageAppointmentController implements IController{
    
    /**
     * Reference to the model
     */
    protected ManageAppointmentModel model = new ManageAppointmentModel();
    /**
     * Reference to the view
     */
    protected ManageAppointmentView view = new ManageAppointmentView();
    
    public ManageAppointmentController(Patient patient){
        this.model.init(patient);
    }

    /**
     * Initialize the controller. Bind view & model, show the view
     */
    @Override
    public void start(){
        this.view.setModel(model);
        this.view.addListSelectionChangeListener(new ListChange());
        this.view.addUpdateListener(new UpdateAppointment());
        this.view.addDeleteListener(new DeleteAppointment());
        this.view.addBackListener(new BackListener());
        this.view.run();
    }
    
     /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.setVisible(false);
            new ChoicesController(model.getPatient(), new Clinic(1)).start();
        }
    }

    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class UpdateAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(model.getSelectedAppointment() != null){
               model.deleteAppointment();
               view.setVisible(false);
               new CalendarController(new Clinic(1), model.getPatient(), 
                       model.getSelectedAppointment().getAppointmentDetails()).start();
            }
        }
    }
     
     /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class DeleteAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(model.getSelectedAppointment() != null){
               view.showMessage("Are you sure to delete this appointment ?"); 
               model.deleteAppointment();
               view.setVisible();
            }else{
                view.showMessage("You must select an appointment");
            }
        }
    }
    
    
    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class ListChange implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            boolean isUpdatable = model.setSelectedAppointment(view.getSelectedAppointment());
            
            if(!isUpdatable){
                view.showMessage("This appointment is already finish. You can't modify it");
            }
        }
    }
    
}