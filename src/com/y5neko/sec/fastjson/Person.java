/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.fastjson;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){this.name = name;this.age = age;}

    public Person(){System.out.println("constructor被调用了");}

    public String getName() {System.out.println("getName被调用了");return this.name;}

    public void setName(String name) {System.out.println("setName被调用了");this.name = name;}

    public int getAge() {System.out.println("getAge被调用了");return this.age;}

    public void setAge(int age) { System.out.println("setAge被调用了");this.age = age;}
}