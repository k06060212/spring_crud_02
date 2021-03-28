package org.gokuma.web;

import java.util.List;

import javax.inject.Inject;

import org.gokuma.domain.BoardVO;
import org.gokuma.domain.Criteria;
import org.gokuma.domain.SearchCriteria;
import org.gokuma.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Inject
	private BoardDAO dao;
	
//	@Test
//	public void testCreate() throws Exception{
//		
//		BoardVO board = new BoardVO();
//		board.setTitle("제목을 넣습니다.");
//		board.setContent("내용");
//		board.setWriter("작성자");
//		
//		dao.create(board);
//	}
//	
//	@Test
//	public void testRead() throws Exception{
//		
//		logger.info(dao.read(10).toString());
//		
//	}
//	
//	@Test
//	public void testUpdate() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setBno(1);
//		board.setTitle("수정된 글");
//		board.setContent("수정 내용");
//		dao.update(board);
//	}
//	
//	@Test
//	public void testDelete() throws Exception{
//		dao.delete(2);	
//	}
//	
//	@Test
//	public void testListPage() throws Exception{
//		
//		int page = 3;
//		
//		List<BoardVO> list = dao.listPage(page);
//		
//		for(BoardVO boardVO : list) {
//			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
//		}
//	}
//	
//	@Test
//	public void testListCriteria() throws Exception {
//		
//		Criteria cri = new Criteria();
//		cri.setPage(2);
//		cri.setPerPageNum(20);
//		
//		List<BoardVO> list = dao.listCriteria(cri);
//		
//		for(BoardVO boardVO : list) {
//			
//			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
//		}
//		
//	}
//	
//	@Test
//	public void testURI() throws Exception{
//		//UriComponents 클래스는 path나 query에 해당하는 문자열들을 추가해서 원하는 uri를 생성할 때 사용한다.
//		UriComponents uriComponents = UriComponentsBuilder.newInstance()
////														   .path("/board/read")
//														   .path("/{module}/{page}")
//														   .queryParam("bno", 12)
//														   .queryParam("perPageNum", 20)
//														   .build()
//														   .expand("board", "read")
//														   .encode();		
//		logger.info("/board/read?bno=12&perPageNum=20");
//		logger.info(uriComponents.toString());
//		
//	}
	
	@Test
	public void testDynamic1() throws Exception{
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("글");
		cri.setSearchType("t");
		
		logger.info("============================");
		
		List<BoardVO> list = dao.listSearch(cri);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
		logger.info("============================");
		
		logger.info("COUNT :" + dao.listSearchCount(cri));
	}
}
