package com.kh.spring.board.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int selectListCount() {
		int count = boardDao.selectListCount(sqlSession);
		return count;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		return boardDao.selectList(sqlSession, pi);
	}

	@Override
	public int increaseCount(int bno) {
		return boardDao.increaseCount(sqlSession, bno);
	}

	@Override
	public Board selectBoard(int bno) {
		return boardDao.selectBoard(sqlSession, bno);
	}

	@Override
	public ArrayList<Reply> selectReply(int bno) {
		return boardDao.selectReply(sqlSession, bno);
	}

	@Override
	public int insertBoard(Board b) {
		return boardDao.insertBoard(sqlSession, b);
	}

	@Override
	public int updateBoard(Board b) {
		return boardDao.updateBoard(sqlSession, b);
	}

	@Override
	public int insertReply(Reply r) {
		return boardDao.insertReply(sqlSession, r);
	}

	@Override
	public ArrayList<Board> selectTopBoardList() {
		return boardDao.selectTopBoardList(sqlSession);
	}
	
	
	
}
