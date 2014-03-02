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

import com.concordia.SOEN6461.MVC.model.ManagePatientModel;
import com.concordia.SOEN6461.MVC.view.ManagePatientView;
import com.concordia.SOEN6461.beans.Clinic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Mathieu Nayrolles
 */
public class ManagePatientController implements IController{
    
    /**
     * Reference to the model
     */
    protected ManagePatientModel model = new ManagePatientModel();
    /**
     * Reference to the view
     */
    protected ManagePatientView view = new ManagePatientView();
    
    public ManagePatientController(){
        this.model.init();
    }

    /**
     * Initialize the controller. Bind view & model, show the view
     */
    @Override
    public void start(){
        this.view.setModel(model);
        this.view.addDeleteListener(new DeleteButtonListener());
        this.view.addListSelectionChangeListener(null);
        this.view.addManageListener(new ManageButtonListener());
        this.view.addListSelectionChangeListener(new ListChangeListner());
        this.view.run();
    }
    
    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
    private class ListChangeListner implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            model.setSelectedPatient(view.getSelectedPatient());
        }
        
    }
 
    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class UpdateButtonListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
          
           
        }
        
    }
     
     /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class DeleteButtonListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            view.showMessage("Are you sure to delete this patient ?");
            model.deletePatient();
        }
        
    }
     
       /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class ManageButtonListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            new ChoicesController(model.getSelectedPatient(), new Clinic(1)).start();
        }
        
    }
    
    
    
}
