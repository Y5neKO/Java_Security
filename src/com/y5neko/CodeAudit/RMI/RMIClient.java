/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.CodeAudit.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        RMIServer.IRemoteHelloWorld helloWorld = (RMIServer.IRemoteHelloWorld) Naming.lookup("rmi://localhost:1099/hello");
        String res = helloWorld.hello();
//        System.out.println(res);

        String[] objStrings = Naming.list("rmi://195.96.76.124:1043");
        for (String obj : objStrings) {
            System.out.println(obj);
        }
    }
}
