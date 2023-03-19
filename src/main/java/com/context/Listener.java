package com.context;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.entity.Todo;

public class Listener implements ServletContextListener{ //it will listen to servlet context object wen our project deploy

	//servlet context object is only one for whole app it will generate when web container deploy project 
	
	//these two method will automatically run wen our project deploy
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context created....");
		List<Todo> list=new ArrayList<Todo>();
		ServletContext context= sce.getServletContext();
		context.setAttribute("list",list);
		
	}  
	
	
}
