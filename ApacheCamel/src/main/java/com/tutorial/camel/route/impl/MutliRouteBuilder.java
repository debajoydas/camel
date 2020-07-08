package com.tutorial.camel.route.impl;

import org.apache.camel.builder.RouteBuilder;

public class MutliRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        try {
            from("file:data/input?noop=true")
                    .to("log:?level=INFO&showBody=true&showHeaders=true")
                    .to("file:data/output");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
