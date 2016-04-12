package com.jiao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jiao.service.TestService;

@Controller
public class COntroller1 {
	@Autowired
	private TestService atestservice;
	
	@RequestMapping(value="test.action")
	public String conmethod1(HttpServletRequest req){
		System.out.println(req.getParameter("text"));
		return "wjs";
	}
	@RequestMapping(value="test1.action")
	public String me1(){
		String aa=atestservice.hello();
		System.out.println(aa+"from controller");
		return "hello";
		
	}
	@RequestMapping(value="mav.action")
	public ModelAndView getmav(){
		System.out.println("this is from controller-getmav");
		String jiaozhijun="name is jiaozhijun";
		ModelAndView modelandview= new ModelAndView("student","name",jiaozhijun);
		return modelandview;
	}
	
	
}
