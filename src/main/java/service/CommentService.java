package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.CommentMapper;
import vo.comment.CommentVo;

@Service("CommentService")
public class CommentService {

	@Resource(name = "CommentMapper")
	CommentMapper mCommentMapper;

	public List<CommentVo> commentListService() throws Exception {
		return mCommentMapper.commentList();
	}

	public int commentInsertService(CommentVo comment) throws Exception {
		return mCommentMapper.commentInsert(comment);
	}

	public int commentUpdateService(CommentVo comment) throws Exception {
		return mCommentMapper.commentUpdate(comment);
	}

	public int commentDeleteService(int cno) throws Exception {
		return mCommentMapper.commentDelete(cno);
	}

}
