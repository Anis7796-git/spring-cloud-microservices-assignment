package com.anhee.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anhee.client.IBillingMsClientComp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/shopping-api")
public class ShoppingOperationMs {

	@Autowired
	private IBillingMsClientComp client;
	
	@GetMapping("/purchase")
	@CircuitBreaker(name="ShopingMS",fallbackMethod ="doBillingFallback" )
	public ResponseEntity<String> doShopping(){
		
		System.out.println("Client comp proxy class name::"+client.getClass());
		String msg="shirt, trousesr items are purchased";
		
		//invoke target ms endpoint through client comp
		
		ResponseEntity<String> resp=client.invokeDoBilling();
		System.out.println("ShoppingOperationMs.doShopping()****==>  "+resp+"<==***");
		String result=msg+"..."+resp.getBody();
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	public ResponseEntity<String> doBillingFallback(Exception e){
		System.out.println("ShoppingOperationMs.doBillingFallback()");
		return new ResponseEntity<String>("problem in Billing service",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
//
//
//
//
//
//--
//BillingMsClientComp.invokeDoBilling() url ****==>  http://LAPTOP-2SP9MUJP:6061   <==***
//BillingMsClientComp.invokeDoBilling() urlInfo ****==>  http://localhost:6061/billing-api/bill   <==***
//BillingMsClientComp.invokeDoBilling() response ****==>  <200 OK OK,Bill Amount::36552,[Content-Type:"text/plain;charset=UTF-8", Content-Length:"18", Date:"Mon, 19 May 2025 10:06:26 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]>   <==***
//ShoppingOperationMs.doShopping()****==>  <200 OK OK,Bill Amount::36552,[Content-Type:"text/plain;charset=UTF-8", Content-Length:"18", Date:"Mon, 19 May 2025 10:06:26 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]><==***
//BillingMsClientComp.invokeDoBilling() url ****==>  http://LAPTOP-2SP9MUJP:6061   <==***
//BillingMsClientComp.invokeDoBilling() urlInfo ****==>  http://LAPTOP-2SP9MUJP:6061/billing-api/bill   <==***
//BillingMsClientComp.invokeDoBilling() response ****==>  <200 OK OK,Bill Amount::70256,[Content-Type:"text/plain;charset=UTF-8", Content-Length:"18", Date:"Mon, 19 May 2025 10:06:50 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]>   <==***
//ShoppingOperationMs.doShopping()****==>  <200 OK OK,Bill Amount::70256,[Content-Type:"text/plain;charset=UTF-8", Content-Length:"18", Date:"Mon, 19 May 2025 10:06:50 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]><==***
//2025-05-19T15:40:41.580+05:30  INFO 9924 --- [ShopingMS] [rap-executor-%d] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
//BillingMsClientComp.invokeDoBilling() url ****==>  http://LAPTOP-2SP9MUJP:6061   <==***
//BillingMsClientComp.invokeDoBilling() urlInfo ****==>  http://LAPTOP-2SP9MUJP:6061/billing-api/bill   <==***
//BillingMsClientComp.invokeDoBilling() response ****==>  <200 OK OK,Bill Amount::37264,[Content-Type:"text/plain;charset=UTF-8", Content-Length:"18", Date:"Mon, 19 May 2025 10:38:28 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]>   <==***
//ShoppingOperationMs.doShopping()****==>  <200 OK OK,Bill Amount::37264,[Content-Type:"text/plain;charset=UTF-8", Content-Length:"18", Date:"Mon, 19 May 2025 10:38:28 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]><==***
