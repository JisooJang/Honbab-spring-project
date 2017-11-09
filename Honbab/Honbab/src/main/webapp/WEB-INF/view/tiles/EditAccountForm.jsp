<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form class="form-horizontal" commandName="accountForm" enctype="multipart/form-data">
<!-- print all error messages -->
<B><FONT color=RED><BR>
<!--<form:errors />    print only the global errors set by errors.reject() in a validator -->
<form:errors path="*"/>   <!-- print out errors for all the properties -->
</FONT></B>

<tr><td>
<fieldset>

<!-- Form Name -->
<center><h3>User Info</h3></center>
<center>
<c:if test="${!empty accountForm.account.profile}">
	<img src="${accountForm.account.profile}" width="100px" height="100px"/> 
</c:if>
</center>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="userID">UserID</label>  
  <div class="col-md-4">

  <c:if test="${accountForm.newAccount}">
      <form:input path="account.user_id" class="form-control input-md"/>
    </c:if>
    <c:if test="${!accountForm.newAccount}">
      <c:out value="${accountForm.account.user_id}"/>
    </c:if>
 
  </div>
</div>
<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">New password</label>  
  <div class="col-md-4">
  <form:input path="account.password" type="password" placeholder="Enter password" class="form-control input-md"/>
  </div>
</div>
<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="repeatPassword">Repeat password</label>  
  <div class="col-md-4">
  <form:input path="repeatedPassword" type="password" placeholder="Enter password" class="form-control input-md"/>
  </div>
</div>


<%@ include file="IncludeAccountFields.jsp" %>

<div class="form-group">
  <label class="col-md-4 control-label" for="profile">Profile</label>
  <div class="col-md-4">
              <form:input type="file" path="profile"  class="input-file" accept=".png,.jpeg,.jpg"/>
     <div id="account_imageDisplay"></div>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button type="submit" id="signup" name="signup" class="btn btn-success" >Save Account Information</button>
  </div>
</div>

</fieldset>
</form:form> 
<p/>

<center><b>
	<c:if test="${userSession.account.type eq 'owner'}">
		<a href="<c:url value="/shop/newRestr.do"/>">Register Restr </a>
	</c:if>
</b></center>   
<center><b><a href="mypage/reservation">My Reservation</a></b></center>
<center><b><a href="mypage/ticketList">My Ticket</a></b></center>       
