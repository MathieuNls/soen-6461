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

package com.concordia.SOEN6461.MVC.model;

import com.concordia.SOEN6461.DAO.AppointmentDAOImpl;
import com.concordia.SOEN6461.DAO.EmployeeDAOImpl;
import com.concordia.SOEN6461.DAO.RoomDAOImpl;
import com.concordia.SOEN6461.beans.Clinic;
import com.concordia.SOEN6461.beans.Room;
import com.concordia.SOEN6461.beans.appointment.Appointment;
import com.concordia.SOEN6461.beans.appointment.AppointmentDetails;
import com.concordia.SOEN6461.beans.human.Doctor;
import com.concordia.SOEN6461.beans.human.Patient;
import java.util.List;

/**
 * @author Mathieu Nayrolles
 */
public class PopupDocModel  implements IModel{
    
    List<Doctor> availableDoctor;
    List<Room> availableRoom;
    AppointmentDetails appointmentDetails;
    Patient patient;
    Long time;
    Clinic clinic;
    int indexSelected; 
    int selectedDoctor = -1;
    int selectedRoom = -1;
    
    /**
     * 
     * @param clinic
     * @param given_time
     * @param patient
     * @param appointmentDetails
     * @param indexSelected 
     */
    public void init(Clinic clinic, long given_time, Patient patient, AppointmentDetails appointmentDetails, int indexSelected){
        this.time = given_time;
        this.clinic = clinic;
        this.patient = patient;
        this.indexSelected = indexSelected;
        this.availableDoctor = 
                EmployeeDAOImpl.getInstance().freeDoctorFromAClinicAtaGivenTime(clinic.getId(), given_time);
        this.availableRoom = 
                RoomDAOImpl.getInstance().freeRoomAtaGivenTime(clinic.getId(), given_time);
        this.appointmentDetails = appointmentDetails;
    }

    /**
     * 
     * @return 
     */
    public List<Doctor> getAvailableDoctor() {
        return availableDoctor;
    }

    /**
     * 
     * @param availableDoctor 
     */
    public void setAvailableDoctor(List<Doctor> availableDoctor) {
        this.availableDoctor = availableDoctor;
    }

    /**
     * 
     * @return 
     */
    public List<Room> getAvailableRoom() {
        return availableRoom;
    }

    /**
     * 
     * @param availableRoom 
     */
    public void setAvailableRoom(List<Room> availableRoom) {
        this.availableRoom = availableRoom;
    }

    /**
     * 
     * @return 
     */
    public Long getTime() {
        return time;
    }

    /**
     * 
     * @param time 
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 
     * @return 
     */
    public int getSelectedDoctor() {
        return selectedDoctor;
    }

    /**
     * 
     * @param selectedDoctor 
     */
    public void setSelectedDoctor(int selectedDoctor) {
         
        this.selectedDoctor = selectedDoctor;
         System.out.println("doc " + selectedDoctor);
    }

    /**
     * 
     * @return 
     */
    public int getSelectedRoom() {
        return selectedRoom;
    }

    /**
     * 
     * @param selectedRoom 
     */
    public void setSelectedRoom(int selectedRoom) {
        this.selectedRoom = selectedRoom;
         System.out.println("room " + selectedRoom);
    }

    /**
     * 
     * @return 
     */
    public String persistAppointment() {
        if(this.selectedDoctor == -1 || this.selectedRoom == -1){
            return "You must select a room and a doctor";
        }
        else{
             Appointment app = new Appointment(availableDoctor.get(selectedDoctor), 
                     patient , 
                     availableRoom.get(selectedRoom) , time, appointmentDetails, clinic);
             
             AppointmentDAOImpl.getInstance().persistAppointment(app);
             return "success";
        }
    }

    /**
     * 
     * @return 
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * 
     * @param patient 
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * 
     * @return 
     */
    public Clinic getClinic() {
        return clinic;
    }

    /**
     * 
     * @param clinic 
     */
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    /**
     * 
     * @return 
     */
    public AppointmentDetails getAppointmentDetails() {
        return appointmentDetails;
    }

    /**
     * 
     * @param appointmentDetails 
     */
    public void setAppointmentDetails(AppointmentDetails appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    /**
     * 
     * @return 
     */
    public int getIndexSelected() {
        return indexSelected;
    }

    /**
     * 
     * @param indexSelected 
     */
    public void setIndexSelected(int indexSelected) {
        this.indexSelected = indexSelected;
    }
    
    
      
}