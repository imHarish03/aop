package lab.demo.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspects {

	//Match on Method names
	//@Before("execution (public void lab.demo.spring.aop.aspect.MyDemoLoggingAspects.addAccount())")
	
	//Match on Method names(using wild card)
	//@Before("execution (public void add*())")
	
	//Use wildcard on modifiers & return types
	//@Before("execution (* * add*())")
	
	//Modifier is optional
	//@Before("execution (* add*())")
	
	@Before("execution (public void addAccount())")
	public void userLogging() {
		System.out.println("\n========>> @Before advice on addAccount is called");
	}
}
