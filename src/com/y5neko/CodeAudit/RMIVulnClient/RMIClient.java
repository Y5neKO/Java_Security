/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.CodeAudit.RMIVulnClient;

import com.y5neko.CodeAudit.RMIVuln.ICalc;

import java.io.Serializable;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

public class RMIClient implements Serializable {
    public class Payload extends ArrayList<Integer> {}

    public void lookup() throws Exception {
        ICalc r = (ICalc) Naming.lookup("rmi://127.0.0.1:1098/hello");

        List<Integer> li = new Payload();
        li.add(32);
        li.add(4);

        System.out.println(r.sum(li));
    }

    public static void main(String[] args) throws Exception {
        new RMIClient().lookup();
    }
}
