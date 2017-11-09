<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form commandName="restrForm" >
<!-- print all error messages -->
<B><FONT color=RED><BR>
<!--<form:errors />    print only the global errors set by errors.reject() in a validator -->
<form:errors path="*"/>   <!-- print out errors for all the properties -->
</FONT></B>


<h3><font color="darkgreen">User Information</font></h3>
<table border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFF88">
<tr bgcolor="#FFFF88">
  <td>User ID:</td>
  <td>
    <c:if test="${restrForm.newAccount}">
      <form:input path="account.user_id"/>
    </c:if>
    <c:if test="${!restrForm.newAccount}">
      <c:out value="${restrForm.restr.rest_id}"/>
    </c:if>
  </td>
</tr>
<tr bgcolor="#FFFF88">
  <td>New password:</td>
  <td><form:password path="account.password"/></td>
</tr>
<tr bgcolor="#FFFF88">
  <td>Repeat password:</td>
  <td><form:password path="repeatedPassword"/></td>
</tr>
</table>


<br/><center>
<input border="0" type="image" src="../images/button_submit.gif" name="submit" value="Save Account Information" />
</center>

</form:form>

<p/>
<center><b><a href="<c:url value='/shop/listOrders.do'/>">My Orders</a></b></center>
