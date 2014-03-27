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

package com.concordia.SOEN6461.MVC.model;

import com.concordia.SOEN6461.DAO.EmployeeDAO;
import com.concordia.SOEN6461.DAO.EmployeeDAOImpl;
import com.concordia.SOEN6461.beans.human.AEmployee;
import com.concordia.SOEN6461.beans.human.planning.PlanningSlice;
import java.text.ParseException;

/**
 * @author Mathieu Nayrolles
 */
public class PlanningModel  implements IModel{
    
    private AEmployee aEmployee;

    /**
     * init the model
     * @param aEmployee 
     */
    public void init(AEmployee aEmployee) {
        this.aEmployee = aEmployee;
    }

    /**
     * 
     * @return AEmployee
     */
    public AEmployee getaEmployee() {
        return aEmployee;
    }

    /**
     * 
     * @param aEmployee 
     */
    public void setaEmployee(AEmployee aEmployee) {
        this.aEmployee = aEmployee;
    }
    
    /**
     * add a slice to the planning
     * @param from
     * @param to 
     * @throws java.text.ParseException 
     */
    public void addPlanningSlice(String from, String to) throws ParseException{
        PlanningSlice planningSlice = new PlanningSlice(from, to);
        this.aEmployee.addPlanningSlice(planningSlice);
        EmployeeDAOImpl.getInstance().createSlice(planningSlice, this.aEmployee.getPlanning());
    }
    
    /**
     * remove slice
     * @param selectedSlice 
     */
    public void removeSlice(int selectedSlice){
        // kind of ugly cast. Ensure the coherence of the data
        PlanningSlice slice = (PlanningSlice) this.aEmployee.getPlanning()
                .getPlanningSlices().toArray()[selectedSlice];
        this.aEmployee.removePlanningSlice(slice);
        EmployeeDAOImpl.getInstance().removeSlice(slice);
    }
    
    

}
