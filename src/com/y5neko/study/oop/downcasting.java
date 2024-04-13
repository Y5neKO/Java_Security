/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.study.oop;

public class downcasting {
    Person1 person1 = new Student();    //向上转型成功
    Person1 person2 = new Person1();
    Student student1 = (Student) person1;   //向下转型成功,因为person1本身就是指向Student
    Student student2 = (Student) person2;   //向下转型失败,将 'person2' 转换为 'Student' 会为任意非 null 值生成 'ClassCastException'

}
