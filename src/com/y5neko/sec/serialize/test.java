/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.serialize;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] bytes = new byte[]{-84, -19, 0, 5, 115, 114, 0, 44, 99, 111, 109, 46, 121, 53, 110, 101, 107, 111, 46, 115, 101, 99, 46, 115, 101, 114, 105, 97, 108, 105, 122, 101, 46, 68, 101, 115, 101, 114, 105, 97, 108, 105, 122, 97, 116, 105, 111, 110, 84, 101, 115, 116, 77, -33, 20, -81, -27, -97, -91, 58, 2, 0, 2, 76, 0, 5, 101, 109, 97, 105, 108, 116, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 76, 0, 8, 117, 115, 101, 114, 110, 97, 109, 101, 113, 0, 126, 0, 1, 120, 112, 116, 0, 17, 49, 55, 50, 55, 48, 53, 56, 56, 51, 52, 64, 113, 113, 46, 99, 111, 109, 116, 0, 6, 89, 53, 110, 101, 75, 79};
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);

        ObjectInputStream ois = new ObjectInputStream(bais);

        DeserializationTest test = (DeserializationTest) ois.readObject();

        System.out.println(test.getUsername());
    }
}
