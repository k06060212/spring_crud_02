package org.gokuma.service;

import java.util.List;

import org.gokuma.domain.BoardVO;
import org.gokuma.domain.Criteria;
import org.gokuma.domain.SearchCriteria;

public interface BoardService {
	
	// create
	public void regist(BoardVO board) throws Exception;
	
	// read 
	public BoardVO read(Integer bno) throws Exception;
	
	// update
	public void modify(BoardVO board) throws Exception;
	
	// delete
	public void remove(Integer bno) throws Exception;
	
	// listAll
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
}
