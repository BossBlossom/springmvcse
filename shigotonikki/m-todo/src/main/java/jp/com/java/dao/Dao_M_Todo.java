package jp.com.java.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.com.java.entity.M_Todo;

@Repository
public class Dao_M_Todo 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<M_Todo> findAll()
	{
		Session session = sessionFactory.openSession();
		TypedQuery<M_Todo> query = session.createQuery("FROM M_Todo", M_Todo.class);
		List<M_Todo> m_todos = query.getResultList();
		return m_todos;
	}
	
	public M_Todo findByID(int idTodo)
	{
		return sessionFactory.openSession().find(M_Todo.class, idTodo);
	}
	
	public List<M_Todo> findByName (String Name)
	{
		Session session = sessionFactory.openSession();
		TypedQuery<M_Todo> query = session.createQuery("FROM M_Todo WHERE name = Name", M_Todo.class);
		session.createNativeQuery("Name", Name);
		List<M_Todo> m_todos = query.getResultList();
		return m_todos;
	}
	
	public M_Todo findByDate (Date startDate)
	{
		return sessionFactory.openSession().find(M_Todo.class, startDate);
	}
	
	public M_Todo create(M_Todo m_todo) 
	{
		Session session = sessionFactory.openSession();
		session.save(m_todo);
		session.close();
		return m_todo;
	}
	public M_Todo update(M_Todo m_todo) 
	{
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(m_todo);
		tran.commit();
		session.close();
		return m_todo;
	}
	public M_Todo delete(M_Todo m_todo) 
	{
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.delete(m_todo);
		tran.commit();
		session.close();
		return m_todo;
	}
}
