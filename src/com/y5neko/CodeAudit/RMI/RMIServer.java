/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.CodeAudit.RMI;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
    public interface IRemoteHelloWorld extends Remote {
        public String hello() throws RemoteException;
    }

    public class RemoteHelloWorld extends UnicastRemoteObject implements IRemoteHelloWorld {
        protected RemoteHelloWorld() throws RemoteException {
            super();
        }

        public String hello() throws RemoteException {
            return "Hello World!";
        }
    }

    public class Test123 extends UnicastRemoteObject implements IRemoteHelloWorld {
        protected Test123() throws RemoteException {
            super();
        }

        public String hello() throws RemoteException {
            return "Hello Tester!";
        }
    }

    private void start() throws Exception {
        RemoteHelloWorld remoteHelloWorld = new RemoteHelloWorld();
        Test123 test123 = new Test123();

        LocateRegistry.createRegistry(1098);
        Naming.rebind("rmi://localhost:1098/hello", remoteHelloWorld);
        Naming.rebind("rmi://localhost:1098/test", test123);
    }

    public static void main(String[] args) throws Exception {
        new RMIServer().start();
    }
}
