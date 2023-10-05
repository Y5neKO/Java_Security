/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.phone;

public class phone {
    public String test = "publicField1";
    public String test1 = "publicField2";
    private String name;
    private double weight;
    public phone(){
    }
    public phone(String name,double weight){
        this.name=name;
        this.weight=weight;
    }
    private phone(String name, double weight, String test){
    }
    public void dianyuan(){ //定义一个无返回值的方法，调用会打印"开机"
        System.out.println("开机");
    }
    public void setName(String name){ //定义一个形参为String类型的方法，调用后给name属性赋值
        this.name=name;
    }
    public String getName(){ //定义一个调用后返回name属性的值的方法
        return name;
    }
    public void setWeight(double weight){ //定义一个形参为double类型的方法，调用后给weight属性赋值
        this.weight=weight;
    }
    public double getWeight(){ //定义一个调用后返回weight属性的值的方法
        return weight;
    }

    private void poweroff(){
        System.out.println("关机");
    }
}