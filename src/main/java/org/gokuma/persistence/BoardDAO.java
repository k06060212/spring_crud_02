package org.gokuma.persistence;

import java.util.List;

import org.gokuma.domain.BoardVO;
import org.gokuma.domain.Criteria;
import org.gokuma.domain.SearchCriteria;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
//	페이징
	public List<BoardVO> listPage(int page) throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
// 동적 SQL문을 적용하기 위한 메소드를 설정 SearchCriteria가 적용되는 메소드 2개
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
}
