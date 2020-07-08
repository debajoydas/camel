package com.tutorial.camel.route.mock;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class TestCamelSingleRouteMock extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new SingleRouteBuilder();
    }

    @Test
    public void checkOutpoutDirectoryMock() throws InterruptedException {

        String expectedMessage = "Welcome to Camel";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedMessage);
        template.sendBody("direct:sampleInput","Welcome to Camel");
        Thread.sleep(5000);
        assertMockEndpointsSatisfied();
    }
}
