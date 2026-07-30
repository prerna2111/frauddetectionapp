package com.Finance.FraudDetection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FraudDetectionApplication {

	public static void main(String[] args) {

        ApplicationContext context= SpringApplication.run(FraudDetectionApplication.class, args);
//        System.out.println("=======Spring beans in Application Context=======");
//        String[] beanNames = context.getBeanDefinitionNames();
//        for(String beanName : beanNames){
//            System.out.println(beanName);
//        }
//        System.out.println("Total beans: " + beanNames.length);


	}

}
