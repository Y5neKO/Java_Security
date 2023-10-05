/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.proxy;

import java.io.File;

public class UnixFileSystem implements FileSystem {

    /* -- Disk usage -- */
    public int spaceTotal = 996;

    @Override
    public String[] list(File file) {
        System.out.println("正在执行[" + this.getClass().getName() + "]类的list方法，参数:[" + file + "]");

        return file.list();
    }

}