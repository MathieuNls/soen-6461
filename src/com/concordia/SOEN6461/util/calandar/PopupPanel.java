/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package com.concordia.SOEN6461.util.calandar;

import javax.swing.Popup;

public interface PopupPanel {
    /**
     * Set my popup parent, so I can hide when the user clicks a button.
     * @param popupParent
     */
    public void setPopupParent(Popup popupParent);

}
