/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.CodeAudit.RMIVuln;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RemoteRMIServer {
    private void start() throws Exception {
        if (System.getSecurityManager() == null) {
            System.out.println("setup SecurityManager");
            System.setSecurityManager(new SecurityManager());
        }

        Calc h = new Calc();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost:1099/refObj", h);
    }

    public static void main(String[] args) throws Exception {
        new RemoteRMIServer().start();
    }
}
