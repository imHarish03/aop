package lab.demo.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lab.demo.spring.aop.dao.AccountDAO;

public class SpringBootAopApplication {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		accountDAO.addAccount();
		
		System.out.println("\n Calling again");
		accountDAO.addAccount();
		
		context.close();

	}
}
