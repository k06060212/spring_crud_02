package org.gokuma.web;

import org.gokuma.domain.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController_JSON5 {
	
	@RequestMapping("doJSON")
	public @ResponseBody ProductVO doJSON() {
		
		ProductVO vo = new ProductVO("샘플상품", 3000000);
		
		return vo;
	}
}
