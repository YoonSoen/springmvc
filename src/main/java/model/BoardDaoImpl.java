package model;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import page.Criteria;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sqlst;

	public BoardDaoImpl(SqlSessionTemplate sqlst) {
		this.sqlst = sqlst;
	}

	@Override
	public void create(BoardDto dto) throws Exception {
		sqlst.insert("board.insert", dto);
	}

	@Override
	public BoardDto read(int no) throws Exception {
		return sqlst.selectOne("board.view", no);
	}

	@Override
	public void update(BoardDto dto) throws Exception {
		sqlst.update("board.update", dto);
	}

	@Override
	public void delete(int no) throws Exception {
		sqlst.update("board.delete", no);
	}

	@Override
	public List<BoardDto> listAll() throws Exception {
		return sqlst.selectList("board.listAll");
	}

	@Override
	public void increaseViewcnt(int no, HttpSession session) throws Exception {
		sqlst.update("board.increaseViewcnt", no);
	}

	@Override
	public List<Map<String, Object>> pageList(Criteria cri) throws Exception {
		return sqlst.selectList("boardDAO.pageList", cri);
	}

	@Override
	public int countBoardList() throws Exception {
		  return sqlst.selectOne("boardDAO.countBoardList");
	}

}
