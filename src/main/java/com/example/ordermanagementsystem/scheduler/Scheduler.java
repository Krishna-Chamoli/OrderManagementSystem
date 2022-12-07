package com.example.ordermanagementsystem.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.ordermanagementsystem.service.CustomerService;

@Component
public class Scheduler {

	@Autowired
	CustomerService customerService;

	@Scheduled(fixedRate = 3000)
	public void scheduleEmail() {

		List<String> customerNameList = customerService.getCustomersNameToNotify();
		for (String customerName : customerNameList) {
			System.out.println("Email sent to: " + customerName);
		}
	}
}
