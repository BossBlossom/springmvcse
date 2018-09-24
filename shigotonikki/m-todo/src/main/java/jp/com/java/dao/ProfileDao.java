package jp.com.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.com.java.entity.Profile;

@Repository
public class ProfileDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Profile create(Profile profile)
	{
		Session session = sessionFactory.openSession();
		session.save(profile);
		session.close();
		return profile;
	}
}
