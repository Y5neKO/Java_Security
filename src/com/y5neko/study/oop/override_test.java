/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.study.oop;

public class override_test {
    public static void main(String[] args) {
        Student1 student1 = new Student1();
        student1.run();
    }
}
class Student1 extends Person1{
    @Override
    public void run(){
        System.out.println("Student1 run");
    }
}