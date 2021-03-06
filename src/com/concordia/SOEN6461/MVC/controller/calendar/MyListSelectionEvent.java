/*
 * MyListSelectionEvent.java
 *
 * Created on September 27, 2000, 5:50 AM
 
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.MVC.controller.calendar;

import java.util.EventObject;

import javax.swing.table.TableModel;

/** 
 * This event notifies objects of selections in the table (or calendar) models.
 * @author  Administrator
 * @version 1.0.0
 */
public class MyListSelectionEvent extends EventObject
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * This is the variable to notify the listeners of a new selection.
     */
    public final static int SELECT = 1;
    public final static int DESELECT = SELECT + 1;
    public final static int CONTENT_SELECT = SELECT + 2;    // User wants to view the object's detail
    public final static int CONTENT_CLICK = CONTENT_SELECT + 32;        // User wants to change the object's detail
    public final static int ADD_SELECT = SELECT + 16; // Add/Remove to/from selection

    protected TableModel m_tableModel = null;
    protected int m_iRowToSelect = -1;
    protected int m_iSelectType = -1;
    
   /**
    * 
    * @param source
    * @param tableModel
    * @param iRowToSelect
    * @param iSelectType 
    */
    public MyListSelectionEvent(Object source, TableModel tableModel, int iRowToSelect, int iSelectType)
    {
        super(source);
        m_tableModel = tableModel;
        m_iRowToSelect = iRowToSelect;
        m_iSelectType = iSelectType;
    }
    /**
     * 
     * @return 
     */
    public int getType()
    {
        return m_iSelectType;
    }
    /**
     * 
     * @return 
     */
    public int getRow()
    {
        return m_iRowToSelect;
    }
    /**
     * 
     * @return 
     */
    public TableModel getModel()
    {
        return m_tableModel;
    }
  
}
