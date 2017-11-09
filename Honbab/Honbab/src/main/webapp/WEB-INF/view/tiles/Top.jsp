<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 
<table background="../images/bkg-topbar.gif" border="0" cellspacing="0" cellpadding="5" width="100%">
  <tbody>
  <tr>
    <td><a href="<c:url value="/shop/index.do"/>"><img border="0" src="../images/logo-topbar.gif" /></a></td>
    <td align="right"><a href="<c:url value="/shop/viewCart.do"/>"><img border="0" name="img_cart" src="../images/cart.gif" /></a>
      <img border="0" src="../images/separator.gif" />

<c:if test="${empty userSession.account}" >
      <a href="<c:url value="/shop/signonForm.do"/>"><img border="0" name="img_signin" src="../images/sign-in.gif" /></a>
</c:if>

<c:if test="${!empty userSession.account}" >
      <a href="<c:url value="/shop/signoff.do"/>"><img border="0" name="img_signout" src="../images/sign-out.gif" /></a>
      <img border="0" src="../images/separator.gif" />
      <a href="<c:url value="/shop/editAccount.do"/>"><img border="0" name="img_myaccount" src="../images/my_account.gif" /></a>
</c:if>

      <img border="0" src="../images/separator.gif" /><a href="../help.html"><img border="0" name="img_help" src="../images/help.gif" /></a>
    </td>
    <td align="left" valign="bottom">
      <form action="<c:url value="/shop/searchProducts.do"/>" method="post">
			  <input type="hidden" name="search" value="true"/>
        <input name="keyword" size="14" />&nbsp;<input border="0" src="../images/search.gif" type="image"/>
      </form>
    </td>
  </tr>
  </tbody>
</table>

<%@ include file="IncludeQuickHeader.jsp" %>
 --%>
 
 <!-- Navigation -->
    <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="index.do">honbab</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    
                    <li>
                    	<c:if test="${empty userSession.account}">
							 <a href="<c:url value="/shop/signonForm.do"/>">로그인</a>
        				</c:if>
                    </li>
                    <li>
                    	<c:if test="${empty userSession.account}">
                    		<a href="<c:url value="/shop/newAccount.do"/>">회원가입</a>
                    	</c:if>
                    </li>
                    <li>
                    	<c:if test="${!empty userSession.account}">
							<a href="<c:url value="/shop/editAccount.do"/>"> MyPage</a>
        				</c:if>
                    </li>
                    <li>
                    	<c:if test="${!empty userSession.account}">
							<a href="<c:url value="/shop/signoff.do"/>"> LogOut</a>
        				</c:if>
                    </li>
                    <li>
                        <a href="<c:url value="/shop/searchProducts.do"/>">search</a>
                    </li>
                    <li>
                        <a href="mypage/reservation">reservation</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('../images/home-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading" >
                        <h1>Honbab</h1>
                        <hr class="small">
                        <span class="subheading">혼밥족들을 위한 혼밥 식당 웹사이트</span> <br/>
                         <form action="<c:url value="/shop/searchProducts.do"/>" method="post">
			 				<!--  <input type="hidden" name="search" value="true"/>
        					<input name="keyword" size="14" />&nbsp;<input border="0" src="../images/search.gif" type="image"/> -->
     					 	<div id="custom-search-input">
                				<div class="input-group col-md-12">
                    				<input type="text" name="keyword" class="form-control input-lg" />
                   					<span class="input-group-btn">
                        			<button class="btn btn-info btn-lg">
                            		<i class="glyphicon glyphicon-search"></i>
                        			</button>
                    				</span>
                				</div>
            				</div>
	
     					 </form>
                    </div>
                </div>
            </div>
        </div>
    </header>