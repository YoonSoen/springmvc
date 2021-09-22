package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.BoardDao;
import model.BoardDto;
import page.Criteria;
import page.PageMaker;
import service.BoardService;
@Controller
@RequestMapping("/board/*")
public class ControllerAction extends HttpServlet {
	@Autowired
	BoardService boardservice;
	
	 // 게시판 페이징
    @RequestMapping(value="/boardPageList")
    public ModelAndView boardPageList(Criteria cri, HttpSession session) throws Exception {
        ModelAndView mav = null;
        if(session.getAttribute("id") == null) {
            mav = new ModelAndView("redirect");
            mav.addObject("msg", "잘못된 접근 입니다!!");
            mav.addObject("url", "login");
            return mav;
        } else {
            mav = new ModelAndView("/boardPageList");
            PageMaker pageMaker = new PageMaker();
            pageMaker.setCri(cri);
            pageMaker.setTotalCount(boardservice.countBoardList());

            List<Map<String, Object>> list = boardservice.pageList(cri);

            mav.addObject("list", list);
            mav.addObject("pageMaker", pageMaker);

            return mav;
        }
    }

	
	@RequestMapping(value="list.do")
	public String boardList(Model model, HttpSession session) throws Exception{
		if(session.getAttribute("id") == null) {
            model.addAttribute("msg", "잘못된 접근입니다!!");
            model.addAttribute("url", "login");
            return "redirect";
        } else {
            model.addAttribute("boardList", boardservice.listAll());
            model.addAttribute("user", session.getAttribute("user"));
            return "board/list";
        }
	}
	
	@RequestMapping(value="board/write.do", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardDto", new BoardDto());
		return "board/write";
	}
	
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int no, HttpSession session) throws Exception{
		boardservice.increaseViewcnt(no, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("dto", boardservice.read(no));
		return mav;
	}
	
	
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDto dto) throws Exception {
		boardservice.update(dto);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "delete.do", method=RequestMethod.GET)
	public String deleteView(@RequestParam int no, Model model, HttpSession session, RedirectAttributes rttr) 
			throws Exception {
		if(session.getAttribute("writer").equals(boardservice.read(no).getWriter())) {
			boardservice.delete((no));
			return "redirect:list.do";
		}else {
			rttr.addFlashAttribute("삭제 권한이 없습니다.");
			return "redirect:list.do";
		}
	}

	
	
	
}
