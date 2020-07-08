package com.tutorial.camel.route.impl.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class TestCamelProcessor extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new TransformInputDataRoute();
    }

    @Test
    public void checkCamelProcessor() throws InterruptedException {

        Thread.sleep(5000);
        File file = new File("data/output3");
        assertTrue(file.isDirectory());
        assertEquals(1,file.listFiles().length);
    }
}
