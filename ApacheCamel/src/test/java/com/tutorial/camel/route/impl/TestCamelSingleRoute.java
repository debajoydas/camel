package com.tutorial.camel.route.impl;

import com.tutorial.camel.route.impl.SingleRouteBuilder;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class TestCamelSingleRoute extends CamelTestSupport {

    protected RoutesBuilder createRouteBuilder() throws Exception {
            return new SingleRouteBuilder();
    }

    @Test
    public void checkOutpoutDirectory() throws InterruptedException {
        Thread.sleep(5000);
        File file = new File("data/output2");
        assertTrue(file.isDirectory());
    }

    @Test
    public void checkFilesCountInOutputDirectory() throws InterruptedException {
        Thread.sleep(5000);
        File file = new File("data/output2");
        assertTrue(file.isDirectory());
        System.out.println("Total no of files in the output directory : " + file.listFiles().length);
        assertEquals(1, file.listFiles().length);
    }


}
