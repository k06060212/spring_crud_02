package org.gokuma.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController_redirect4 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController_redirect4.class);
	
	@RequestMapping("doE")
	public String doE(RedirectAttributes rattr) {
			
		logger.info("doE called........");
		
		rattr.addFlashAttribute("msg", "This is the Message!! with redirected");
		
		return "redirect:/doF";
	}
	
	@RequestMapping("doF")
	public void doF(@ModelAttribute String msg) {
		
		logger.info("doF called.........."+msg);
	}
	
}
