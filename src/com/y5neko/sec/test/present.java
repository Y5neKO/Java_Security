/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.test;

public class present {
    public static void main(String[] args) {
        son son = new son();
        System.out.println(son.test);
    }
    static class father{
        public String test = "";
        public father(){
            this("东软");
            System.out.println("父类构造方法");
        }
        public father(String test){
            this.test = test;
            System.out.println("父类有参构造方法");
        }
    }

    static class son extends father{
        public son(){
            //super();
            System.out.println("子类构造方法");
        }
    }
}
