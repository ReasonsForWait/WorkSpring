package com.example.di;

import com.example.di.service.IMemberService;
import com.example.di.service.IMemberServiceImpl;
import com.example.di.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DiApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext cac = SpringApplication.run(DiApplication.class, args);

		// #1
		MemberService service = cac.getBean("service1", MemberService.class);
		service.saveMemver();

		// #2
		IMemberService service2 = cac.getBean("service2", IMemberService.class);
		service2.saveMember();
		IMemberService service3 = cac.getBean("service2", IMemberService.class);
		service3.saveMember();

		service2.plusNum();
		service3.plusNum();

		System.out.println(service2.getNum());
		System.out.println(service3.getNum());
	}

}
