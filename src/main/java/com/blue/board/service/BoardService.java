package com.blue.board.service;

import com.blue.board.common.ResultUtil;
import com.blue.board.vo.BoardVO;

public interface BoardService {
	
	//public List<BoardVO> getBoardList(BoardVO boardVO) throws Exception;
	public ResultUtil getBoardList(BoardVO boardVO) throws Exception;
	
	public BoardVO getBoardDetail(BoardVO boardVO) throws Exception;
	
	public BoardVO insertBoard(BoardVO boardVO) throws Exception;
	
	public BoardVO deleteBoard(BoardVO boardVO) throws Exception;
	
	public BoardVO updateBoard(BoardVO boardVO) throws Exception;
}
