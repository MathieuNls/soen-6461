/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.MVC.view.calendar;

import com.concordia.SOEN6461.DAO.AppointmentDAO;
import com.concordia.SOEN6461.DAO.AppointmentDAOImpl;
import com.concordia.SOEN6461.MVC.model.IModel;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;

import com.concordia.SOEN6461.util.calandar.CalendarPanel;
import com.concordia.SOEN6461.MVC.model.calendar.AbstractCalendarModel;
import com.concordia.SOEN6461.MVC.model.calendar.CalendarItem;
import com.concordia.SOEN6461.MVC.model.calendar.CalendarModel;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.appointment.Appointment;
import com.concordia.SOEN6461.beans.appointment.TimeSlot;
import com.concordia.SOEN6461.beans.human.Patient;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class CalendarVector extends AbstractCalendarModel
    implements CalendarModel, IModel
{
    
    
    private static final long serialVersionUID = 1L;
    protected List<Appointment> appointments;
    protected List<String> times = new ArrayList<String>(){{
        int hours = 9;
        for(int i = 0; i < 10; i++){ // ten hours opening.
            for(int y = 0; y < 3; y++){ // 20 minutes spots
                int startMinutes = 20 * y;
                int endMinutes = 20 * (y+1);
                int displayedHours = hours;
                if(endMinutes == 60){
                    endMinutes = 0;
                    displayedHours++;
                }
                add(hours+":"+startMinutes+" - "+displayedHours+":"+endMinutes);
            }
            hours++;
        }
    }};
    
    private Clinic clinic;
    private Patient patient;
    
    

    /**
     * List of CalendarItems.
     */
    protected Vector<CalendarItem> m_vItemList = new Vector<CalendarItem>();
    
    /**
     * Called to start the applet.  You never need to call this directly; it
     * is called when the applet's document is visited.
     */
    public CalendarVector(CalendarPanel calendarPanel)
    {
        super();
    }
    
    public void init(Clinic clinic, Patient p){
        
        this.clinic = clinic;
        this.patient = p;
        
       List<TimeSlot> slots = AppointmentDAOImpl.getInstance().getFreeAppointmentsByClinic(clinic.getId());
        
        Calendar calendar = Calendar.getInstance();
        Date lStartTime;
        Date lEndTime;

        int colorHotel = 0x00c0ffff;
        int colorSelectHotel = 0x00e0ffff;
        
        int colorAir = 0x00ffc0c0;
        int colorSelectAir = 0x00ffe0e0;
        calendar.set(2014, 02, 27, 0, 0);
        lStartTime = calendar.getTime();
        calendar.add(Calendar.HOUR, 24);
        lEndTime = calendar.getTime();
        
      //  Date currentDate = appointments.get(0).getStart();
        
        int possibleSlots = times.size();
        int currentSlot = 0;
        
        for(TimeSlot slot : slots){
            if(slot.isFree()){
                 this.addElement(new CalendarProduct(this, lStartTime, lEndTime, 
                    times.get(currentSlot++),  null, null, null, colorHotel,  colorSelectHotel, 1));
            }else{
                this.addElement(new CalendarProduct(this, lStartTime, lEndTime, 
                    times.get(currentSlot++),  null, null, null, colorAir,  colorSelectAir, 1));
            }
            
            if(currentSlot == possibleSlots){
                calendar.add(Calendar.MINUTE, 2);
                lStartTime = calendar.getTime();
                calendar.add(Calendar.HOUR, 24);
                lEndTime = calendar.getTime();
                currentSlot= 0;
            }
        }
       
    }
    
    /**
     * Get the row count.
     */
    public int getRowCount()
    {
        return m_vItemList.size();
    }
    /**
     * I'm done with the model, free the resources.
     */
    public void free()
    {
    }
    /**
     * Start date for the calendar; return null to automatically set from the model.
     */
    public Date getStartDate()
    {
        return null;
    }
    /**
     * End date for the calendar; return null to automatically set from the model.
     */
    public Date getEndDate()
    {
        return null;
    }
    /**
     * End date for the calendar; return null to automatically set from the model.
     */
    public Date getSelectDate()
    {
        return null;
    }

    /**
     * Get this item.
     */
    public CalendarItem getItem(int i)
    {
        return (CalendarItem)m_vItemList.elementAt(i);
    }
    /**
     * Returns an attribute value for the cell at columnIndex and rowIndex.
     */
    public void addElement(CalendarItem item)
    {
        m_vItemList.addElement(item);
    }
    /**
     * Returns an attribute value for the cell at columnIndex and rowIndex.
     */
    public void remove(CalendarItem item)
    {
        m_vItemList.remove(item);
    }
    /**
     * Returns an attribute value for the cell at columnIndex and rowIndex.
     */
    public int indexOf(CalendarItem item)
    {
        return m_vItemList.indexOf(item);
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
}
