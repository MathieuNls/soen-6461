/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.MVC.controller.calendar;

import com.concordia.SOEN6461.util.calandar.CalendarCache;
import java.awt.Point;
import java.util.EventObject;


public class CalendarDropEvent extends EventObject
{
    private static final long serialVersionUID = 1L;

//?    private CalendarItem m_calendarItem = null;
    private Point m_ptDropped = null;
    private int m_iAction = -1;

    /**
     * Called to start the applet.  You never need to call this directly; it
     * is called when the applet's document is visited.
     */
    /**
     * 
     * @param cacheItem
     * @param ptDropped
     * @param iAction 
     */
    public CalendarDropEvent(CalendarCache cacheItem, Point ptDropped, int iAction)
    {
        super(cacheItem);
        m_ptDropped = ptDropped;
        m_iAction = iAction;
    }
    /**
     * Get the point.
     */
    /**
     * 
     * @return 
     */
    public Point getPoint()
    {
        return m_ptDropped;
    }
    /**
     * Get the point.
     */
    /**
     * 
     * @return 
     */
    public int getID()
    {
        return m_iAction;
    }
}
