<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@ include file="IncludeTop.jsp" %>

<table align="left" bgcolor="#008800" border="0" cellspacing="2" cellpadding="2">
<tr><td bgcolor="#FFFF88">
<a href="<c:url value="/shop/index.do"/>"><b><font color="BLACK" size="2">&lt;&lt; Main Menu</font></b></a>
</td></tr>
</table>

<center>
  <FORM action="searchProducts.do">
      <INPUT name=keyword size=14> 
      <INPUT border=0 src="../images/search.gif" type=image>
  </FORM>
  
   <FORM action="searchProducts2.do" method="post" >
  	  
      <div class="form-group">
		  <label for="restrctg">Select list:</label>
		  <select class="form-control" name="restrctg">
		  	<option value="0">선택없음</option>
		    <option value="1">한식</option>
		    <option value="2">일식</option>
		    <option value="3">중식</option>
			<option value="4">양식</option>
		  </select>
		</div>
		
		<div class="form-group">
		  <label for="area">Select list:</label>
		  <select class="form-control" name="area">
		    <option value="0">전체</option>
		    <option value="1">서울</option>
		    <option value="2">경기</option>
		    <option value="3">인천</option>
		    <option value="4">부산</option>
		    <option value="5">대구</option>
		    <option value="6">강원</option>
		    <option value="7">경남</option>
		    <option value="8">제주</option>
		  </select>
		</div>
		
		<div>
	      <INPUT border=0 value="적용하기" type="submit">
      </div>


  </FORM>
</center>

<br>
<div id="myCarousel" class="carousel">
  <!-- Carousel items -->
  <div class="carousel-inner">
  
  <c:forEach var="product" items="${productList.carouselList}">
  	<div class="item"><image id=${product.rest_id} src=${product.rest_thumbnail}></div>
</c:forEach>

    
  </div>
  <!-- Carousel nav -->
  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>

<table align="center" bgcolor="#008800" border="0" cellspacing="2" cellpadding="3" width="50%">
  <tr bgcolor="#CCCCCC">  <td>&nbsp;</td>  <td><b>Name</b></td>  <td></td></tr>
  
<c:forEach var="product" items="${productList.productList}">
  <tr bgcolor="#FFFF88">
  <td>
  </td>
  <td><a href="../restrDetail.do/${product.rest_id}"><c:out value="${product.rest_name}"/></a></td>
  <td><a href="../reservation.do/${product.rest_id}">예약</a></td> 
  </tr>
</c:forEach>

</table>

<script>
	$(function() {
		$('.carousel').carousel({
			  interval: 2000
			})
			console.log($('.carousel .item'))
			
		$('.carousel .item').eq(0).addClass("active");
	});
	
</script>
