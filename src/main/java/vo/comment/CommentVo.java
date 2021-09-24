package vo.comment;

import java.util.Date;

public class CommentVo {
	/*
	 * create table comment(
	  cno int not null primary key, //댓글 seq
	  bno int not null,    //댓글이 달릴 게시글 seq
	  content text not null, //댓글 내용
	  writer varchar(20) not null, //댓글 작성자
	  regdate datetime not null); // 댓글 작성 시간

	 */

	private int cno;
	private int bno;
	private String content;
	private String writer;
	private Date regdate;
	 
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	 
	 
	 


}
