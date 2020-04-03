package com.form;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class viewController{
	    
        @RequestMapping("/add")
		public ModelAndView add(HttpServletRequest req, HttpServletResponse res)
		{
        	String fname= req.getParameter("fn");
    	    String adr  = req.getParameter("adrs");
    	    String age = req.getParameter("n");
    	    String lname= req.getParameter("ln");
     		
    		ModelAndView mv = new ModelAndView();
    		mv.setViewName("display.jsp");
    		mv.addObject("a",fname);
    		mv.addObject("c",adr);
    		mv.addObject("d",age);
    		mv.addObject("b",lname);
    	
    
    		return mv;
        	
		}
	}
			