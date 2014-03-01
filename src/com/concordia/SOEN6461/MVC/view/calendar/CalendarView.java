/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.MVC.view.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import com.concordia.SOEN6461.util.calandar.CalendarPanel;
import com.concordia.SOEN6461.MVC.model.calendar.CalendarModel;
import com.concordia.SOEN6461.MVC.view.AbstractView;
import java.util.List;


public class CalendarView extends AbstractView
{
    private static final long serialVersionUID = 1L;
    private CalendarModel _calenderModel;

    /**
     *  OrderEntry Class Constructor.
     */
    public CalendarView()
    {
        super();
       
        
    }
    /**
     * For Stand-alone.
     */
//    public static void main(String[] args)
//    {
//        JFrame frame;
//        CalendarView applet = new CalendarView();
//        try {
//            frame = new JFrame("Calendar");
//        } catch (java.lang.Throwable ivjExc) {
//            frame = null;
//            System.out.println(ivjExc.getMessage());
//            ivjExc.printStackTrace();
//        }
//        frame.getContentPane().add(BorderLayout.CENTER, applet);
//        Dimension size = applet.getSize();
//        if ((size == null) || ((size.getHeight() < 100) | (size.getWidth() < 100)))
//            size = new Dimension(640, 400);
//        frame.setSize(size);
//
//        applet.init(); 
//        frame.setTitle("Sample calendar application");
//
//        frame.setVisible(true);
//    }
    /**
     * Initialize this applet.
     */
    public void init()
    {
//        JFrame frame = new JFrame("Calendar");
//        this.getContentPane().add(BorderLayout.CENTER, frame);
        Dimension size = this.getSize();
        if ((size == null) || ((size.getHeight() < 100) | (size.getWidth() < 100)))
            size = new Dimension(640, 400);
        this.setSize(size);
        
        this.getContentPane().setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        this.addSubPanels(panel);
    }
    
    /**
     * Add any applet sub-panel(s) now.
     */
    public boolean addSubPanels(Container parent)
    {
        parent.setLayout(new BoxLayout(parent, BoxLayout.Y_AXIS));
        JScrollPane scroller = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scroller.setOpaque(false);
        scroller.getViewport().setOpaque(false);
        scroller.setPreferredSize(new Dimension(800, 400));
        scroller.setAlignmentX(LEFT_ALIGNMENT);
        scroller.setAlignmentY(TOP_ALIGNMENT);

      //  CalendarModel model = this.setupTestModel();

        CalendarPanel panel = new CalendarPanel(_calenderModel, true, null);
        panel.setAlignmentY(TOP_ALIGNMENT);
        
        scroller.setViewportView(panel);
        JPanel scrollerHolder = new JPanel();
        scrollerHolder.add(scroller);
        scrollerHolder.setLayout(new BoxLayout(scrollerHolder, BoxLayout.X_AXIS));
        parent.add(scrollerHolder);
        
        JPanel bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(10, 100));
        parent.add(bottom);
        panel.setAlignmentY(BOTTOM_ALIGNMENT);
        
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        CalendarForm left = new CalendarForm();
        bottom.add(left);
        left.setAlignmentX(LEFT_ALIGNMENT);        
        left.setBorder(new LineBorder(Color.BLACK));
        _calenderModel.addMySelectionListener(left);
        _calenderModel.addTableModelListener(left);
        
        JScrollPane middle = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        JTable table = new CalendarTable(_calenderModel, null, null);
        middle.getViewport().add(table);
        bottom.add(middle);
        middle.setAlignmentX(0);
        middle.setBorder(new LineBorder(Color.BLACK));
        
        CalendarPanel right = new CalendarPanel(_calenderModel, false, null);
        bottom.add(right);
        right.setAlignmentX(RIGHT_ALIGNMENT);        
        right.setBorder(new LineBorder(Color.BLACK));
        return true;
    }
//
//    public CalendarModel setupTestModel()
//    {
//        CalendarVector model = new CalendarVector(null);
//
//        Calendar calendar = Calendar.getInstance();
//        Date lStartTime;
//        Date lEndTime;
//        
//        
//       
//        lStartTime = calendar.getTime();
//        calendar.add(Calendar.DATE, 3);
//        lEndTime = calendar.getTime();
//
//        int colorHotel = 0x00c0ffff;
//        int colorSelectHotel = 0x00e0ffff;
//        int colorLand = 0x00c0c0ff;
//        int colorSelectLand = 0x00e0e0ff;
//        int colorAir = 0x00ffc0c0;
//        int colorSelectAir = 0x00ffe0e0;
//
//        lStartTime = calendar.getTime();
//        calendar.add(Calendar.HOUR, 24);
//        lEndTime = calendar.getTime();
//        model.addElement(new CalendarProduct(model, lStartTime, lEndTime, "Available 8:30-9:00", 
//                null, null, null, colorHotel, colorSelectHotel, 1));
//        model.addElement(new CalendarProduct(model, lStartTime, lEndTime, "Available 9-9:30", 
//                null, null, null, colorHotel, colorSelectHotel, 1));
//        model.addElement(new CalendarProduct(model, lStartTime, lEndTime, "Available 10-10:30", 
//                null, null, null, colorHotel, colorSelectHotel, 1));
//        model.addElement(new CalendarProduct(model, lStartTime, lEndTime, "Not Available", 
//               null, null, null, colorAir, colorSelectAir, 1));
//         model.addElement(new CalendarProduct(model, lStartTime, lEndTime, "Not Available", 
//                null, null, null, colorAir, colorSelectAir, 1));
//
//        return model;
//    }

    
    
    public void setModel(CalendarModel model) {
        this._calenderModel = model;
    }


    public List<String> userInputs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVisible() {
        init();
        this.setVisible(true);
    }

}
