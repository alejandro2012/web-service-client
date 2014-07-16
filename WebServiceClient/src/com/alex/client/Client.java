package com.alex.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.alex.endpointimplementation.AddServiceServiceName;
import com.alex.endpointimplementation.ServiceInterface01;

public class Client {
	
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:3030/add?wsdl");
		QName qname =new QName("http://endPointImplementation.alex.com/","addService_serviceName");
		Service service = Service.create(url, qname);
		ServiceInterface01 i = service.getPort(ServiceInterface01.class);		
		System.out.println(i.makeAdd(1, 3));
		System.out.println(i.makeSubstract(1, 1));
		
		AddServiceServiceName service02 = new AddServiceServiceName();
		ServiceInterface01 calc_service = service02.getAddServicePortName();
		System.out.println( calc_service.makeAdd(1, 3) );
		System.out.println( calc_service.makeSubstract(10, 1) );
		
	}

}
