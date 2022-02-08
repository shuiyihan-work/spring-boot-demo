package com.shuiyihan.cxf.ws;

import org.apache.cxf.staxutils.StaxUtils;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.io.StringReader;
import java.net.URL;

public class SampleWsApplicationClient {

    public static void main(String[] args) throws Exception {
        String address = "http://localhost:8080/Service/Hello";
        String request = "<q0:sayHello xmlns:q0=\"http://service.ws.sample/\"><myname>Elan</myname></q0:sayHello>";

        StreamSource source = new StreamSource(new StringReader(request));
        Service service = Service.create(new URL(address + "?wsdl"),
                                         new QName("http://service.ws.sample/" , "HelloService"));
        Dispatch<Source> disp = service.createDispatch(new QName("http://service.ws.sample/" , "HelloPort"),
                                                       Source.class, Service.Mode.PAYLOAD);
        
        Source result = disp.invoke(source);
        String resultAsString = StaxUtils.toString(result);
        System.out.println(resultAsString);
       
    }
}