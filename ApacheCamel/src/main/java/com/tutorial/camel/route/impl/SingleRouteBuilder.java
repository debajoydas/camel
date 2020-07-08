package com.tutorial.camel.route.impl;

import org.apache.camel.builder.RouteBuilder;

public class SingleRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("file:data/input2?noop=true")
                .log("read file ${body} along with headers ${headers}")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .to("file:data/output2");
    }
}
