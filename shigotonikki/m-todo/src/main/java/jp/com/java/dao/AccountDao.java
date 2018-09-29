package jp.com.java.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.com.java.entity.Account;

@Repository
public class AccountDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Account find(String username) {
		return sessionFactory.openSession().find(Account.class, username);
	}
}
