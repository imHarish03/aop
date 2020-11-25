package lab.demo.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lab.demo.spring.aop.model.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account) {
		System.out.println(getClass() + ", Adding Account " + account.getId());
	}

	public List<Account> getAccounts() {

		if (true)
			throw new RuntimeException();

		List<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account(1, "Hari"));
		accountList.add(new Account(2, "Saurabh"));
		accountList.add(new Account(3, "Daniel"));
		accountList.add(new Account(4, "Raghu"));

		return accountList;
	}

}
