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

package com.concordia.SOEN6461.messaging;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Mathieu Nayrolles
 */
public class Server extends Thread {
 
    protected DatagramSocket socket = null;
    protected Integer appointment;
 
    /**
     * 
     * @param appointment
     * @throws IOException 
     */
    public Server(Integer appointment) throws IOException {
        this("messaging_server", appointment);
    }
 
    /**
     * 
     * @param name
     * @param appointment
     * @throws IOException 
     */
    public Server(String name, Integer appointment) throws IOException {
        super(name);
        socket = new DatagramSocket(4445);
        this.appointment = appointment;
    }
 
    /**
     * 
     */
    @Override
    public void run() {
        
        try {
                  byte[] buf = new byte[256];

  
                buf = appointment.toString().getBytes();

		    // send it
                InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                socket.send(packet);

		
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        socket.close();
    }
 
}

