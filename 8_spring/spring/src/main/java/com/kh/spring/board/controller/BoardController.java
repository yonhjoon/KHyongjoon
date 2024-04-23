package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.board.service.BoardService;
import com.kh.spring.common.model.vo.PageInfo;
import com.kh.spring.common.template.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("list.bo")
	public String selectList(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int boardCount = boardService.selectListCount();
		
		PageInfo pi = Pagination.getPageInfo(boardCount, currentPage, 10, 5);
		ArrayList<Board> list = boardService.selectList(pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return "board/boardListView";
	}
	
	@RequestMapping(value = "detail.bo")
	public String selectBoard(int bno, Model model) {
		
		int result = boardService.increaseCount(bno);
		
		if (result > 0) {
			Board b = boardService.selectBoard(bno);
			model.addAttribute("b", b);
			
			return "board/boardDetailView";
			
		} else {
			model.addAttribute("errorMsg", "게시글 조회 실패");
			return "common/errorPage";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "rlist.bo", produces="application/json; charset-UTF-8")
	public String ajaxSelectReplyList(int bno) {
		ArrayList<Reply> list = boardService.selectReply(bno);
		
		return new Gson().toJson(list);
	}
	
	//게시글 등록
	@RequestMapping("enrollForm.bo")
	public String enrollForm() {
		return "board/boardEnrollForm";
	}
	
	//파일불러오는거
	@RequestMapping("insert.bo")
	public String insertBoard(Board b, MultipartFile upfile, HttpSession session, Model model){
		System.out.println(b);
		System.out.println(upfile);
		
		//전달된 파일이 있을경우  => 파일이름 변경 => 서버에 저장 => 원본명, 서버업로드된 경로를 b객체에 담기
		if(!upfile.getOriginalFilename().equals("")) {
			String changeName = saveFile(upfile, session);
			
			b.setOriginName(upfile.getOriginalFilename());
			b.setChangeName("resources/uploadFiles/" + changeName);
			
		} 
		
		int result = boardService.insertBoard(b);
		if(result > 0) { // 성공 => list.bo페이지로 이동
			session.setAttribute("alerMsg", "게시글 작성 성공");
			return "redirect:list.bo";
		} else { // 실패 => 에러페이지
			model.addAttribute("errorMsg","게시글 작성 실패");
			return "common/errorPage";
		}
	}
	
	//실제 넘어온 파일의 이름을 변경해서 서버에 저장하는 메소드
	//우리가 할때는 템플릿 안에다 만들어야된다 컨트롤러에는 안된다 우리보기 편하라고 만든것
	public String saveFile(MultipartFile upfile, HttpSession session) {
		//파일명 수정 후 서버에 업로드하기("imgFile.jsp => 202404231004305488.jpg")
		String originName = upfile.getOriginalFilename();
		//년월일시분초
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	
		// 5자리 랜덤값
		int ranNum = (int)(Math.random() * 90000) + 10000;
		
		// 확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		//수정된 첨부파일명
		String changeName = currentTime + ranNum + ext;
		
		//첨부파일을 저장할 폴더의 물리적 경로(session)
		String savePath = session.getServletContext().getRealPath("/resources/uploadFile/");
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
		
	}
	
	//게시글 수정하기 페이지
	@RequestMapping("updateForm.bo")
	public String updateForm(int bno, Model model) {
		
		model.addAttribute("b", boardService.selectBoard(bno));
		return "board/boardUpdateForm";
		
	}
	
	//게시글 수정완료
	@RequestMapping("update.bo") // @ModelAttribute 가 항상 생략되있다
	public String update(Board b,MultipartFile reupfile, HttpSession session,Model model) {
		
		//새로운 첨부파일이 넘어온 경우
		if(!reupfile.getOriginalFilename().equals("")) {
			//기존의 첨부파일이 있다 => 기존의 파일을 삭제
			if(b.getOriginName() != null) {
				new File(session.getServletContext().getRealPath(b.getChangeName())).delete();
			}
			
			//새로 넘어온 첨부파일을 서버에 업로드 시키기
			String changeName = saveFile(reupfile, session);
			
			b.setOriginName(reupfile.getOriginalFilename());
			b.setChangeName("resources/uploadFiles/" + changeName);
		}
		
		/*
		 * b에 boardTitle, boardContent가 들어있겠죠?
		 * 
		 * 1. 새로운 첨부파일 x, 기존 첨부파일 x
		 *    => originName : null, changName : null
		 *    
		 * 2. 새로운 첨부파일 x, 기존 첨부파일 o
		 *    => originName : 기존 첨부파일 이름 , changName : 기본 첨부파일 경로
		 *    
		 * 3. 새로운 첨부파일 o, 기존첨부파일 o
		 *    => originName : 새로운 첨부파일 이름 , changName : 새로운 첨부파일 경로
		 *    
		 * 4. 새로운 첨부파일 o, 기존첨부파일 x
		 * 	  => originName : 새로운 첨부파일 이름 , changName : 새로운 첨부파일 경로
		 */
		
		int result = boardService.updateBoard(b);
		
		if(result > 0) { // 성공
			session.setAttribute("alertMsg", "게시글 수정 성공");
			return "redirect:detail.bo?bno=" + b.getBoardNo();
		} else { // 실패
			model.addAttribute("errorMsg","게시글 수정 실패");
			return "common/errorPage";
		}
		
	}
	
}
