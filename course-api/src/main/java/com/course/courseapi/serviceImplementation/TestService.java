package com.course.courseapi.serviceImplementation;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class TestService {

	@Async
	public void m1() {
		System.out.println("m1");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("m1 end");
	}
	
	@Async
	public void m2() {
		System.out.println("m2");

	}

}
