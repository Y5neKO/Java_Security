/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.CodeAudit.reflect;

public class TestInit_TouchFile {
    static {
        try {
            System.out.println("success");

            Runtime rt = Runtime.getRuntime();
            String[] cmd = {"cmd", "/c", "echo", "Hello, World!", ">", "test.txt"};
            Process p = rt.exec(cmd);
            p.waitFor();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
