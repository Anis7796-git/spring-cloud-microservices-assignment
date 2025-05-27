package com.anhee.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Scheduled(cron = "0/10 * * * * *")
	public void showReport() {
		System.out.println("ReportService.showReport()"+new Date());
		
	}
}
