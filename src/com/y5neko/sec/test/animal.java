/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.test;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

/**
 * @author Y5neKO
 */
public class animal {
    public static void main(String[] args) {
        ChinaDog chinaDog = new ChinaDog();
        SpDog spDog = new SpDog();
        HashDog hashDog = new HashDog();
        chinaDog.eat();
        spDog.eat();
        hashDog.boom();
    }

    public static class dog{
        public void dog(){
        }
        public void eat(){
            System.out.println("吃狗粮");
        }
        public void drink(){
            System.out.println("喝水");
        }
        public void watchdog(){
            System.out.println("看家");
        }
    }

    public static class ChinaDog extends dog{
        @Override
        public void eat(){
            System.out.println("吃剩饭");
        }
    }

    public static class SpDog extends dog{
        @Override
        public void eat(){
            System.out.println("吃狗粮，吃骨头");
        }
    }

    public static class HashDog extends dog{
        public void boom(){
            System.out.println("拆家");
        }
    }
}
