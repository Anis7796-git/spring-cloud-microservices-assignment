package com.anhee.ms;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/wish-api")
public class WishMessageMsService {

	@GetMapping("/message")
	public ResponseEntity<String> showWishMessaage(){
		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		String msg= null;
		if(hour<12) {
			msg="Good mornning";
		}else if(hour<16) {
			msg= "Good afternoon";
		}else if(hour<20) {
			msg= "Good evening";
		}else {
			msg= "Good night";
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
