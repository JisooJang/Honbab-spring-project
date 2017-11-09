<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<center>
<br>
<table align="left" bgcolor="#008800" border="0" cellspacing="2" cellpadding="2">
<tr><td bgcolor="#FFFF88">
<a href="<c:url value="/shop/index.do"/>"><b><font color="BLACK" size="2">&lt;&lt; Main Menu</font></b></a>
</td></tr>
</table>


<h2>${rest_name} 예약 신청</h2>
<br>

<form:form commandName="reservationCommand" method="post">

<table>
<label for="reservation.numOfPeople">인원 수</label>: 
<form:input type="text" path="reservation.numOfPeople"/>
<form:errors path="reservation.numOfPeople"/> <br>

<label for="reservation.visit_date">방문 날짜</label>: 
<form:input type="text" path="reservation.visit_date" value="${reservation.visit_date}"/>
<form:errors path="reservation.visit_date"/><br>

<label for="reservation.visit_time">방문 시간</label>: 
<form:input type="text" path="reservation.visit_time" value="${reservation.visit_time}" />
<form:errors path="reservation.visit_time"/> <br/>

<label for="reservation.name">예약자 이름</label>: 
<form:input type="text" path="reservation.name" value="${reservation.name}"/>
<form:errors path="reservation.name"/> <br/>

예약자 연락처:
<form:input type="text" path="reservation.phone" value="${reservation.phone}" />
<form:errors path="reservation.phone"/> <br/>

예약 요청 사항 :
<form:textarea path="reservation.requested" cols="50" rows="5"></form:textarea>
</table>

<hr>

<input type="submit" value="예약" />

</form:form>

</center>
</body>
</html>