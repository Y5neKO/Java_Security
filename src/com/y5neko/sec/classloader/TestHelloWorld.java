package com.y5neko.sec.classloader;

/**
 * @author Y5neKO
 */
public class TestHelloWorld {
    public String hello() {
        try {
            this.getClass().getClassLoader().loadClass("com.y5neko.sec.classloader.TestHelloWorld");
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Hello World~";
    }
}