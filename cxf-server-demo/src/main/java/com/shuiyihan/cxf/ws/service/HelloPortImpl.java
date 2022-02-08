package com.shuiyihan.cxf.ws.service;

@javax.jws.WebService(serviceName = "HelloService", portName = "HelloPort",
                    targetNamespace = "http://service.ws.sample/",
                    endpointInterface = "sample.ws.service.Hello")
public class HelloPortImpl implements Hello {


    @Override
    public String sayHello(java.lang.String myname) {
        try {
            return "Hello, Welcome to CXF Spring boot " + myname + "!!!";

        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}