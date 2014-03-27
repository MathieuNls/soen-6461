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

import com.concordia.SOEN6461.MVC.model.ManageClinicModel;
import com.concordia.SOEN6461.MVC.view.ManageClinicView;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.human.AEmployee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Mathieu Nayrolles
 */
public class ManageClinicController implements IController{
    
    /**
     * Reference to the model
     */
    protected ManageClinicModel model = new ManageClinicModel();
    /**
     * Reference to the view
     */
    protected ManageClinicView view = new ManageClinicView();
    
    public ManageClinicController(Clinic clinic, AEmployee aEmployee){
        this.model.init(clinic, aEmployee);
    }
    /**
     * Initialize the controller. Bind view & model, show the view
     */
    @Override
    public void start(){
        this.view.setModel(model);
        this.view.addDoctorListener(new DoctorListener());
        this.view.addRoomListener(new RoomListener());
        this.view.addBackListener(new BackButtonListener());
        this.view.run();
    }
    
    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class DoctorListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            List<String> doc = view.getDoctor();
            model.addDoctor(doc.get(0), doc.get(1));
            view.updateAll();
        }
        
    }
     
     private class BackButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.setVisible(false);
            new ChoicesEmployeeController(model.getaEmployee()).start();
        }
         
     }
     
      
    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class RoomListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            List<String> room = view.getRoom();
            model.addRoom(room.get(0), room.get(1), room.get(2), room.get(3));
            view.updateAll();
        }
        
    }
     
     

}
