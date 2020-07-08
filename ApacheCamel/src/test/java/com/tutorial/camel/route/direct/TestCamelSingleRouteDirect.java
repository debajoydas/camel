package com.tutorial.camel.route.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class TestCamelSingleRouteDirect extends CamelTestSupport {

    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SingleRouteBuilder();
    }

    @Test
    public void checkOutpoutDirectory() throws InterruptedException {

        template.sendBody("direct:sampleInput","Hello,Debajoy,1234556433");
        Thread.sleep(5000);
        File file = new File("sampleOutput");
        assertTrue(file.isDirectory());

        Exchange exchange = consumer.receive("file:sampleOutput");
        System.out.println("Received body is :" + exchange.getIn().getBody());
        System.out.println("File Name is :" + exchange.getIn().getHeader("CamelFileName"));

        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}
