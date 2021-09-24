<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
 
 
<h2> 게시글 상세 </h2>

<button class="btn btn-primary" onclick="location.href='/update/${detail.no}'">수정</button>
<button class="btn btn-danger" onclick="location.href='/delete/${detail.no}'">삭제</button>  


<layoutTag:layout>
<div class="container">
    <form action="/insertProc" method="post">
      <div class="form-group">
        <label>제목</label>
        <p>${detail.title}</p>
      </div>
      <div class="form-group">
        <label>작성자</label>
        <p>${detail.writer}</p>
      </div>
      <div class="form-group">
        <label>작성날짜</label>
        <p>${detail.regdate}</p>
      </div>
      <div class="form-group">
        <label>내용</label>
        <p>${detail.content}</p>
      </div>
      <button type="submit" class="btn btn-primary">작성</button>
    </form>
</div>
 
 
 
    <!--  댓글  -->
    <div class="container">
        <label for="content">comment</label>
        <form name="commentInsertForm">
            <div class="input-group">
               <input type="hidden" name="bno" value="${detail.bno}"/>
               <input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요.">
               <span class="input-group-btn">
                    <button class="btn btn-default" type="button" name="commentInsertBtn">등록</button>
               </span>
              </div>
        </form>
    </div>
    
    <div class="container">
        <div class="commentList"></div>
    </div>
</div>

<%@ include file="comment.jsp" %>
</layoutTag:layout>




