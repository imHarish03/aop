package lab.demo.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 3)
public class UserAspects {

	@Before("lab.demo.spring.aop.aspect.MyDemoLoggingAspects.forDAOPackage()")
	public void userLogging() {
		System.out.println("========>> @Before advice on addAccount is called, Order-3");
	}
}
