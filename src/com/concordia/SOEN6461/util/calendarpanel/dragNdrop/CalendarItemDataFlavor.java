/*
 * ProductTransferable.java
 *
 * Created on August 17, 2004, 1:36 AM

 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.util.calendarpanel.dragNdrop;

import java.awt.datatransfer.DataFlavor;

/**
 * Data type expected for product transfers.
 */
public class CalendarItemDataFlavor extends DataFlavor
{    
    /**
     *
     */
    public CalendarItemDataFlavor()
    {
        super(CalendarItemProperties.class, "Calendar Information");
    }

}
