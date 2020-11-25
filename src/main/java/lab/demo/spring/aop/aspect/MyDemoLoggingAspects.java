package lab.demo.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lab.demo.spring.aop.model.Account;

@Aspect
@Component
@Order(value = 2)
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
	public void forDAOPackage() {
	}

	@Pointcut("execution(* set*())")
	private void forSetters() {
	}

	@Pointcut("execution(* get*())")
	private void forGetters() {
	}

	@Pointcut("forDAOPackage() && !(forSetters() || forGetters() ) ")
	public void combinational() {

	}

	@Before("combinational()")
	public void auditLog(JoinPoint joinPoint) {
		System.out.println("========>> AuditLog- Order 2");
		System.out.println(joinPoint.getSignature());

		for (Object temp : joinPoint.getArgs()) {
			if (temp instanceof Account) {
				System.out.println("Account Holder Name " + temp.toString());
			}
		}
	}

	@AfterThrowing(pointcut = "execution( *  *(..))", throwing = "theExcep")
	public void afterThrowingExceptions(JoinPoint joinPoint, Throwable theExcep) {

		System.out.println("Capture exceptiosm via Aspect");
		System.out.println(joinPoint.getSignature());
		System.out.println(theExcep);

	}

}
