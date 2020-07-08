package com.tutorial.camel.route.mock.process;

import com.tutorial.camel.processor.DataTransformProcessor;
import org.apache.camel.builder.RouteBuilder;

public class TransformInputDataRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:processorInput")
                .process(new DataTransformProcessor())
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:output");
    }
}
