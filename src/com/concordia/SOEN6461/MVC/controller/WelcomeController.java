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

import com.concordia.SOEN6461.MVC.model.WelcomeModel;
import com.concordia.SOEN6461.MVC.view.WelcomeView;
import com.concordia.SOEN6461.beans.human.Patient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Mathieu Nayrolles
 */
public class WelcomeController implements IController{
    
    /**
     * Reference to the model
     */
    protected WelcomeModel model = new WelcomeModel();
    /**
     * Reference to the view
     */
    protected WelcomeView view = new WelcomeView();

    /**
     * Initialize the controller. Bind view & model, show the view
     */
    @Override
    public void start(){
        this.view.setModel(model);
        this.view.addRegisterListener(new RegisterListener());        
        this.view.addLoginListener(new LoginListener());
        this.view.addEmployeeLoginListener(new EmployeeLoginListener());
        this.view.run();
    }
    
     /**
     * RegisterListener inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class EmployeeLoginListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            view.setVisible(false);
            new LoginController().start();
        }
        
    }
    
    /**
     * RegisterListener inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class RegisterListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            view.setVisible(false);
            new RegisterController().start();
        }
        
    }
     
     /**
     * LoginListener inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
     private class LoginListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            List<String> userInputs = view.userInputs();
            Patient patient = model.login(userInputs.get(0), userInputs.get(1));
            if(patient != null){
                view.showMessage("Loggin Sucess");
                view.setVisible(false);
                new ChoicesController(patient, model.getClinic()).start();
            }else{
                view.showMessage("Loggin Fail");
            }
        }
        
    }
     
     
    
    
    
}
