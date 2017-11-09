<%@ page contentType="text/html" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<table border="0" cellspacing="0" width="100%">
  <tbody>
  <tr>
    <td valign="top" width="100%">

      <table align="left" border="0" cellspacing="0" width="80%">
        <tbody>
        <tr>
          <!-- <td valign="top"> -->
          <td> 

            <!-- SIDEBAR -->

            <table bgcolor="#EAEAEA" border="0" cellspacing="0" cellpadding="5" width="200">
              <tbody>
      <tr>
      <td>
        <c:if test="${!empty userSession.account}">
					<b><i><font size="2" color="BLACK">Welcome <c:out value="${userSession.account.firstName}"/>!</font></i></b>
        </c:if>
        &nbsp;
      </td>
      </tr>
              
              <tr>
                <td>
                <a href="<c:url value="/shop/searchProducts.do"/>">
                Search Restaurant</a>
                </td>
              </tr>
              
              <tr>
              <td>
              <a href="mypage/reservation">My Reservation List</a>
              </td>
              </tr>
              <tr>
              <td>
              <a href="mypage/ticketList">My Ticket List</a>
              </td>
              </tr>
				<tr>
              	<td>
              	 <a href="<c:url value="/shop/newRestr.do"/>">
                	Register Restaurant</a>
              	</td>
              </tr>
              <tr>
              	<td>
              	 <a href="<c:url value="/shop/rankingRestr.do"/>">
                	Ranking Restaurant</a>
              	</td>
              </tr>
              <tr>
              	<td>
              	<c:if test="${!empty userSession.account}">
					<a href="<c:url value="/mypage.do"/>">
                	MyPage</a>
        		</c:if>
              </tbody>
             </table>

          <!-- <td align="center" bgcolor="white" height="300" width="100%">

          MAIN IMAGE

          <map name="estoremap"><area alt="Birds" coords="72,2,280,250" href="viewCategory.do?categoryId=BIRDS" shape="RECT" />
          <area alt="Fish" coords="2,180,72,250" href="viewCategory.do?categoryId=FISH" shape="RECT" />
          <area alt="Dogs" coords="60,250,130,320" href="viewCategory.do?categoryId=DOGS" shape="RECT" />
          <area alt="Reptiles" coords="140,270,210,340" href="viewCategory.do?categoryId=REPTILES" shape="RECT" />
          <area alt="Cats" coords="225,240,295,310" href="viewCategory.do?categoryId=CATS" shape="RECT" />
          <area alt="Birds" coords="280,180,350,250" href="viewCategory.do?categoryId=BIRDS" shape="RECT" />
          
         </map>
          <img border="0" height="355" src="../images/splash.gif" align="center" usemap="#estoremap" width="350" />
          </td></tr></tbody></table></td></tr> -->
          
          <!-- <td>
          <img border="0" src="../images/honbab.png" align="center" /></td></tr> -->  
          
		</td></tr>
          
          </table>

        </tbody>
        
        <table align="center" cellspacing="20">
        <tr align="center">
        <td colspan="3"><h3>Top3 reserved restaurant</h3></td>
        </tr>
		<tr>
			<div class="card-deck">	
          <c:forEach var="restr" items="${restr2}">
          <td>
  			<div class="card">
    		<img class="card-img-top" width="300" height="270" src="${restr.rest_thumbnail}" alt="Card image cap">
   			 <div class="card-block">
      			<h4 class="card-title">${restr.rest_name}</h4>
      			<p class="card-text">address : ${restr.rest_addr}</p>
      			<p class="card-text">tel : ${restr.rest_phone}</p>
					<a href="../restrDetail.do/${restr.rest_id}"><button type="button" class="btn btn-default">details</button></a>
    		</div>
			</div> 
			</td>
			<td>   </td>
		</c:forEach>
		</div>
		</tr>
		</table>
		
        </table>
        
      
