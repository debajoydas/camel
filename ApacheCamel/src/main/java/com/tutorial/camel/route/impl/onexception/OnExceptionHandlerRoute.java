package com.tutorial.camel.route.impl.onexception;

import com.tutorial.camel.bean.DataModifier;
import com.tutorial.camel.exception.ApacheCamelApplicationException;
import com.tutorial.camel.processor.ErrorReosponseProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.sql.SQLException;

public class OnExceptionHandlerRoute extends RouteBuilder {

    public void configure() throws Exception {

         //onException(RuntimeException.class).log(LoggingLevel.WARN, "Exception in Bean caught here");
         //onException(ApacheCamelApplicationException.class).log(LoggingLevel.WARN, "Application Exception in Bean caught here");
         //onException(ApacheCamelApplicationException.class).log(LoggingLevel.WARN, "Application Exception in Bean caught here");
         //onException(SQLException.class).log(LoggingLevel.WARN, "Exception while connecting to DB");
         //onException(RuntimeException.class,ApacheCamelApplicationException.class).maximumRedeliveries(2).redeliveryDelay(5000).log(LoggingLevel.WARN, "Exception in Processor caught here");
         onException(RuntimeException.class,ApacheCamelApplicationException.class).handled(true).maximumRedeliveries(2).delay(2000).process(new ErrorReosponseProcessor()).log(LoggingLevel.WARN, "Exception in Processor caught here");
         //onException(RuntimeException.class,ApacheCamelApplicationException.class).handled(true).maximumRedeliveries(2).delay(2000).process(new ErrorReosponseProcessor()).to("kafka:errortopic").log(LoggingLevel.WARN, "Exception in Processor caught here");
         //onException(RuntimeException.class, ApacheCamelApplicationException.class).continued(true).log(LoggingLevel.WARN, "Exception in Processor caught here");
        from("direct:exception")
                .bean(new DataModifier(), "mapOnException")
                .to("log:?level=INFO&showBody=true");
    }
}
