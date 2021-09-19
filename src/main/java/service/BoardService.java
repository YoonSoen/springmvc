package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.BoardDto;
import page.Criteria;

public interface BoardService {
	public void create(BoardDto dto) throws Exception;
	public BoardDto read(int no) throws Exception;
	public void update(BoardDto dto) throws Exception;
	public void delete(int no) throws Exception;
	public List<BoardDto> listAll() throws Exception;
	public void increaseViewcnt(int no, HttpSession session) throws Exception;
	List<Map<String, Object>> pageList(Criteria cri) throws Exception;
	public int countBoardList() throws Exception;
}
