/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.study.oop;

public class method {
    public static void main(String[] args) {
        Group group = new Group();
        group.setNames("y5neko1", "y5neko2", "y5neko3", "y5neko4");
        String[] group_test = group.getNames();

        for (String s : group_test) {
            System.out.println(s);
        }
    }
}
