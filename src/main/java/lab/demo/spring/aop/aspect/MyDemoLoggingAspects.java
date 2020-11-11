package lab.demo.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspects {

	// Match on Method names
	// @Before("execution (public void
	// lab.demo.spring.aop.aspect.MyDemoLoggingAspects.addAccount())")

	// Match on Method names(using wild card)
	// @Before("execution (public void add*())")

	// Use wildcard on modifiers & return types
	// @Before("execution (* * add*())")

	// Modifier is optional
	// @Before("execution (* add*())")

	@Pointcut("execution(* add*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("execution(* set*())")
	private void forSetters() {
	}

	@Pointcut("execution(* get*())")
	private void forGetters() {
	}

	@Pointcut("forDAOPackage() && !(forSetters() || forGetters() ) ")
	private void combinational() {

	}

	@Before("combinational()")
	public void auditLog() {
		System.out.println("\n========>> AuditLog");
	}

	@Before("forDAOPackage()")
	public void userLogging() {
		System.out.println("\n========>> @Before advice on addAccount is called");
	}

	@Before("forDAOPackage()")
	public void performAPITesting() {
		System.out.println("\n========>> Performing API Analytics");
	}
}
