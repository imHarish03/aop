package lab.demo.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value = 1)
public class APIAspects {

	@Before("lab.demo.spring.aop.aspect.MyDemoLoggingAspects.forDAOPackage()")
	private void performAPITesting() {
		System.out.println("========>> Performing API Analytics - Order-1");
	}

}
