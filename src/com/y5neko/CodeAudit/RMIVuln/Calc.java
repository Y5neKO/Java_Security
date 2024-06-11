/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.CodeAudit.RMIVuln;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Calc extends UnicastRemoteObject implements ICalc {
    public Calc() throws RemoteException {
        super();
    }

    public Integer sum(List<Integer> params) throws RemoteException {
        Integer sum = 0;
        for (Integer param : params) {
            sum += param;
        }
        return sum;
    }
}
