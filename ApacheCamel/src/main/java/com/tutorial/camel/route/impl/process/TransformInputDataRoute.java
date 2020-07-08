package com.tutorial.camel.route.impl.process;

import com.tutorial.camel.processor.DataTransformProcessor;
import org.apache.camel.builder.RouteBuilder;

public class TransformInputDataRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("file:data/input3?noop=true")
                .process(new DataTransformProcessor())
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("file:data/output3?fileName=outputTransform.txt");
    }
}
