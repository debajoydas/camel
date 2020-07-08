package com.tutorial.camel.route.mock;

import org.apache.camel.builder.RouteBuilder;

public class SingleRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:output");
    }
}
