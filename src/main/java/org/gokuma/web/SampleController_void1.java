package org.gokuma.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController_void1 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController_void1.class);
	
	@RequestMapping("doA")
	public void doA() {
		
		logger.info("doA called......");
		
	}
	
	@RequestMapping("doB")
	public void doB() {
		
		logger.info("doB called......");
		
	}
	
}
