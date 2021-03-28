package org.gokuma.web;

import org.gokuma.domain.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 만들어진 결과 데이터를 전달해야 하는 경우

@Controller
public class SampleController3 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	@RequestMapping("doD")
	public String doD(Model model) {
		
		//make sample data
		ProductVO product = new ProductVO("Sample Product", 10000);
		
		logger.info("doD called ........");
		
		model.addAttribute(product);
		
		return "productDetail";
	}
}
