<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

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
${reservation.user_id}��, <br>
${rest_name} �Ĵ� ������ �Ϸ�Ǿ����ϴ�.<br>
<hr>
<b>���� ���� Ȯ��</b> <br>
<table align="center">
<tr><td>���� �ο� : </td> <td>${reservation.numOfPeople}</td></tr>
<tr><td>���� ��¥ : </td> <td>${reservation.visit_date}</td></tr>
<tr><td>���� �ð� : </td> <td>${reservation.visit_time}</td></tr>
<tr><td>������ �̸� : </td> <td>${reservation.name}</td></tr>
<tr><td>������ ����ó: </td> <td>${reservation.phone}</td></tr>
<tr><td>��Ÿ ��û ���� : </td> <td>${reservation.requested}</td></tr>
</table>
</center>
</body>
</html>