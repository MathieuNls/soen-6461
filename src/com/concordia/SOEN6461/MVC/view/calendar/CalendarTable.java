/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.MVC.view.calendar;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class CalendarTable extends JTable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    public CalendarTable()
    {
        super();
    }
    /**
     * 
     */
    public CalendarTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm)
    {
        super(dm, cm, sm);
    }
}
