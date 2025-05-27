package com.anhee.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/billing-api")
public class BillingOperationMS {
	
	
	
	public BillingOperationMS() {
 		System.out.println("BillingOperationMS.BillingOperationMS() 0-param-constructor ");
	}


	@Value("${spring.application.instance-id}")
	private String instanceId;
	
	
	
		
		@GetMapping("/bill")
		public ResponseEntity<String> doBillinh(){
		
			long billamt= new Random().nextLong(100000);
			
			return new ResponseEntity<String>("Bill Amount::"+billamt+"instanceId ::"+instanceId+"portNo ::"+"  :: username "+" db password :",HttpStatus.OK);
		
		}
}
