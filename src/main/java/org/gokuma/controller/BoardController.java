package org.gokuma.controller;

import java.util.List;

import javax.inject.Inject;

import org.gokuma.domain.BoardVO;
import org.gokuma.domain.Criteria;
import org.gokuma.domain.PageMaker;
import org.gokuma.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		
		logger.info("register Get..................");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public String registerPOST(BoardVO board, Model model) 
	// RedirectAttributes를 이용한 숨김 데이터의 전송
	public String registerPOST(BoardVO board, RedirectAttributes rttr) 
	throws Exception {
		
		logger.info("register POST..................");
		logger.info(board.toString());
		
		service.regist(board);
		
//		model.addAttribute("result", "success");
	 
		// RedirectAttributes를 이용한 숨김 데이터의 전송 addFlashAttributes -> http://localhost:8090/board/listAll
		// model.addAttribute로 전달시 http://localhost:8090/board/listAll?result=success
		rttr.addFlashAttribute("rttr", "success");
		
//		return "/board/success";
		return "redirect:/board/listAll";
	}
	
	// 게시글 리스트
	@RequestMapping(value = "listAll" ,method = RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		
		logger.info("show all list........");
		model.addAttribute("list", service.listAll());
		
	}
	
	// 게시글 페이징
	@RequestMapping(value = "/listCri" ,method = RequestMethod.GET)
	public void listAll(Criteria cri,Model model) throws Exception{
		
		logger.info("show all list Page with criteria........");
		model.addAttribute("list", service.listCriteria(cri));
		
	}
	
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")Criteria cri, Model model) throws Exception {
		
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(131);
		
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	// 게시글 조회하기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model ) throws Exception{
		
		model.addAttribute(service.read(bno));
		
	}
	
	// 게시글 조회하기 전달되는 파라미터 증가, bno, page, perPageNum으로 늘어나서 수정
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
	}
	
	// 삭제 처리
	@RequestMapping(value = "/remove" , method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
	
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listPage";
	}
	
	// 삭제 처리 수정
	@RequestMapping(value = "/removePage" , method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno,Criteria cri, RedirectAttributes rttr) throws Exception {
	
		service.remove(bno);
		
		rttr.addFlashAttribute("page", cri.getPage());
		rttr.addFlashAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listPage";
	}
	
	// 글 수정
	@RequestMapping(value = "/modify" , method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception{
		
		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/modify" , method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		
		logger.info("modify post............");
		
		service.modify(board);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listPage";
	}	
	
//	@RequestMapping(value = "/modifyPage" , method = RequestMethod.GET)
//	public void modifyGET(@RequestParam("bno") int bno,@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
//		
//		logger.info("modify post............");
//		
//		service.modify(board);
//		rttr.addFlashAttribute("msg", "success");
//		
//		return "redirect:/board/listAll";
//		
//		model.addAttribute(service.read(bno));
//	}
	

	@RequestMapping(value = "/modifyPage" , method = RequestMethod.GET)
	public String modifyGET(BoardVO board,Criteria cri, RedirectAttributes rttr) throws Exception{
		
		service.modify(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listPage";
	}
	
	
}
