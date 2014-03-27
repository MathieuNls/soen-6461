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

import com.concordia.SOEN6461.MVC.model.PlanningModel;
import com.concordia.SOEN6461.MVC.view.PlanningView;
import com.concordia.SOEN6461.beans.human.AEmployee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mathieu Nayrolles
 */
public class PlanningController implements IController{
    
    /**
     * Reference to the model
     */
    protected PlanningModel model = new PlanningModel();
    /**
     * Reference to the view
     */
    protected PlanningView view = new PlanningView();
    
    /**
     * Default constructor
     * @param aEmployee 
     */
    public PlanningController(AEmployee aEmployee){
        this.model.init(aEmployee);
    }

    /**
     * Initialize the controller. Bind view & model, show the view
     */
    @Override
    public void start(){
        this.view.setModel(model);
        this.view.addAddListener(new AddListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addBackListener(new BackListener());
        this.view.run();
    }
    
    /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class AddListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) { 
            List<String> userInputs = view.userInputs();
            try {
                model.addPlanningSlice(userInputs.get(0), userInputs.get(1));
            } catch (ParseException ex) {
                Logger.getLogger(PlanningController.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.updateList();
        }
        
    }
     
     /**
     * Inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class BackListener implements ActionListener{
            
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
     private class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           model.removeSlice(new Integer(view.userInputs().get(0)));
           view.updateList();
        }       
     }
     
}
