package jp.com.java.model;


import jp.com.java.entity.M_Todo;

public class ModelDate 
{
	private int idTodo;
	
	private String name;
	
	private String status;
	
	private String description;
	
	private String startDate;
	
	private String startAT;
	
	private String endAT;
	
	public M_Todo toM_Todo()
	{
		M_Todo m_todo = new M_Todo();
		m_todo.setIdTodo(this.idTodo);
		m_todo.setName(this.name);
		if(this.startAT==null)
		{
			m_todo.setStatus("New");
		}
		m_todo.setDescription(this.description);
		m_todo.setStartDate(this.startDate);
		return m_todo;
	}
	
	public void fromM_Todo(M_Todo m_todo)
	{
		this.setIdTodo(m_todo.getIdTodo());
		this.setName(m_todo.getName());
		this.setStatus(m_todo.getStatus());
		this.setDescription(m_todo.getDescription());
		this.setStartDate(m_todo.getStartDate());
		this.setStartAT(m_todo.getStartAT());
		this.setEndAT(m_todo.getEndAT());
	}

	public int getIdTodo() {
		return idTodo;
	}

	public void setIdTodo(int idTodo) {
		this.idTodo = idTodo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartAT() {
		return startAT;
	}

	public void setStartAT(String startAT) {
		this.startAT = startAT;
	}

	public String getEndAT() {
		return endAT;
	}

	public void setEndAT(String endAT) {
		this.endAT = endAT;
	}
	
}
