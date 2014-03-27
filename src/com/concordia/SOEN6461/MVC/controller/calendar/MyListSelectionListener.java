/*
 * MyListSelectionListener.java
 *
 * Created on September 27, 2000, 5:29 AM
 
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.MVC.controller.calendar;

import java.util.EventListener;


/** 
 *
 * @author  Administrator
 * @author Mathieu Nayrolles
 * @version 1.0.0
 */
public interface MyListSelectionListener extends EventListener {
    /**
     * 
     * @param evt 
     */
    public void selectionChanged(MyListSelectionEvent evt);

}
