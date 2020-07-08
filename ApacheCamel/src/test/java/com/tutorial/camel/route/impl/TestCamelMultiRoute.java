package com.tutorial.camel.route.impl;

import com.tutorial.camel.route.impl.MutliRouteBuilder;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class TestCamelMultiRoute extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MutliRouteBuilder();
    }
    @Test
    public void checkOutpoutDirectory() throws InterruptedException {
        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
    }
}
