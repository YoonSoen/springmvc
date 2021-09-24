package mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import vo.comment.CommentVo;

@Repository
public interface CommentMapper {
	// 댓글 개수
	public int commentCount() throws Exception;

	// 댓글 목록
	public List<CommentVo> commentList() throws Exception;

	// 댓글 작성
	public int commentInsert(CommentVo comment) throws Exception;

	// 댓글 수정
	public int commentUpdate(CommentVo comment) throws Exception;

	// 댓글 삭제
	public int commentDelete(int cno) throws Exception;

}
