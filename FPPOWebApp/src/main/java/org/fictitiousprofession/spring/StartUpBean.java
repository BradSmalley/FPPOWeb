package org.fictitiousprofession.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StartUpBean {
	
	@Autowired private ApplicationContext context;
	
	@PostConstruct
	public void postConstruct() {
		
		System.out.println("postConstruct()");

//		for (String s : context.getBeanDefinitionNames()) {
//			System.err.println(s);
//		}	
	}
	
	@PreDestroy
	public void preDestroy() {
		
		System.out.println("preDestroy()");
		
	}

}
