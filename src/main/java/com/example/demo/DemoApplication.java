package com.example.demo;

import com.example.demo.structures.TestDepInjComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	static ApplicationContext context;
	public static void main(String[] args) {
		context = SpringApplication.run(DemoApplication.class, args);
		TestDepInjComponent dpi = context.getBean(TestDepInjComponent.class);
		System.out.println(dpi.getContainer());
		dpi.setContainer("Poka");
		System.out.println(dpi.getContainer());
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//		};
//	}


}
