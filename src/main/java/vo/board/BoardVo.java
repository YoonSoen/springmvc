package vo.board;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("BoardDto")
public class BoardVo {
	/*
	 * CREATE TABLE board(
			no NUMBER PRIMARY KEY,
			 title VARCHAR2(1000),
		     content VARCHAR2(1000),
			 regdate  DATE default sysdate,
			 viewcnt NUMBER default 0
		     );
		     
		     CREATE SEQUENCE board_SEQ 
		     START WITH 1 
		     INCREMENT BY 1
		     MAXVALUE 10000 
		     MINVALUE
			 1 NOCYCLE;
			 
		    commit;
	 */

	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + "]";
	}
	
	
	
	
	
	

}
