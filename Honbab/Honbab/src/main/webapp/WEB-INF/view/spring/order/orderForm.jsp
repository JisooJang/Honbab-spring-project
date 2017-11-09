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
<h3><b>${rest_name} 식권 결제 폼</b></h3>
<br>
<form:form commandName="orderCommand" method="post">

<table align="center">
<tr>
<td>

<label for="order.menu_id">메뉴</label>: 
<form:select path="order.menu_id">
<option value="">---선택---</option>
<c:forEach var="temp" items="${menu}">
<form:option value="${temp.menu_id}">${temp.menu_name}---${temp.price}원</form:option>
</c:forEach>
</form:select>

<label for="order.quantity">수량</label>: 
<form:input type="text" path="order.quantity" size="2"/>
<form:errors path="order.quantity"/>
</td></tr>

<%-- <tr><td>
<label for="order.sum">총 금액</label>: 
<form:input type="text" path="reservation.visit_time" value="${reservation.visit_time}" />
<form:errors path="reservation.visit_time"/> </td></tr>

<tr><td>
<label for="reservation.name">결제 방법</label>: 
<form:input type="text" path="reservation.name" value="${reservation.name}"/>
<form:errors path="reservation.name"/> </td></tr> --%>

</table>
<hr>

<%-- <c:if test="${order.menu_id != ''}">
</c:if>
 --%>
 
<input type="submit" value="결제요청" />

</form:form>
</body>
</html>