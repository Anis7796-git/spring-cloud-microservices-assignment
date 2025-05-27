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
