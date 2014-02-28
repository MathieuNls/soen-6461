/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.MVC.model.calendar;

import com.concordia.SOEN6461.MVC.model.IModel;
import java.util.Date;
import java.util.EventListener;

import javax.swing.table.TableModel;


/**
 * Calendar model.
 */
public interface CalendarModel extends TableModel, IModel
{
    public final static int ICON = 0;
    public final static int START_TIME = 1;
    public final static int DESCRIPTION = 2;

  
    /**
     * I'm done with the model, free the resources.
     */
    public void free();
    /**
     * Get this Calendar Item.
     */
    public CalendarItem getItem(int i);
    /**
     * Start date for the calendar; return null to automatically set from the model.
     */
    public Date getStartDate();
    /**
     * End date for the calendar; return null to automatically set from the model.
     */
    public Date getEndDate();
    /**
     * Initial select date for the calendar; return null to automatically set from the model.
     */
    public Date getSelectDate();
    /**
     * Notify listeners this row is selected; pass a -1 to de-select all rows.
     * @param iSelectionType NormalSelection(mouseover for .5), ContentSelection(clicked), AddSelection(shift-click)
     */
    public void fireTableRowSelected(Object source, int iRowIndex, int iSelectionType);
    /**
     * Add a listener to my list.
     */
    public void addMySelectionListener(EventListener l);
    /**
     * Remove a listener from my list.
     */
    public void removeMySelectionListener(EventListener l);
    /**
     * Notify the listeners of the rows being updated.
     */
    public void fireTableRowsUpdated(int firstRow, int lastRow);
}
