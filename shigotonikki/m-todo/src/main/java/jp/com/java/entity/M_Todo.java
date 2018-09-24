package jp.com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("todos"))
public class M_Todo 
{
	@Id
	@GeneratedValue
	@Column(name="ID_TODO")
	private int idTodo;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name="START_AT")
	private String startAT;
	
	@Column(name="END_AT")
	private String endAT;

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
