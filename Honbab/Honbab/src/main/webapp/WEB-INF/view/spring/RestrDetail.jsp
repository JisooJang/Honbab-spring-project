<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<img src="${restr.rest_thumbnail}">
</center>

<br>
<br>
<table align="center" border="0" width="70%">
	<tr>
		<td rowspan="2" width="30%">
		&nbsp;
		</td>
		
		<td>
		<c:out value="${restr.rest_name}"/>
		</td>
	</tr>
	
	<tr>
		<td>
		<c:choose>
		<c:when test = "${restr.rest_star == 0}">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		</c:when>
		
		<c:when test = "${restr.rest_star == 1}">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		</c:when>
		
		<c:when test = "${restr.rest_star == 2}">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		</c:when>
		
		<c:when test = "${restr.rest_star == 3}">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		</c:when>
		
		<c:when test = "${restr.rest_star == 4}">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star0.png">
		</c:when>
		
		<c:otherwise>
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		<img src="${pageContext.request.contextPath}/images/star1.png">
		</c:otherwise>
		</c:choose>
		</td>
	</tr>
</table>

<br>
<table align="center" border="0" width="70%">
	<tr>
		<td>
		주소 : 
		<c:out value="${restr.rest_addr}"/>
		</td>
	</tr>
	
	<tr>
		<td>
		전화 : 
		<c:out value="${restr.rest_phone}"/>
		</td>
	</tr>
	
	<tr>
		<td>
		영업 시간 : 
		<c:out value="${restr.rest_time}"/>
		</td>
	</tr>
</table>

<!-- menu -->
<br>
<table align="center" border="0" width="70%">

	<c:forEach var="menu" items="${menuList}">
	<tr>
		<td rowspan="2">
		<img src="${menu.menu_image}">
		</td>
		<td>
		<td><c:out value="${menu.menu_name}"/></td>
		</td>
	</tr>
	
	<tr>
		<td>
		<c:out value="${menu.price}"/>원
		</td>
	</tr>
	</c:forEach>
	
</table>

<br>
<table align="center" border="0" cellspacing="2" cellpadding="2">
	<tr>
	<td bgcolor="#FFFF88">
	<a href="../reservation.do/${restr.rest_id}"><b><font color="BLACK" size="2">예약하기</font></b></a>
	</td>
	
	<td>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<td bgcolor="#FFFF88">
	<a href="../orderform/${restr.rest_id}"><b><font color="BLACK" size="2">결제하기</font></b></a>
	</td>
	</tr>
</table>

<!-- review -->
<br>
<hr>
<table align="center" border="0" cellspacing="2" cellpadding="2" width="70%">
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	
	<c:forEach var="review" items="${reviewList}">
 	<tr>
		<td><c:out value="${review.user_id}"/></td>
		<td><c:out value="${review.review_date}"/></td>
		<td align="center" rowspan=2 width="70%">
			<c:if test="${review.user_id == userSession.account.user_id}">
			<a href="/Honbab/deleteReview.do/${review.review_id}/${restr.rest_id}"><c:out value="삭제"/></a>
			</c:if>
			&nbsp;
		</td>
	</tr>
	
	<tr>
		<td colspan=2>
				<c:choose>
					<c:when test = "${review.review_star == 0}">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					</c:when>
					
					<c:when test = "${review.review_star == 1}">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					</c:when>
					
					<c:when test = "${review.review_star == 2}">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					</c:when>
					
					<c:when test = "${review.review_star == 3}">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					</c:when>
					
					<c:when test = "${review.review_star == 4}">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star0.png">
					</c:when>
					
					<c:otherwise>
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					<img src="${pageContext.request.contextPath}/images/star1.png">
					</c:otherwise>
				</c:choose>
		</td>
	</tr>
	
	<tr>
		<td colspan=3><c:out value="${review.review_content}"/></td>
	</tr>
	
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	</c:forEach>
</table>

<!-- add review -->
<br/>
<b>댓글 쓰기</b><br/>

<form:form action="/Honbab/addReview.do" commandName="reviewCommand">

<input type=hidden name="review.rest_id" value="${restr.rest_id}"/>

    혼밥 지수 (1점 ~ 5점) : <form:input path="review.review_star"/>점
    
    <br/>
	<form:input path="review.review_content" width="300"/>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="댓글입력">
	
</form:form>

<br/>

</body>

</html>