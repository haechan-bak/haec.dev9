package com.blue.board.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.blue.board.vo.BoardVO;
import com.blue.board.common.ResultUtil;
import com.blue.board.service.BoardService;
 
@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
 
    @Autowired
    private BoardService boardService;
 
    @RequestMapping( value = "/boardList")
    public String getBoardList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.debug("## boardList");
        return "board/boardList";
    }
 
    @RequestMapping(value = "/getBoardList")
    @ResponseBody
    /*
    public List<BoardVO> getBoardList(HttpServletRequest request, HttpServletResponse response, BoardVO boardVO) throws Exception {
    	logger.debug("## BoardController : getBoardList");
        List<BoardVO> boardList = boardService.getBoardList(boardVO);;
        return boardList;
    }*/
    public ResultUtil getBoardList(HttpServletRequest request, HttpServletResponse response, BoardVO boardVO) throws Exception {
    	logger.debug("## BoardController : getBoardList");
    	logger.debug("######## getCurrentPageNo: "+ boardVO.getCurrentPageNo());
    	logger.debug("######## getFunctionName : "+ boardVO.getFunctionName());
        ResultUtil resultUtil = boardService.getBoardList(boardVO);
        return resultUtil;
    }
    
    /** 게시판 - 상세 페이지 이동 */
    @RequestMapping( value = "/boardDetail")
    public String boardDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return "board/boardDetail";
    }    
    
    /** 게시판 - 상세 조회  */
    @RequestMapping(value = "/getBoardDetail")
    @ResponseBody
    public BoardVO getBoardDetail(HttpServletRequest request, HttpServletResponse response, BoardVO boardVO) throws Exception {
    	logger.debug("## BoardController : getBoardDetail");
    	boardVO.setSearchType(request.getParameter("search_type"));
    	boardVO.setBoardSeq(Integer.parseInt(request.getParameter("board_seq")));
    	BoardVO boardDetVO = boardService.getBoardDetail(boardVO);
 
        return boardDetVO;
    }
    
    /** 게시판 - 작성 페이지 이동 */
    @RequestMapping( value = "/boardWrite")
    public String boardWrite(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return "board/boardWrite";
    }
    
    /** 게시판 - 등록 */
    @RequestMapping( value = "/insertBoard")
    @ResponseBody
    public BoardVO insertBoard(HttpServletRequest request, HttpServletResponse response, BoardVO boardVO) throws Exception{
        
    	boardVO.setBoardSubject(request.getParameter("board_subject"));
    	boardVO.setBoardWriter(request.getParameter("board_writer"));
    	boardVO.setBoardContent(request.getParameter("board_content"));
    	
    	BoardVO boardInsVO = boardService.insertBoard(boardVO);
        
        return boardInsVO;
    }
    
    /** 게시판 - 삭제 */
    @RequestMapping( value = "/deleteBoard")
    @ResponseBody
    public BoardVO deleteBoard(HttpServletRequest request, HttpServletResponse response, BoardVO boardVO) throws Exception{
        
    	boardVO.setBoardSeq(Integer.parseInt(request.getParameter("board_seq")));
    	
    	BoardVO boardDelVO = boardService.deleteBoard(boardVO);
        
        return boardDelVO;
    }
    
    /** 게시판 - 수정 페이지 이동 */
    @RequestMapping( value = "/boardUpdate")
    public String boardUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return "board/boardUpdate";
    }
    
    /** 게시판 - 수정 */
    @RequestMapping( value = "/updateBoard")
    @ResponseBody
    public BoardVO updateBoard(HttpServletRequest request, HttpServletResponse response, BoardVO boardVO) throws Exception{
        
    	boardVO.setSearchType(request.getParameter("search_type"));
    	boardVO.setBoardSeq(Integer.parseInt(request.getParameter("board_seq")));
    	boardVO.setBoardSubject(request.getParameter("board_subject"));
    	boardVO.setBoardContent(request.getParameter("board_content"));
    	
    	BoardVO boardUpdVO = boardService.updateBoard(boardVO);
        
        return boardUpdVO;
    }
}
