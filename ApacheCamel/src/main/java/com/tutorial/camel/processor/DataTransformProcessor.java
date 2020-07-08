package com.tutorial.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DataTransformProcessor implements Processor {
    String newValue = "";

    public void process(Exchange exchange) throws Exception {
        String oldValue = null;
        if(exchange.getIn().getBody() instanceof String){
            oldValue = (String) exchange.getIn().getBody();
            System.out.println("Old Value is : " + oldValue);
            newValue = newValue.concat(oldValue.replace(",", ":")).concat("\n");
            System.out.println("New Value is :  " + newValue);
            exchange.getIn().setBody(newValue);
        }else{
            GenericFile<File> file = (GenericFile) exchange.getIn().getBody();
            String readLine = null;
            if (file != null) {
                try{
                    FileReader file1 = new FileReader(file.getFile());
                    BufferedReader reader = new BufferedReader(file1);
                    while ((readLine = reader.readLine()) != null) {
                        System.out.println("Read line is : " + readLine);
                        oldValue = readLine;
                        System.out.println("Old Value is : " + oldValue);
                        newValue = newValue.concat(oldValue.replace(",", ":")).concat("\n");
                        System.out.println("New Value is :  " + newValue);
                        exchange.getIn().setBody(newValue);
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
