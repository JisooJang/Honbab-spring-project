<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
 <style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}


.container {
    padding: 16px;
}

span.password {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.password {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<link href="../resources/css/login.css" rel="stylesheet">

<c:if test="${!empty message}">
  <b><font color="RED"><c:url value="${message}"/></font></b>
</c:if>

<%-- <form action="<c:url value="/shop/signon.do"/>" method="POST"> --%>

<c:if test="${!empty signonForwardAction}">
<input type="hidden" name="forwardAction" value="<c:url value="${signonForwardAction}"/>"/>
</c:if>

<%-- <div class="container">

<table align="center" border="0">
<tr>
<td colspan="2">
<br />&nbsp;</td>
</tr>
<tr>
<td> <label>UserID:</label></td>
<td><input type="text" name="username" value="j2ee" /></td>
</tr>
<tr>
<td> <label>Password:</label></td>
<td><input type="password" name="password" value="j2ee" /></td>
</tr>
<tr>
<td>
<a href="<c:url value="/shop/newAccount.do"/>">
<button type="button">Register </button>
</a>
</td>
<td>
<button type="submit" name="update" >Login</button>
</td>
</tr>
</table>
</div> --%>

<script>

function showPassword() {
    
    var key_attr = $('#password').attr('type');
    
    if(key_attr != 'text') {
        
        $('.checkbox').addClass('show');
        $('#password').attr('type', 'text');
        
    } else {
        
        $('.checkbox').removeClass('show');
        $('#password').attr('type', 'password');
        
    }
        
}

</script>


<section id="login">
    <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
                <h1>Honbab</h1>
                    <form role="form" action="<c:url value="/shop/signon.do"/>" method="post" id="login-form" autocomplete="off">
                        <div class="form-group">
                            <label for="userID" class="sr-only">UserID</label>
                            <input type="text" name="username" id="username" class="form-control" placeholder="userID">
                        </div>
                        <div class="form-group">
                            <label for="password" class="sr-only">Password</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="checkbox">
                            <span class="character-checkbox" onclick="showPassword()"></span>
                            <span class="label">Show password</span>
                        </div>
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Log in">
                    </form>
                    <a href="javascript:;" class="forget" data-toggle="modal" data-target=".forget-modal">Forgot your password?</a>
                    <hr>
        	    </div>
    		</div> <!-- /.col-xs-12 -->
    	</div> <!-- /.row -->
    </div> <!-- /.container -->
</section>

<div class="modal fade forget-modal" tabindex="-1" role="dialog" aria-labelledby="myForgetModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span>
					<span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">Recovery password</h4>
			</div>
			<div class="modal-body">
				<p>Type your email account</p>
				<input type="email" name="recovery-email" id="recovery-email" class="form-control" autocomplete="off">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-custom">Recovery</button>
			</div>
		</div> <!-- /.modal-content -->
	</div> <!-- /.modal-dialog -->
</div> <!-- /.modal -->

<!-- </form> -->

<center>

</center>

