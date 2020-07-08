package com.tutorial.camel.route.impl.defaulthandler;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class TestDefaultHandler extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new DefaultHandlerRoute();
    }
    @Test(expected = RuntimeException.class)
    public void checkDefaultException() throws InterruptedException {
        String request=null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);
    }
}
