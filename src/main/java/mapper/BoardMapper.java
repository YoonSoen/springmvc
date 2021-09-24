package mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import vo.board.BoardVo;
import vo.file.FileVo;

@Repository
public interface BoardMapper {
	//게시글 개수  
    public int boardCount() throws Exception;
    
    //게시글 목록  
    public List<BoardVo> boardList() throws Exception;
    
    //게시글 상세
    public BoardVo boardDetail(int bno) throws Exception;
    
    //게시글 작성  
    public void boardInsert(BoardVo vo) throws Exception;
    
    //게시글 수정  
    public void boardUpdate(BoardVo vo) throws Exception;
    
    //게시글 삭제  
    public void boardDelete(int bno) throws Exception;
    
    //파일 업로드
    public int fileInsert(FileVo file) throws Exception;


}
