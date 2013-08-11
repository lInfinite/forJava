// JavaScript Document
$(document).ready(
    function(){
    	$("#msg_save").bind("click",function(){
            var msg_names=$("#msg_name").val();
			var msg_age=$("#msg_age").val();
			var msg_sex=$("#msg_sex").val();
			var msg_phone=$("#msg_phone").val();
			var msg_address=$("#msg_address").val();
			var user =  {"user.names":msg_names,
			             "user.age":msg_age,
			             "user.sex":msg_sex,
			             "user.phone":msg_phone,
			             "user.address":msg_address,
						 };
			$.post("ajax_update", user, function(date){
						                     $("#ShowNames").html(date.u.names);
					                   }
			);
			
        } );
    }
);


$(document).ready(
	    function(){
	        $("#manager1_save").bind("click",function(){
	             var manager1_name=$("#manager1_name").val();
	 			var manager1_password=$("#manager1_password").val();
	 			var user =  {"user.name":manager1_name,
	 			             "user.password":manager1_password
	 						 };
	 			$.post("ajax_change", user, function(date){
	 						                     $("#manager1_name").val(date.u.name);
	 						                     $("#manager1_password").val(date.user.password);
	 					                   }
	 			);
	 			
	         } );
	     }
);




/*<!--msg.jsp-->*/
function msg_show(){
	document.getElementById("msg_set").style.display="block";
	document.getElementById("msg_save").style.display="none";
	document.getElementById("msg_back").style.display="none";
}
function msg_setit(){
	document.getElementById("msg_set").style.display="none";
	document.getElementById("msg_save").style.display="block";
	document.getElementById("msg_back").style.display="block";
	
	document.getElementById("msg_name").readOnly=null;
	document.getElementById("msg_age").readOnly=null;
	document.getElementById("msg_sex").readOnly=null;
	document.getElementById("msg_phone").readOnly=null;
	document.getElementById("msg_address").readOnly=null;
}
function msg_saveit(){
	msg_show();	
}
function msg_comeback(){
	msg_show();
	document.getElementById("msg_name").value=name;
	document.getElementById("msg_age").value=age;
	document.getElementById("msg_sex").value=sex;
	document.getElementById("msg_phone").value=phone;
	document.getElementById("msg_address").value=address;
}

/*manager1*/
function manager1_show(){
	document.getElementById("manager1_set").style.display="block";
	document.getElementById("manager1_save").style.display="none";
	document.getElementById("manager1_back").style.display="none";
}
function manager1_setit(){
	document.getElementById("manager1_set").style.display="none";
	document.getElementById("manager1_save").style.display="block";
	document.getElementById("manager1_back").style.display="block";
	
	document.getElementById("manager1_name").readOnly=null;
	document.getElementById("manager1_password").readOnly=null;
}
function manager1_saveit(){
	manager1_show();	
}
function manager1_comeback(){
	manager1_show();
	document.getElementById("manager1_name").value = name;
	document.getElementById("manager1_password").value = password;
}


/*mail_check*/



