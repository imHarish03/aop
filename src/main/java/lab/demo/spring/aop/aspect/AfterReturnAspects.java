package lab.demo.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lab.demo.spring.aop.model.Account;

@Component
@Order
@Aspect
public class AfterReturnAspects {

	@AfterReturning(pointcut = "execution(* lab.demo.spring.aop.dao.AccountDAO.getAccounts(..))", returning = "result")
	public void afterReturningFindAccountsDevice(JoinPoint jointpoint, List<Account> result) {
		System.out.println("Method Name: " + jointpoint.getSignature());

		System.out.println("After Execution: " + result);
	}

}
