<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
 
<script type="text/javascript">

$(document).ready(function () {
    //@naresh action dynamic childs
    
    var next = 0;
    
    $("#add-more").click(function(e){
        e.preventDefault();
        var addto = "#field" + next;
   
        var addRemove = "#field" + (next);
        next = next + 1;
      
        var newIn;
        if(next == 1){
            newIn = ' <div id="field'+ next +'" name="field'+ next +'"><!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="menu_name">Menu Name</label> <div class="col-md-5"> <form:input path="menuList[1].menu_name" id="menu_name" name="menu_name" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br> <!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="price">Price</label> <div class="col-md-5"> <form:input path="menuList[1].price" id="price" name="menu_price" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br><!-- File Button --> <div class="form-group"> <label class="col-md-4 control-label" for="menu_image">Menu Image</label> <div class="col-md-4"> <input id="menufiles[1]" name="menufiles[1]" class="input-file" type="file"> </div></div></div>';        
        }
        else if(next == 2){
            newIn = ' <div id="field'+ next +'" name="field'+ next +'"><!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="menu_name">Menu Name</label> <div class="col-md-5"> <form:input path="menuList[2].menu_name" id="menu_name" name="menu_name" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br> <!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="price">Price</label> <div class="col-md-5"> <form:input path="menuList[2].price" id="price" name="menu_price" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br><!-- File Button --> <div class="form-group"> <label class="col-md-4 control-label" for="menu_image">Menu Image</label> <div class="col-md-4"> <input id="menufiles[2]" name="menufiles[2]" class="input-file" type="file"> </div></div></div>';        
        }
        else if(next == 3){
            newIn = ' <div id="field'+ next +'" name="field'+ next +'"><!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="menu_name">Menu Name</label> <div class="col-md-5"> <form:input path="menuList[3].menu_name" id="menu_name" name="menu_name" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br> <!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="price">Price</label> <div class="col-md-5"> <form:input path="menuList[3].price" id="price" name="menu_price" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br><!-- File Button --> <div class="form-group"> <label class="col-md-4 control-label" for="menu_image">Menu Image</label> <div class="col-md-4"> <input id="menufiles[3]" name="menufiles[3]" class="input-file" type="file"> </div></div></div>';        
        }
        else if(next == 4){
            newIn = ' <div id="field'+ next +'" name="field'+ next +'"><!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="menu_name">Menu Name</label> <div class="col-md-5"> <form:input path="menuList[4].menu_name" id="menu_name" name="menu_name" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br> <!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="price">Price</label> <div class="col-md-5"> <form:input path="menuList[4].price" id="price" name="menu_price" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br><!-- File Button --> <div class="form-group"> <label class="col-md-4 control-label" for="menu_image">Menu Image</label> <div class="col-md-4"> <input id="menufiles[4]" name="menufiles[4]" class="input-file" type="file"> </div></div></div>';        

        }
        else if(next == 5){
            newIn = ' <div id="field'+ next +'" name="field'+ next +'"><!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="menu_name">Menu Name</label> <div class="col-md-5"> <form:input path="menuList[5].menu_name" id="menu_name" name="menu_name" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br> <!-- Text input--><div class="form-group"> <label class="col-md-4 control-label" for="price">Price</label> <div class="col-md-5"> <form:input path="menuList[5].price" id="price" name="menu_price" type="text" placeholder="" class="form-control input-md"/> </div></div><br><br><!-- File Button --> <div class="form-group"> <label class="col-md-4 control-label" for="menu_image">Menu Image</label> <div class="col-md-4"> <input id="menufiles[5]" name="menufiles[5]" class="input-file" type="file"> </div></div></div>';        

        }
        var newInput = $(newIn);
        var removeBtn = '<button id="remove' + (next - 1) + '" class="btn btn-danger remove-me" >Remove</button></div></div><div id="field">';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#field" + next).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next);  
        
            $('.remove-me').click(function(e){
                e.preventDefault();
                var fieldNum = this.id.charAt(this.id.length-1);
                console.log(next);
                var fieldID = "#field" + status;
                $(this).remove();
                $(fieldID).remove();
            });
    });

});

</script>
        <div class="col-xs-12">
            <div class="col-md-12" >
                <h3> Menu</h3>
                <div id="field">
                <div id="field0">
                
             
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="menu_name">Menu Name</label>  
  <div class="col-md-5">
  <form:input path="menuList[0].menu_name" id="menu_name" name="menu_name" type="text" placeholder="" class="form-control input-md"/>
    
  </div>
</div>
<br><br>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Price</label>  
  <div class="col-md-5">
  <form:input path="menuList[0].price" id="price" name="price" type="text" placeholder="" class="form-control input-md"/>
    
  </div>
</div>
<br><br>

<center>
       
       <c:if test="${empty menuList[0].menu_image}">
			<img  width="100px" height="100px" src="../images/add_profile_image.png"/> 
			 <input type="file" id="menufiles[0]" name="menufiles[0]" class="input-file" accept=".png,.jpeg,.jpg">
		</c:if>
	<c:if test="${!empty menuList[0].menu_image}">
		<img width="100px" height="100px" src="${menuList[0].menu_image}" /> 
		 <input type="file" id="menufiles[0]" name="menufiles[0]" class="input-file" accept=".png,.jpeg,.jpg">
	</c:if>
</center>
 

    

<!-- Button -->

<div class="form-group">
  <div class="col-md-4">
    <button id="add-more" name="add-more" class="btn btn-primary">Add More</button>
  </div>
</div>

<br><br>
              
            </div>
        </div>
    