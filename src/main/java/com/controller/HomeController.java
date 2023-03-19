package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Todo;

@Controller
public class HomeController {
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/home")
	public String home(Model m){  //to take anything from controller to view we use model object
		String str="home";
		m.addAttribute("page",str); //we've to fetch data through name in jsp
		
		List<Todo> list=(List<Todo>)context.getAttribute("list");
		m.addAttribute("todos", list);
		return "home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model m) {
		Todo t=new Todo();
		m.addAttribute("page","add");
		m.addAttribute("todo",t);
		return "home";
	}
	
	@RequestMapping(value="/saveTodo", method=RequestMethod.POST)   //by default it take get
	public String saveTodo(@ModelAttribute("todo") Todo t, Model m) {
		System.out.print(t);
		t.setDate(new Date());
		//getting todolist from context
		List<Todo> list=(List<Todo>)context.getAttribute("list");
		list.add(t);
		m.addAttribute("msg", "Successfully added...");
		return "home";
	}

}
