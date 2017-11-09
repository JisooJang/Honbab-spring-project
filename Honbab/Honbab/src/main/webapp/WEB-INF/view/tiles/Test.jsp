<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="../resources/vendor/jquery/jquery.min.js"></script>

</head>
<body>

<form:form class="form-horizontal" commandName="restrForm" enctype="multipart/form-data">

<B><FONT color=RED><BR>
<!--<form:errors />    print only the global errors set by errors.reject() in a validator -->
<form:errors path="*"/>   <!-- print out errors for all the properties -->
</FONT></B>

<fieldset>


<!-- Form Name -->
<center><h3>Restaurant Information</h3></center>
<center>
<c:if test="${empty restrForm.restr.rest_thumbnail}">
	<img  width="100" height="100" src="../images/add_profile_image.png"/> 
</c:if>
<c:if test="${!empty restrForm.restr.rest_thumbnail}">
	<img width="100" height="100" src="${restrForm.restr.rest_thumbnail}" /> 
</c:if>
</center>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>  
  <div class="col-md-4">
  <form:input path="restr.rest_name"  type="text" placeholder="Enter your name" class="form-control input-md"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address</label>  
  <div class="col-md-4">
  <form:input path="restr.rest_addr" type="text" placeholder="Enter your address" class="form-control input-md" />
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="phone">Contact</label>  
  <div class="col-md-4">
  <form:input path="restr.rest_phone"  type="text" placeholder="Enter your contact number" class="form-control input-md" />
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="time">Time</label>  
  <div class="col-md-4">
  <form:input path="restr.rest_time" type="text" placeholder="Enter your time" class="form-control input-md" />
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="seat">Seat</label>  
  <div class="col-md-4">
  <form:input path="restr.rest_seat"  type="text" placeholder="Enter your seat" class="form-control input-md" />
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="account">Account</label>  
  <div class="col-md-4">
  <form:input path="restr.rest_account" id="account" name="account" type="text" placeholder="Enter your account" class="form-control input-md" />
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="bankcode">Bank Code</label>  
  <div class="col-md-4">
  <form:input path="restr.rest_bankcode" id="bankcode" name="bankcode" type="text" placeholder="Enter your bank code" class="form-control input-md" />
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="category">Category</label>  
  <div class="col-md-4">
  <form:select path="restr.rest_ctg" id="category" name="category"  class="form-control">
    <option value="1">한식</option>
  	<option value="2">일식</option>
 	<option value="3">중식</option>
 	<option value="4">양식</option>
  </form:select>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="menu_imge">Thumbnail</label>
  <div class="col-md-4">
              <input type="file" id="thumbnail" name="thumbnail" class="input-file" accept=".png,.jpeg,.jpg">
     <div id="menu_imageDisplay"></div>
  </div>
</div>

<%@ include file="IncludeMenuFields.jsp" %>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button type="submit" id="signup" name="signup" class="btn btn-success" style="width: 200px;">식당등록</button>
  </div>
</div>

</fieldset>
</form:form> 



<br><br>

     



</body>
</html>