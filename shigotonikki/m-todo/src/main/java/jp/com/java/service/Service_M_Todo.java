package jp.com.java.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.com.java.dao.Dao_M_Todo;
import jp.com.java.entity.M_Todo;

@Service
public class Service_M_Todo 
{
	@Autowired
	private Dao_M_Todo daoM_Todo;
	
	public List<M_Todo> search(String Name)
	{
		if(Name == null || Name.length() == 0)
		{
			return daoM_Todo.findAll();
		}
		return daoM_Todo.findByName(Name);
	}
	
	@Transactional(value=TxType.REQUIRED)
	public M_Todo createM_Todo(M_Todo m_todo)
	{
		M_Todo result = daoM_Todo.create(m_todo);
		return result;
	}
	
	@Transactional
	public M_Todo updateM_Todo(M_Todo m_todo)
	{
		M_Todo result = daoM_Todo.update(m_todo);
		return result;
	}
	
	@Transactional
	public M_Todo deleteM_Todo(M_Todo m_todo)
	{
		M_Todo result = daoM_Todo.delete(m_todo);
		return result;
	}
	
	public M_Todo m_todoFindById(int idTodo)
	{
		return daoM_Todo.findByID(idTodo);
	}
	
	public M_Todo m_todoFindByDate(Date startDate)
	{
		return daoM_Todo.findByDate(startDate);
	}
}
