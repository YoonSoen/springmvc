package service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import mapper.BoardMapper;
import page.Criteria;
import vo.board.BoardVo;
import vo.file.FileVo;

@Service("BoardService")
public class BoardService {

	@Resource(name = "BoardMapper")
	BoardMapper mBoardMapper;

	public List<BoardVo> boardListService() throws Exception {
		return mBoardMapper.boardList();
	}

	public BoardVo boardDetailService(int no) throws Exception {
		return mBoardMapper.boardDetail(no);
	}

	public void boardInsertService(BoardVo vo) throws Exception {
		mBoardMapper.boardInsert(vo);
		return;
	}

	public void boardUpdateService(BoardVo vo) throws Exception {
		mBoardMapper.boardUpdate(vo);
		return;
	}

	public void boardDeleteService(int no) throws Exception {
		mBoardMapper.boardDelete(no);
		return;
	}

	public int fileInsertService(FileVo file) throws Exception {
		return mBoardMapper.fileInsert(file);
	}

}
