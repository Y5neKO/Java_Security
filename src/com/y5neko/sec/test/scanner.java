/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.test;

import java.util.ArrayList;
import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("asd");
        arrayList.add("qwe");
        arrayList.add("zxc");
        arrayList.remove(0);
        arrayList.remove("zxc");
        System.out.println(arrayList);
        arrayList.set(0,"abc");
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.size());
    }
}
