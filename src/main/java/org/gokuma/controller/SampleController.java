package org.gokuma.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gokuma.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

	// @RestController의 문자열 데이터는 기보넞ㄱ으로 브라우저에는 'text/html' 타입으로 처리된다. 
	
	@RequestMapping("/hello")
	public String sayHello() {
		
		return "Hello World";
	}
	
	// 406 에러가 발생하면 jackson-databind 라이브러리 추가
	@RequestMapping("/sendVO")
	public SampleVO sendVO() {
		
		SampleVO vo = new SampleVO();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(123);
		
		return vo;
	}
	
	// 컬렉션 타입의 객체를 반환하는 경우
	// 1. list
	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){
		
		List<SampleVO> list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("gildong");
			vo.setLastName("hong");
			vo.setMno(i);
			list.add(vo);
		}
		return list;
	}	
	
	// 2. map
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap(){
		
		Map<Integer, SampleVO> map = new HashMap<>();
		
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			map.put(i, vo);
		}
		return map;
	}
	
	// ResponseEntity를 이용 사용자에게 정보를 전달하는 예
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot(){
		
		List<SampleVO> list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("gildong");
			vo.setLastName("hong");
			vo.setMno(i);
			list.add(vo);
		}
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}	
}
