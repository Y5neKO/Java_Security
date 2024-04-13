/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.study.oop;

public class instanceof_test {
    public static void main(String[] args) {
        Person1 person1 = new Person1();
        System.out.println(person1 instanceof Person1);     //true
        System.out.println(person1 instanceof Student);     //false

        Student student = new Student();
        System.out.println(student instanceof Person1);     //true
        System.out.println(student instanceof Student);     //true

        Student n = null;
        System.out.println(n instanceof Student);     //false
    }
}
