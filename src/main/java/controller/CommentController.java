package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CommentService;
import vo.comment.CommentVo;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService mCommentService;

	@RequestMapping(value ="/list") // 댓글 리스트
	@ResponseBody
	public List<CommentVo> mCommentServiceList(Model model) throws Exception {

		return mCommentService.commentListService();
	}

	@RequestMapping(value ="/insert") // 댓글 작성
	@ResponseBody
	public int mCommentServiceInsert(@RequestParam int bno, @RequestParam String content, String writer) throws Exception {

		CommentVo comment = new CommentVo();
		comment.setBno(bno);
		comment.setContent(content);
		comment.setWriter(writer);

		return mCommentService.commentInsertService(comment);
	}

	@RequestMapping(value ="/update") // 댓글 수정
	@ResponseBody
	public int mCommentServiceUpdateProc(@RequestParam int cno, @RequestParam String content) throws Exception {

		CommentVo comment = new CommentVo();
		comment.setCno(cno);
		comment.setContent(content);

		return mCommentService.commentUpdateService(comment);
	}

	@RequestMapping(value ="/delete/{cno}") // 댓글 삭제
	@ResponseBody
	public int mCommentServiceDelete(@PathVariable int cno) throws Exception {

		return mCommentService.commentDeleteService(cno);
	}

}
