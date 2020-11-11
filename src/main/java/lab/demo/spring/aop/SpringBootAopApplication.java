package lab.demo.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lab.demo.spring.aop.dao.AccountDAO;
import lab.demo.spring.aop.model.Account;

public class SpringBootAopApplication {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		Account account = new Account();
		account.setId(1);
		account.setName("Test");

		accountDAO.addAccount(account);

		System.out.println("\n Calling again");
		
		Account account2 = new Account();
		account2.setId(2);
		account2.setName("inter");

		accountDAO.addAccount(account2);

		context.close();

	}
}
