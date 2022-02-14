package com.sasac.education.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sasac.vo.BoardFileVO;
import kr.co.sasac.vo.BoardVO;

@Repository 
public class BoardDAO_Mybatis {
	
	@Autowired    
	SqlSession session;
    //SqlSession : SQL문 실행단위 :연결,SQL문실행,결과받기 
	final String namespace = "com.kumchun.board." ;
	
	public List<BoardVO> selectAllBoard(String keyword, String contents) {
		Map<String, String> myMap = new HashMap<>();
		myMap.put("keyword", keyword);
		myMap.put("contents", "%"+contents+"%");
		
		return session.selectList(namespace + "selectAll", myMap); 
	}
	public int selectBoardNo() {
		 return session.selectOne(namespace + "selectBoardNo");
	}
	
 
	public int insertBoard(BoardVO board) {
		 
		return session.insert(namespace+"insertBoard", board);
	}
	
 
	public int viewCnt(int boardNo) {
		 return session.update(namespace+"viewCnt", boardNo);
	}
	
 
	public BoardVO selectBoardByNo(int boardNo) {
		 return session.selectOne(namespace +"selectBoardByNo", boardNo);
	}
	
	
	public int deleteByNo(int boardNo) {
		 return session.delete(namespace+"deleteByNo", boardNo);
	}
	
 
	public int updateBoard(BoardVO board) {
		 return session.update(namespace+"updateBoard", board);
	}
 
	public int boardCnt() {
		 return session.selectOne(namespace+"boardCnt");
	}
	
 
	public int insertFile(BoardFileVO fileVO) {
		 
		return session.insert(namespace+"insertFile", fileVO);
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo) {
		 return session.selectList(namespace+"selectFileByNo", boardNo);
	}
}
