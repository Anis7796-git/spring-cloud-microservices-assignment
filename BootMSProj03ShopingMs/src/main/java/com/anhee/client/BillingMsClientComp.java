package com.anhee.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate; 


@Component
public class BillingMsClientComp {
	
	@Autowired
	private DiscoveryClient client;
	
	
	
	public ResponseEntity<String> invokeDoBilling(){
		
		// get target ms service instance from the eureka server
		
		List<ServiceInstance> listSi = client.getInstances("BillingMS");
		
		URI url = listSi.get(0).getUri();// 
		System.out.println("BillingMsClientComp.invokeDoBilling() url ****==>  "+url+"   <==***");
		///BillingMsClientComp.invokeDoBilling() url ****==>  http://LAPTOP-2SP9MUJP:6061   <==***
		
		
		
		
		
		
		
		String urlInfo=url+"/billing-api/bill";
		//create RestTemplate class obj
		
		RestTemplate template= new RestTemplate();
		
		//invoke the target ms endpoint
		System.out.println("BillingMsClientComp.invokeDoBilling() 2");
		ResponseEntity<String> resp= template.exchange(urlInfo,HttpMethod.GET,null,String.class);
		System.out.println("BillingMsClientComp.invokeDoBilling() 3");
		System.out.println("BillingMsClientComp.invokeDoBilling() response ****==>  "+resp+"   <==***");
	//	response ****==>  <200 OK OK,Bill Amount::36552,[Content-Type:"text/plain;charset=UTF-8", Content-Length:"18", Date:"Mon, 19 May 2025 10:06:26 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]>
		return resp;
	}

}
