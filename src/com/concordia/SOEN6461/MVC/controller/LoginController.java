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

import com.concordia.SOEN6461.MVC.IController;
import com.concordia.SOEN6461.MVC.model.LoginModel;
import com.concordia.SOEN6461.MVC.view.LoginVIew;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Mathieu Nayrolles
 */
public class LoginController  implements IController{
    
    /**
     * Reference to the model
     */
    protected LoginModel model = new LoginModel();
    /**
     * Reference to the view
     */
    protected LoginVIew view = new LoginVIew();

    /**
     * Initialize the controller. Bind view & model, show the view
     */
    public void start(){
        this.view.setModel(model);
        this.view.addLoginListener(new LoginListener());
        this.view.run();
    }
    
    /**
     * LoginListener inner class. This is the most elegant way to delegate
     * click action from swing frame to controller.
     */
    class LoginListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("In");
            List<String> userInputs = view.userInputs();
            if(model.login(userInputs.get(0), userInputs.get(1)) != null){
                view.showMessage("Loggin Sucess");
            }else{
                view.showMessage("Loggin Fail");
            }
        }
        
    }
    
    
    
}
