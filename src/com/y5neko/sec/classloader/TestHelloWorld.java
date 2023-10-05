/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.classloader;

/**
 * @author Y5neKO
 */
public class TestHelloWorld {
    public String hello() {
        try {
            this.getClass().getClassLoader().loadClass("com.y5neko.sec.classloader.TestHelloWorld");
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Hello World~";
    }
}