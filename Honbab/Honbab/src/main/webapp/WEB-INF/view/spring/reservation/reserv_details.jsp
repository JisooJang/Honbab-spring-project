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
<b><h3>${reservation.user_id}님의 ${reservation.rest_name} 식당 예약 상세정보 </h3></b><br>
<hr>
<img src="${restr.rest_thumbnail}">

<table align="center" class="table table-sm" style="width: 500px;">
<thead></thead>
<tbody>
<tr><td>예약 인원 : </td> <td>${reservation.numOfPeople}</td></tr>
<tr><td>예약 날짜 : </td> <td>${reservation.visit_date}</td></tr>
<tr><td>예약 시간 : </td> <td>${reservation.visit_time}</td></tr>
<tr><td>예약자 이름 : </td> <td>${reservation.name}</td></tr>
<tr><td>예약자 연락처: </td> <td>${reservation.phone}</td></tr>
<tr><td>기타 요청 사항 : </td> <td>${reservation.requested}</td></tr>
</tbody>
</table>
<br>
<a href="../reservation_modify/${reservation.reservation_id}"><button type="button" class="btn btn-secondary btn-sm">수정</button></a>
&nbsp;&nbsp;
<a href="../reservation"><button type="button" class="btn btn-secondary btn-sm">리스트</button></a>

</center>
</body>
</html>