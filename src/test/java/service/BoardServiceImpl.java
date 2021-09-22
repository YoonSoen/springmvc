package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.BoardDao;
import model.BoardDto;
import page.Criteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDao boardDao;

	@Override
	public void create(BoardDto dto) throws Exception {
		String title = dto.getTitle();
		String content = dto.getContent();
		String writer = dto.getWriter();
		
//		"태그문자 처리"
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace("<", "&gt;");
		
//		공백문자처리
		title = title.replace("  ", "&nbsp;&nbsp;");
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		
//		줄바꿈
		content=content.replace("\n", "<br>");
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriter(writer);
		boardDao.create(dto);		
	}

	@Override
	public BoardDto read(int no) throws Exception {
		return boardDao.read(no);
	}

	@Override
	public void update(BoardDto dto) throws Exception {
		boardDao.update(dto);
	}


	@Override
	public void delete(int no) throws Exception {
		boardDao.delete(no);
		
	}
	
	@Override
	public List<BoardDto> listAll() throws Exception {
		return boardDao.listAll();
	}

	@Override
	public void increaseViewcnt(int no, HttpSession session) throws Exception {
		long uptime = 0;
		if(session.getAttribute("uptime"+no) != null) {
			uptime = (long)session.getAttribute("uptime"+no);
		}
		
		long currenttime= System.currentTimeMillis();
		
		if(currenttime - uptime > 5* 1000) {
			boardDao.increaseViewcnt(no, null);
			
			session.setAttribute("uptime"+no, currenttime);
		}
	}

	@Override
	public List<Map<String, Object>> pageList(Criteria cri) throws Exception {
		return boardDao.pageList(cri);
	}

	@Override
	public int countBoardList() throws Exception {
		 return boardDao.countBoardList();
	}




}
