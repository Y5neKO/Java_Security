/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.CodeAudit.reflect;

public class TestInit {
    public static void main(String[] args) throws Exception {
//        TrainPrint trainPrint = new TrainPrint();

        System.out.println("=================");

//        Class<?> clazz = Class.forName("com.y5neko.CodeAudit.reflect.TrainPrint");

        TestInit.ref("com.y5neko.CodeAudit.reflect.TestInit_TouchFile");
    }

    public static void ref(String name) throws Exception {
        Class.forName(name);
    }
}
