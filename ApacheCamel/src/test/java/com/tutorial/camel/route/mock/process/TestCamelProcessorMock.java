package com.tutorial.camel.route.mock.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class TestCamelProcessorMock extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new TransformInputDataRoute();
    }
    @Test
    public void transformTest(){
        String expected = "Debajoy:21035-Syne-Emp-ID:13-12-2019"+"\n";
        String output = (String) template.requestBody("direct:processorInput","Debajoy,21035-Syne-Emp-ID,13-12-2019" );
        System.out.println("output : "+ output);
        assertEquals(expected,output);
    }

    @Test
    public void transformTestMock() throws InterruptedException {
        String expected = "Debajoy:21035-Syne-Emp-ID:13-12-2019"+"\n";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);
        template.sendBody("direct:processorInput","Debajoy,21035-Syne-Emp-ID,13-12-2019" );
        assertMockEndpointsSatisfied();
    }
}
