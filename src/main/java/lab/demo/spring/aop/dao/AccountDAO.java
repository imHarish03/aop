package lab.demo.spring.aop.dao;

import org.springframework.stereotype.Component;

import lab.demo.spring.aop.model.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account) {
		System.out.println(getClass() + ", Adding Account " + account.getId());
	}

}
