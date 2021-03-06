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

import com.concordia.SOEN6461.MVC.model.ChoicesEmployeeModel;
import com.concordia.SOEN6461.MVC.view.ChoicesEmployeeView;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.appointment.AppointmentDetails;
import com.concordia.SOEN6461.beans.human.AEmployee;
import com.concordia.SOEN6461.beans.human.Patient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mathieu Nayrolles
 */
public class ChoicesEmployeeController implements IController{
    
    /**
     * Reference to the model
     */
    protected ChoicesEmployeeModel model = new ChoicesEmployeeModel();
    /**
     * Reference to the view
     */
    protected ChoicesEmployeeView view = new ChoicesEmployeeView();
    
    /**
     * Default constructor
     * @param aEmployee 
     */
    public ChoicesEmployeeController(AEmployee aEmployee){
        model.init(aEmployee);
    }

    /**
     * Initialize the controller. Bind view & model, show the view
     */
    @Override
    public void start(){
        this.view.setModel(model);
        this.view.addPatientButtonListener(new ManagePatientListener());
        this.view.addClinicButtonListener(new ManageClinicListener());
        this.view.addOverButtonListener(new OverviewListener());
        this.view.addCalendarButtonListener(new UpdatePlanning());
        this.view.run();
    }
    
    private class UpdatePlanning implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.setVisible(false);
            new PlanningController(model.getaEmployee()).start();
        }
        
    }
    
    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class OverviewListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
           view.setVisible(true);
           new CalendarController(new Clinic(1), new Patient(1), AppointmentDetails.NORMAL).start();
        }
        
    }
     
      /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class ManagePatientListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            view.setVisible(false);
           new ManagePatientController().start();
        }
        
    }
     
       /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class ManageClinicListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
           view.setVisible(false);
           new ManageClinicController(new Clinic(1), model.getaEmployee()).start();
        }
        
    }
    
    
}
