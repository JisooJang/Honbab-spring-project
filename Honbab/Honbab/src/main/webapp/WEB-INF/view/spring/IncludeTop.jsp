
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<html><head><title>JPetStore Demo</title>
<meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
<META HTTP-EQUIV="Cache-Control" CONTENT="max-age=0">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<meta http-equiv="expires" content="0">
<META HTTP-EQUIV="Expires" CONTENT="Tue, 01 Jan 1980 1:00:00 GMT">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://bootstrapdocs.com/v2.0.3/docs/assets/js/bootstrap-carousel.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<body bgcolor="white">

<table border="0" cellspacing="0" cellpadding="5" width="100%">
  <tbody>
  <tr>
    <td><a href="<c:url value="/shop/index.do"/>"><img src="../../images/main_logo.png" /></a></td>
    <td align="right">

<c:if test="${empty userSession.account}">
	<a href="<c:url value="/shop/signonForm.do"/>">Login</a>
</c:if>
<c:if test="${empty userSession.account}">
    <a href="<c:url value="/shop/newAccount.do"/>">join</a>
</c:if>

<c:if test="${!empty userSession.account}" >
      <%-- <a href="<c:url value="/shop/editAccount.do"/>"> MyPage</a>
      <a href="<c:url value="/shop/signoff.do"/>"> Log-out</a>
      <a href="<c:url value="/shop/searchProducts.do"/>">search</a>
      <a href="mypage/reservation">reservation</a> --%>
      
      <ul class="nav justify-content-end">
  <li class="nav-item">
    <a class="nav-link active" href="<c:url value="/shop/editAccount.do"/>">MyPage</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/shop/signoff.do"/>">Log-out</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/shop/searchProducts.do"/>">search</a>
  </li>
</ul>
</c:if>


    </td>
    <td align="left" valign="bottom">
    </td>
  </tr>
  </tbody>
</table>

<header class="intro-header" style="background-image: url('../../images/top_bar.jpg')">
</header>
