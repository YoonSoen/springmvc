package controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import page.Criteria;
import page.PageMaker;
import service.BoardService;
import vo.board.BoardVo;
import vo.file.FileVo;

@Controller
public class ControllerAction {
 
	@Autowired
    private BoardService mBoardService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET) //게시판 리스트 화면 호출  
    public String boardList(Model model) throws Exception{
        
        model.addAttribute("list", mBoardService.boardListService());
        
        return "list"; //생성할 jsp
    }
    
    @RequestMapping(value = "/detail/{no}") 
    public String boardDetail(@PathVariable int no, Model model) throws Exception{
        
        model.addAttribute("detail", mBoardService.boardDetailService(no));
        
        return "detail";
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST) //게시글 작성폼 호출  
    public String boardInsertForm(){
        
        return "insert";
    }
    
    @RequestMapping(value = "/insertProc")
    public String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception{
        
    	 BoardVo vo = new BoardVo();
    	 FileVo file  = new FileVo();
         
         vo.setTitle(request.getParameter("title"));
         vo.setContent(request.getParameter("content"));
         vo.setWriter(request.getParameter("writer"));
         
         
         if(files.isEmpty()){ //업로드할 파일이 없을 시
             mBoardService.boardInsertService(vo); //게시글 insert
         }else{
             String fileName = files.getOriginalFilename(); 
             String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase(); 
             File destinationFile; 
             String destinationFileName; 
             String fileUrl = "C:\\Javastudy\\springwork\\springmvc00\\src\\main\\webapp\\WEB-INF\\files";
             
             do { 
                 destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension; 
                 destinationFile = new File(fileUrl+ destinationFileName); 
             } while (destinationFile.exists()); 
             
             destinationFile.getParentFile().mkdirs(); 
             files.transferTo(destinationFile); 
             
             mBoardService.boardInsertService(vo); //게시글 insert
             
             file.setBno(vo.getNo());
             file.setFileName(destinationFileName);
             file.setFileOriName(fileName);
             file.setFileUrl(fileUrl);
             
             mBoardService.fileInsertService(file); //file insert
         }
         
         
         return "redirect:/list";

    }
    
    @RequestMapping(value = "/update/{no}", method = RequestMethod.POST) //게시글 수정폼 호출  
    public String boardUpdateForm(@PathVariable int no, Model model) throws Exception{
        
        model.addAttribute("detail", mBoardService.boardDetailService(no));
        
        return "update";
    }
    
    @RequestMapping(value ="/updateProc", method = RequestMethod.POST)
    public String boardUpdateProc(HttpServletRequest request) throws Exception{
        
    	 BoardVo vo = new BoardVo();
    	 vo.setTitle(request.getParameter("title"));
         vo.setContent(request.getParameter("content"));
         vo.setNo(Integer.parseInt(request.getParameter("no")));
         
         mBoardService.boardInsertService(vo);
         
         return "redirect:/detail/"+request.getParameter("no"); 

    	 
    }
 
    @RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
    public String boardDelete(@PathVariable int no) throws Exception{
        
        mBoardService.boardDeleteService(no);
        
        return "redirect:/list";
    }


	
	
}
