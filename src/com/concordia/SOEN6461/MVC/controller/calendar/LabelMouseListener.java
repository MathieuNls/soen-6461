/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.MVC.controller.calendar;

import com.concordia.SOEN6461.MVC.controller.PopupDocController;
import com.concordia.SOEN6461.MVC.model.calendar.CalendarVector;
import com.concordia.SOEN6461.MVC.view.calendar.JUnderlinedLabel;
import com.concordia.SOEN6461.util.calandar.CalendarCache;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import com.concordia.SOEN6461.util.calandar.CalendarPanel;
import com.concordia.SOEN6461.util.calendarpanel.dragNdrop.CalendarDnDMouseListener;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.appointment.AppointmentDetails;
import java.util.Calendar;


/**
 * Process mouse overs, clicks, and drags on an UnderlinedLabel.
 * NOTE: Remember to add this as a MouseListener and a MouseMotionListener!
 */
public class LabelMouseListener extends CalendarDnDMouseListener
    implements ActionListener
{
    private JUnderlinedLabel m_component = null;
    private CalendarCache m_cacheItem = null;
    private boolean m_bEnableDnD = false;

    /**
     * Constructor.
     */
    public LabelMouseListener()
    {
        super();
    }

    /**
     * Constructor
     * @param cacheItem
     * @param component
     * @param bEnableDnD 
     */
    public LabelMouseListener(CalendarCache cacheItem, JUnderlinedLabel component, boolean bEnableDnD)
    {
        this();
        this.init(cacheItem, component, bEnableDnD);
    }
    
    /**
     * 
     * @param cacheItem
     * @param component
     * @param bEnableDnD 
     */
    public void init(CalendarCache cacheItem, JUnderlinedLabel component, boolean bEnableDnD)
    {
        super.init(component);
        m_cacheItem = cacheItem;
        m_component = component;
        m_bEnableDnD = bEnableDnD;
    }
    
    private javax.swing.Timer m_timer = null;
    
    /**
     * Mouse entered here
     * @param e 
     */
    public void mouseEntered(MouseEvent e)
    {
        if (m_cacheItem != null)
            m_cacheItem.setUnderlined(true);
        if (m_timer == null)
        {
            m_timer = new javax.swing.Timer(500, this);   // Notify me in 1/2 second
            m_timer.setRepeats(false);          // Only once
            m_timer.start();
        }
        if (m_component.getTooltip() != null)
        	if (m_component.getTooltip().length() > 0)
        		if (this.getCalendarPanel() != null)
                        {
        			this.getCalendarPanel().setStatusText(m_component.getTooltip()); // Change the status display
                        }
        
    }
  
    /**
     * 
     * @param e 
     */
    public void mouseExited(MouseEvent e)
    {
        if (m_cacheItem != null)
            m_cacheItem.setUnderlined(false);
        if (m_timer != null)
            this.removeTimer();
        if (m_component.getTooltip() != null)
        	if (m_component.getTooltip().length() > 0)
        		if (this.getCalendarPanel() != null)
        			this.getCalendarPanel().setStatusText(null); // Clear the status display
    }
    
   /**
    * 
    * @param e 
    */
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);    // Save the point
        
       long time = m_cacheItem.getItem().getStartDate().getTime();
        // Creates a date rounded down to the last <code>lenghtAppointment</code>. 20h37 became 20h20.
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new Date()); To uncomment after test
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.HOUR, 9); // Opening hours
        calendar.add(Calendar.MINUTE, 20 * m_cacheItem.getLine(null));
        calendar.add(Calendar.MINUTE, -20);      
        
        new PopupDocController(calendar.getTimeInMillis(), new Clinic(1), CalendarVector.getPatient(), CalendarVector.appointmentDetails, m_cacheItem.getIndex()).start();
        
        CalendarVector.m_vItemList.get(m_cacheItem.getIndex()).setColor(0x00ffe0e0);
        
        System.out.println(m_cacheItem.getLine(null));
    }
    
   /**
    * 
    * @param e 
    */
    public void mouseReleased(MouseEvent e)
    {
        CalendarPanel parent = this.getCalendarPanel();
        if (m_ptMouseAtClick != null)
            if (!this.movedEnough(e))
        {   // Clicked - display content
            if (parent != null)
                if (m_cacheItem != null)
            {
                int iIndex = parent.getItemIndex(m_cacheItem);
                parent.getModel().fireTableRowSelected(this, iIndex, MyListSelectionEvent.CONTENT_SELECT | MyListSelectionEvent.CONTENT_CLICK);     // Notify the model of the new selection
                parent.requestFocus();      // Send key events here
                e.consume();    // It's mine.
                m_ptMouseAtClick = null;
            }
        }
        super.mouseReleased(e);
    }

    /**
     *  0.5 seconds passed, select the item.
     * @param e 
     */
    public void actionPerformed(ActionEvent e)
    {
        CalendarPanel parent = this.getCalendarPanel();
        if (parent != null)
            if (m_cacheItem != null)
        {
            int iIndex = parent.getItemIndex(m_cacheItem);
            if (!parent.isShifted())
                parent.getModel().fireTableRowSelected(this, iIndex, MyListSelectionEvent.SELECT);      // Notify the model of the new selection
            else
                parent.getModel().fireTableRowSelected(this, iIndex, MyListSelectionEvent.ADD_SELECT);      // Notify the model of the new selection
            parent.requestFocus();      // Send key events here
        }
        this.removeTimer();
    }
    /**
     * Remove this timer.
     */
    public synchronized void removeTimer()
    {
        if (m_timer != null)
        {
            m_timer.stop();
            m_timer.removeActionListener(this);
            m_timer = null;
        }
    }
    /**
     * Remove this timer.
     */
    public CalendarPanel getCalendarPanel()
    {
        Component parent = m_component;
        while ((parent = parent.getParent()) != null)
        {
            if (parent instanceof CalendarPanel)
                return (CalendarPanel)parent;
        }
        return null;
    }
    /**
     * Invoked when a mouse button is pressed on a component and then 
     * dragged.  <code>MOUSE_DRAGGED</code> events will continue to be 
     * delivered to the component where the drag originated until the 
     * mouse button is released (regardless of whether the mouse position 
     * is within the bounds of the component).
     * <p> 
     * Due to platform-dependent Drag&Drop implementations, 
     * <code>MOUSE_DRAGGED</code> events may not be delivered during a native 
     * Drag&Drop operation.  
     */
    public void mouseDragged(MouseEvent e)
    {
        if (m_bEnableDnD)
        {
            super.mouseDragged(e);
        }
    }
}
    
