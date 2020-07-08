package com.tutorial.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelRouteProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchange in Processor is : "+exchange.getIn().getBody());
    }
}
