package model;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("BoaedDto")
public class BoardDto {
	/*
	 * CREATE TABLE "Board"( "Num" NUMBER PRIMARY KEY, --글번호 "Writer" VARCHAR2(50),
	 * --작성자 "Subject" VARCHAR2(50), --글제목 "Content" VARCHAR2(1000), --글내용 "Date"
	 * DATE default sysdate, --작성일 "ReadCount" NUMBER default 0, --조회수 "Ref" NUMBER
	 * default 0, --계층형게시판, 글의 그룹 "Restep" NUMBER default 0, --계층형게시판, 글의 순서(order)
	 * "Relevel" NUMBER default 0 --계층형게시판, 글의 레벨 );
	 * 
	 * CREATE SEQUENCE Board_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 10000 MINVALUE
	 * 1 NOCYCLE;
	 * 
	 * commit;
	 */

	private int no;
	
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;

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

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", viewcnt=" + viewcnt + "]";
	}
	
	

}
