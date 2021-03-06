/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.MVC.model.calendar;

import java.awt.Image;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

import com.concordia.SOEN6461.MVC.controller.calendar.MyListSelectionEvent;
import com.concordia.SOEN6461.MVC.controller.calendar.MyListSelectionListener;
import com.concordia.SOEN6461.MVC.model.IModel;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.appointment.AppointmentDetails;
import com.concordia.SOEN6461.beans.human.Patient;


/**
 * The abstract calendar model is a model that handles the basic functions for the calendar model.
 */
public abstract class AbstractCalendarModel extends AbstractTableModel
    implements CalendarModel, IModel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * Returns the number of columns managed by the data source object.
     * @return 
     */
        @Override
    public int getColumnCount()
    {
        return CalendarModel.DESCRIPTION + 1;
    }
    /**
     * Returns the name of the column at columnIndex.
     * @return 
     */
        @Override
    public String getColumnName(int columnIndex)
    {
        switch (columnIndex)
        {
            case CalendarModel.ICON:
                return "Type";
            case CalendarModel.START_TIME:
                return "Start time";
            case CalendarModel.DESCRIPTION:
                return "Description";
        }
        return null;
    }
    
   public abstract void init(Clinic clinic, Patient p, AppointmentDetails appointmentDetails);
    
    
    /**
     *  Returns Object.class by default
     * @param columnIndex
     * @return 
     */
        @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        switch (columnIndex)
        {
            case CalendarModel.ICON:
                return ImageIcon.class;
            case CalendarModel.START_TIME:
                return String.class;
            case CalendarModel.DESCRIPTION:
                return String.class;
        }
        return super.getColumnClass(columnIndex);
    }
    /**
     *  This default implementation returns false for all cells
     * @param columnIndex
     * @return 
     */
        @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        if (columnIndex == CalendarModel.START_TIME)
            return true;
        return super.isCellEditable(rowIndex, columnIndex);
    }
    /**
     * Returns an attribute value for the cell at columnIndex and rowIndex.
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
        @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        CalendarItem item = this.getItem(rowIndex);
        if (columnIndex == CalendarModel.ICON)
        {
            Object image = item.getIcon(CalendarConstants.START_ICON);
            if (image instanceof Image)
                return new ImageIcon((Image)image);
            else
                return image;
        }
        if (columnIndex == CalendarModel.START_TIME)
            return item.getStartDate();
        if (columnIndex == CalendarModel.DESCRIPTION)
            return item.getDescription();
        return null;
    }
  
    /**
     * This empty implementation is provided so users don't have to implement
     *  this method if their data model is not editable.
     * @param aValue
     * @param rowIndex
     * @param columnIndex 
     */
        @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    /**
     * Notify listeners this row is selected; pass a -1 to de-select all rows.
     * @param source
     * @param iRowIndex
     * @param iSelectionType 
     */
        @Override
    public void fireTableRowSelected(Object source,int iRowIndex,int iSelectionType)
    {
        this.fireMySelectionChanged(new MyListSelectionEvent(source, this, iRowIndex, iSelectionType));
    }
    
    /**
     *  The listener list.
     */
    protected EventListenerList listenerList = new EventListenerList();
    /**
     * Add a listener to my list.
     */
    public void addMySelectionListener(EventListener l)
    {
        listenerList.add(MyListSelectionListener.class, (MyListSelectionListener)l);
    }
    /**
     * Remove a listener from my list.
     */
    public void removeMySelectionListener(EventListener l)
    {
        listenerList.remove(MyListSelectionListener.class, (MyListSelectionListener)l);
    }
    /**
     * Notify all listeners that have registered interest for
     * notification on this event type.  The event instance 
     * is lazily created using the parameters passed into 
     * the fire method.
     */
    protected void fireMySelectionChanged(MyListSelectionEvent event)
    {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2)
        {
            if (listeners[i]==MyListSelectionListener.class)
                if (listeners[i] != event.getSource())  // Don't send it back to source
            { // Send this message
                ((MyListSelectionListener)listeners[i+1]).selectionChanged(event);
            }
        }
    }
}
