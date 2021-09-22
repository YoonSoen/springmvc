package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import model.BoardDto;
import page.Criteria;


public interface BoardDao {
	public void create(BoardDto dto) throws Exception;
	public BoardDto read(int no) throws Exception;
	public void update(BoardDto dto) throws Exception;
	public void delete(int no) throws Exception;
	public List<BoardDto> listAll() throws Exception;
	public void increaseViewcnt(int no, HttpSession session) throws Exception;
	public List<Map<String, Object>> pageList(Criteria cri) throws Exception;
	public int countBoardList() throws Exception;

	
}
	


 