//The MIT License (MIT)
//
//Copyright (c) 2014 - Mathieu Nayrolles
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in
//all copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//THE SOFTWARE.



package com.concordia.SOEN6461.MVC.view.calendar;

import com.concordia.SOEN6461.MVC.model.LoginModel;
import com.concordia.SOEN6461.MVC.model.PopupDocModel;
import com.concordia.SOEN6461.MVC.view.AbstractView;
import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.human.Doctor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Mathieu Nayrolles
 */
public class PopupDocView extends AbstractView{
    
    PopupDocModel model;

    /** Creates new form PopupDoc */
    public PopupDocView() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        doctors = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        book = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rooms = new javax.swing.JList();
        date1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        creditCarNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        securityNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateOfExpiration = new javax.swing.JTextField();

        jScrollPane1.setViewportView(doctors);

        jLabel1.setText("Available Doctors ");

        book.setText("Book");

        jScrollPane2.setViewportView(rooms);

        jLabel2.setText("Available Rooms");

        jLabel3.setText("Credit Card Number");

        jLabel4.setText("Security Number");

        jLabel5.setText("Date of Expiration");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(125, 125, 125)
                                            .addComponent(date1))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(35, 35, 35)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(creditCarNumber)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(book))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(securityNumber)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(dateOfExpiration)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(date1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditCarNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(securityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dateOfExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(book)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton book;
    private javax.swing.JTextField creditCarNumber;
    private javax.swing.JLabel date1;
    private javax.swing.JTextField dateOfExpiration;
    private javax.swing.JList doctors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList rooms;
    private javax.swing.JTextField securityNumber;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<String> userInputs() {
       return new ArrayList<String>(){{
           add(creditCarNumber.getText());
           add(securityNumber.getText());
           add(dateOfExpiration.getText());
      }};
    }

    @Override
    public void setVisible() {
        updateListRooms();
        updateListDoctors();
        this.setVisible(true);
    }
    
    public void setModel(PopupDocModel model) {
        
        this.model = model;
    }
    
    private void updateListDoctors(){
        DefaultListModel listModel = new DefaultListModel();
        for(Doctor doc : this.model.getAvailableDoctor()){
             listModel.addElement(doc.getGivenName() + " " + doc.getFamilyName());
        }
        
        doctors.setModel(listModel);
       
    }
    
    private void updateListRooms(){
        DefaultListModel listModel = new DefaultListModel();
        for(Room room : this.model.getAvailableRoom()){
             listModel.addElement(room.toString());
        }
        
        rooms.setModel(listModel);
       
    }
    
    public void addBookListener(ActionListener bookListner){
        this.book.addActionListener(bookListner);
    }
    
    public void addDoctorsListener(ListSelectionListener listener){
        this.doctors.addListSelectionListener(listener);
    }
    
    public void addRoomsListener(ListSelectionListener listener){
        this.rooms.addListSelectionListener(listener);
    }

    public int getSelectedDoctorIndex() {
        return doctors.getSelectedIndex();
    }

    public int getSelectedRoomIndex() {
       return rooms.getSelectedIndex();
    }

}
