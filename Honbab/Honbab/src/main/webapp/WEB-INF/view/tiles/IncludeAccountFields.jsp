<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<center><h3>Account Information</h3></center>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>  
  <div class="col-md-4">
  <form:input path="account.name" type="text" placeholder="Enter your name" class="form-control input-md"/>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="gender">Gender</label>  
  <div class="col-md-4">
  <form:select  path="account.gender" class="form-control" items="${genders}"/>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>  
  <div class="col-md-4">
  <form:input path="account.email" type="email" placeholder="Enter your email" class="form-control"/>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="phone">Phone</label>  
  <div class="col-md-4">
  <form:input path="account.phone" type="text" placeholder="Enter your phone" class="form-control input-md"/>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address</label>  
  <div class="col-md-4">
  <form:input path="account.address" type="text" placeholder="Enter your address" class="form-control input-md"/>
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="type">Type</label>  
  <div class="col-md-4">
  <form:select  path="account.type" class="form-control" items="${types}"/>
  </div>
</div>


