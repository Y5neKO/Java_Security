/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.deserialize;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class TestHashMapPut {
    public static void main(String[] args) throws MalformedURLException {
        HashMap map = new HashMap();
        URL url = new URL("http://d1dd3347.su19.org/");
        map.put(url, 1);
    }
}