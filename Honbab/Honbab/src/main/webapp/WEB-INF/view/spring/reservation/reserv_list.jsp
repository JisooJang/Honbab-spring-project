<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../IncludeTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

</head>
<body>

<br>
<table align="left" bgcolor="#008800" border="0" cellspacing="2" cellpadding="2">
<tr><td bgcolor="#FFFF88">
<a href="<c:url value="/shop/index.do"/>"><b><font color="BLACK" size="2">&lt;&lt; Main Menu</font></b></a>
</td></tr>
</table>

<center>
<h2>${userSession.account.user_id}님의 예약 내역</h2>
<hr>

<table align="center" class="table table-hover" style="width: 1000px;">
<thead>
<tr><th>예약번호</th> <th>식당아이디</th><th>식당명</th> <th>인원</th> <th>예약날짜</th> <th>예약시간</th> 
<th></th><th></th><th></th></tr>
</thead>

<tbody>
<c:forEach var="reservation" items="${reservation_list}">
<tr>
<td>${reservation.reservation_id}</td>
<td>${reservation.rest_id}</td>
<td>${reservation.rest_name}</td>
<td>${reservation.numOfPeople}</td>
<td>${reservation.visit_date}</td>
<td>${reservation.visit_time}</td>
<td><a href="reservation_details/${reservation.reservation_id}"><button type="button" class="btn btn-secondary btn-sm">상세</button></a></td>
<td><a href="reservation_modify/${reservation.reservation_id}"><button type="button" class="btn btn-secondary btn-sm">수정</button></a></td>
<td><a href="reservation_delete/${reservation.reservation_id}"><button type="button" class="btn btn-secondary btn-sm">삭제</button></a></td>
</tr>
</c:forEach>
<tbody>
</table>
</center>
</body>
</html>