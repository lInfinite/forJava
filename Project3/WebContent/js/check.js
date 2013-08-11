// JavaScript Document
function $id(id){
	return document.getElementById(id);
	}
	
	
function notNull(id1,output){
	 var i1 = $id(id1).value;
	 var out = $id(output);
	 if(i1 == null || i1 == ""){
		 out.innerHTML = "不能为空！！！";
		return false;
	 }else{
		 out.innerHTML = "";
		 return true;
	 }
 }


 function char(id1,output){
	 var i1 = $id(id1).value;
	 var out = $id(output);
     var z1 = /^[0-9\u4e00-\u9faf\a-z-\A-Z\!\,\.\?]+$/;
	 if(z1.test(i1) == false){
		 out.innerHTML = "不能用特殊字符！！！";
		return false;
	 }else{
		 out.innerHTML = "";
		 return true;
	 }
 }
 
 
 function number(id1,output){
 	var i1 = $id(id1).value;
 	var out =$id(output);
 	var isNumber = /^\d+$/;
 	if(isNumber.test(i1)){
        out.innerHTML = "只能是数字";
		return false;
 	}else{
        out.innerHTML = "";
        return true;
 	}
 }
 

function phone(id1,output){
    var i1 = $id(id1).value;
    var out = $id(output);
    var isPhone = /^\d{11,11}$/;
    if(isPhone.test(i1) == false){
        out.innerHTML = "号码长度不正确";
		return false;
    }else{
        out.innerHTML = "";
        return true;
    }
}


function sex(id1,output){
	var i1 = $id(id1).value;
	var out = $id(output);
	if(i1 == "男" || i1 == "女"){
        out.innerHTML = "";
        return true;
	}else{
        out.innerHTML = "性别只能是男或女";
		return false;
	}
} 


function age(id1,output){
    var i1 = $id(id1).value;
    if(i1>0 || i1<200 || i1==""){
    	out.innerHTML = "";
    	return true;
    }else{
        out.innerHTML = "请输入正常人的年龄";
        return false;
    }
}


function checkTime(id1,output){
    var d = /^[0-9]*-*[0-9]*-*[0-9]+$/;
	var time = document.getElementById(id1).value;
	if(d.test(time) == false){
	    document.getElementById(output).innerHTML="时间格式为: XXXX-XX-XX";
	}else{
	    document.getElementById(output).innerHTML="";
	}
}


 function notNullAndChar(id1,output){
	  if(notNull(id1,output) ==true  && char(id1,output) ==true){
	      return true;
	  }else{
		  return false;  
	  }
 }
 
 


 function submit_1(id1){
	 var tf = true;
	 if( document.getElementById(id1).value ==false){
		 tf = false;
      }
		 alert("请正确输入表单！");
     return tf;
 }
 
 function submit_2(id1,id2){
	 var tf = true;
	 if($(id1).value ==false || $(id2).value ==false){
		 tf = false;
		 alert("请正确输入表单！");
      }
     return tf;
 }
 
   function submit_4(id1,id2,id3,id4){
	 var tf = true;
	 if($(id1).value ==false || $(id2).value ==false || $(id3).value ==false || $(id4).value ==false){
		 tf = false;
		 alert("请正确输入表单！");
      }
     return tf;
 }
 
  function submit_5(id1,id2,id3,id4,id5){
	 var tf = true;
	 if($(id1).value ==false || $(id2).value ==false || $(id3).value ==false || $(id4).value ==false || $(id5).value ==false){
		 tf = false;
		 alert("请正确输入表单！");
      }
     return tf;
 }