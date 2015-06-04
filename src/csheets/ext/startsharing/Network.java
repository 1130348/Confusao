/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


/**
 *
 * @author Paulo Pereira
 */
public class Network {

    private static final int DEFAULT_PORT = 0;

    private static int port = DEFAULT_PORT;

    public static ArrayList<String> searchClient(){
        return null;
    }

    /*
     * To make sure that this class is a service class
     */
    private Network() {
    }

    public static int getPort(){
        return port;
    }
    
    public static void setPort(int newPort){
        port = newPort;
    }
    
    public static boolean sendData(Object object){
        return false;
    }
    
    public static Object receiveData(){
        return null;
    }
}
