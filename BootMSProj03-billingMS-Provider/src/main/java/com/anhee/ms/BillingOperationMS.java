package com.anhee.ms;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.GET;

@RestController
@RequestMapping("/billing-api")
public class BillingOperationMS {
		@GetMapping("/bill")
		public ResponseEntity<String> doBillinh(){
			System.out.println("BillingOperationMS.doBillinh() method invoke =============================================================================================================================");
			 System.out.println("BillingOperationMS.doBillinh() method invoke =============================================================================================================================");
			System.out.println("BillingOperationMS.doBillinh() method invoke =============================================================================================================================");
			System.out.println("BillingOperationMS.doBillinh() method invoke =============================================================================================================================");
			//generate bill amount
			long billamt= new Random().nextLong(100000);
			return new ResponseEntity<String>("Bill Amount::"+billamt,HttpStatus.OK);
		
		}
}
