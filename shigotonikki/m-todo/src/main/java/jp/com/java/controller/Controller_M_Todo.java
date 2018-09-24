package jp.com.java.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.com.java.entity.M_Todo;
import jp.com.java.model.ModelDate;
import jp.com.java.service.Service_M_Todo;

@Controller
@RequestMapping("/home")
public class Controller_M_Todo
{
	@Autowired
	private Service_M_Todo serviceM_Todo;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model)
	{
		List<M_Todo> m_todos = serviceM_Todo.search(null);
		model.addAttribute("todos", m_todos);
		return "home";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model)
	{
		ModelDate date = new ModelDate();
		model.addAttribute("m_todo", date);
		model.addAttribute("mode", "create");
		return "detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(@ModelAttribute("todos") ModelDate date, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "detail";
		}
		M_Todo m_todo = date.toM_Todo();
		serviceM_Todo.createM_Todo(m_todo);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String start(@RequestParam(name="idTodo") int idTodo, Model model)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		LocalDateTime now = LocalDateTime.now().withHour(12).withMinute(00);
		String time = dtf.format(now);
		
		M_Todo m_todo = serviceM_Todo.m_todoFindById(idTodo);
		
		m_todo.setStartAT(time);
		m_todo.setStatus("In-Progress");
		serviceM_Todo.updateM_Todo(m_todo);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/end", method = RequestMethod.GET)
	public String end(@RequestParam(name="idTodo") int idTodo, Model model)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		LocalDateTime now = LocalDateTime.now().withHour(12).withMinute(00);
		String time = dtf.format(now);
		
		M_Todo m_todo = serviceM_Todo.m_todoFindById(idTodo);
		
		m_todo.setEndAT(time);
		m_todo.setStatus("Done");
		serviceM_Todo.updateM_Todo(m_todo);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(name="idTodo") int idTodo, Model model)
	{
		serviceM_Todo.deleteM_Todo(serviceM_Todo.m_todoFindById(idTodo));
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(@RequestParam(name="idTodo") int idTodo, Model model)
	{
		M_Todo m_todo = serviceM_Todo.m_todoFindById(idTodo);
		
		m_todo.setStatus("Canceled");
		serviceM_Todo.updateM_Todo(m_todo);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(@RequestParam(name="idTodo") int idTodo, Model model)
	{
		M_Todo m_todo = serviceM_Todo.m_todoFindById(idTodo);
		
		ModelDate date = new ModelDate();
		date.fromM_Todo(m_todo);
		model.addAttribute("m_todo", date);
		model.addAttribute("mode", "view");
		
		return "view";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam(name="idTodo") int idTodo, Model model)
	{
		
		M_Todo m_todo = serviceM_Todo.m_todoFindById(idTodo);
		
		if(m_todo == null)
			return "redirect:/home";
		
		ModelDate date = new ModelDate();
		date.fromM_Todo(m_todo);
		model.addAttribute("m_todo", date);
		model.addAttribute("mode", "update");
		
		return "detail";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String handleUpdate(@RequestParam(name="idTodo") int idTodo, @ModelAttribute("todos") ModelDate date, BindingResult result, Model model)
	{
		if(result.hasErrors())
			return "detail";
		
		M_Todo m_todo = date.toM_Todo();
		serviceM_Todo.updateM_Todo(m_todo);
		
		return "redirect:/home";
	}
}
