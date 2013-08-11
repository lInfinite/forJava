// JavaScript Document
//document.getElementById
function $(id){
	return document.getElementById(id);
	}
//不能用特殊字符和不能为空
function mustAll(id1,id2){
	 var z1=/^[0-9\u4e00-\u9faf\a-z-\A-Z\!\,\.\?]+$/;
	 var i1=$(id1).value;
	 var i2=$(id2);
	 if(i1==null||i1==""){
		 i2.innerHTML="不能为空！！！";
		return false;
	 }else  if(z1.test(i1)==false){
		 i2.innerHTML="不能用特殊字符！！！";
		return false;
	 }else{
		 i2.innerHTML="";
		 return true;
	 }
	}
function mustChar(id1,id2){
	 var z1=/^[0-9\u4e00-\u9faf\a-z-\A-Z\!\,\.\?]+$/;
	 var i1=$(id1).value;
	 var i2=$(id2);
	 if(i1==null||i1==""){
		 i2.innerHTML="";
		return true;
	 }else  if(z1.test(i1)==false){
		 i2.innerHTML="不能用特殊字符！！！";
		return false;
	 }else{
		 i2.innerHTML="";
		 return true;
	 }
}
function mustNotnull(id1,id2){
	 var z2=/^.+$/;
	  if(z2.test(i1)==false){
		 i2.innerHTML="不能为空！！！";
		return false;
	 }else {
		 i2.innerHTML="";
		 return true;
	 }
}
//只能是数字
function mustPhone(id1,id2){
	var i1=$(id1).value;
	var i2=$(id2);
	var num0=/^.+$/;
	var num1=/^\d+$/;
	var num2=/^\d{11,11}$/;
	if(num0.test(i1)==false){
		i2.innerHTML="不能为空！！！";
		return false;
	}else if(num1.test(i1)==false){
		i2.innerHTML="必须是数字！！！";
		return false;
	}else if(num2.test(i1)==false){
	    i2.innerHTML="手机号码长度不正确！！！";
		return false;
	}else{
	    i2.innerHTML="";
		 return true;	
	}
}
function mustPhone2(id1,id2){
	var i1=$(id1).value;
	var i2=$(id2);
	var num0=/^.+$/;
	var num1=/^\d+$/;
	var num2=/^\d{11,11}$/;
	if(num0.test(i1)==false){
		return true;
	}else if(num1.test(i1)==false){
		i2.innerHTML="必须是数字！！！";
		return false;
	}else if(num2.test(i1)==false){
	    i2.innerHTML="手机号码长度不正确！！！";
		return false;
	}else{
	    i2.innerHTML="";
		 return true;	
	}
}
function mustFax(id1,id2){
	var i1=$(id1).value;
	var i2=$(id2);
	var num0=/^.+$/;
	var num1=/^\d+$/;
	var num2=/^\d{8,8}$/;
	if(num0.test(i1)==false){
		return true;
	}else if(num1.test(i1)==false){
		i2.innerHTML="必须是数字！！！";
		return false;
	}else if(num2.test(i1)==false){
	    i2.innerHTML="传真号码长度不正确！！！";
		return false;
	}else{
	    i2.innerHTML="";
		 return true;	
	}
}
function mustNum(id1,id2){
	var i1=$(id1).value;
	var i2=$(id2);
	var num0=/^.+$/;
	var num1=/^\d+$/;
	if(num0.test(i1)==false){
		i2.innerHTML="不能为空！！！";
		return false;
	}else if(num1.test(i1)==false){
		i2.innerHTML="必须是数字！！！";
		return false;
	}else{
	    i2.innerHTML="";
		 return true;	
	}
}
function mustNum2(id1,id2){
	var i1=$(id1).value;
	var i2=$(id2);
	var num0=/^.+$/;
	var num1=/^\d+$/;
	if(num0.test(i1)==false){
		return true;
	}else if(num1.test(i1)==false){
		i2.innerHTML="必须是数字！！！";
		return false;
	}else{
	    i2.innerHTML="";
		 return true;	
	}
}
function mustAge(id1,id2){
	var i1=$(id1).value;
	var i2=$(id2);
	var z=/^\d+$/;
	if(z.test(i1)==false){
	    i2.innerHTML="你输入的不是数字！！！";
	}else if(i1<=0||i1>105){
	    i2.innerHTML="不是正常人年龄！！！";
		return false;
	}else{
	    i2.innerHTML="";
		 return true;	
	}
}
function mustAge2(id1,id2){
	var i1=$(id1).value;
	var i2=$(id2);
	var z=/^\d+$/;
    if(i1!=null||i1!=""){
		 return true;	
	}else if(z.test(i1)==false){
	    i2.innerHTML="你输入的不是数字！！！";
		return false;
	}else if(i1<=0||i1>105){
	    i2.innerHTML="不是正常人年龄！！！";
		return false;
	}else{
	    i2.innerHTML="";
		 return true;	
	}
}
//密码判断
function pass(id1,id2,id3){
	var z=/^.+$/;
	var pass1=$(id1).value;
	var pass2=$(id2).value;	
	var id3=$(id3);
    if(pass1!=pass2){
		id3.innerHTML="密码不同！！！";
		return false;
	}else if(z.test(pass2)==false){
		id3.innerHTML="请先上面输入密码"; 
		return false;
	}else{
	id3.innerHTML="";
		 return true;
	}
}
function pass2(id1,id2,id3){
	var pass1=$(id1).value;
	var pass2=$(id2).value;	
	var id3=$(id3);
    if(pass1!=pass2){
		id3.innerHTML="密码不同！！！";
		return false;
	}else{
	id3.innerHTML="";
		 return true;
	}
}
//提交
function user0(id1,id0,user1,user0,age1,age0,phone1,phone0,textarea1,textarea0){
	var check=false;
	if(mustNum(id1,id0)&&mustChar(user1,user0)&&mustAge(age1,age0)&&mustPhone(phone1,phone0)&&mustChar(textarea1,textarea0)){
		check=true;
	}else{
		check=false;	
	} 

    return check;
}

function user1(pass1,pass0,pass2,pass20){
	var check=false;
	if(mustChar(pass1,pass0)&&pass(pass1,pass2,pass20)){
		check=true;
	}else{
		check=false;	
	} 
    return check;
}

function modify(sum1,sum2,s1,s2,name1,name2,tex1,tex2){
	var check=false;
	if(mustNum(sum1,sum2)&&mustNum(s1,s2)&&mustChar(name1,name2)&&mustChar(tex1,tex2)){
		check=true;
	}
	return check;
}
function modify_0(sum1,sum2,s1,s2,name1,name2,tex1,tex2){
	var check=false;
	if(mustNum2(sum1,sum2)&&mustNum2(s1,s2)&&mustChar(name1,name2)&&mustChar(tex1,tex2)){
		check=true;
	}
	return check;
}
function provider(id1,id0,name1,name0,user1,user0,phone1,phone0,Fax1,Fax0,address1,address0){
	var check=false;
	if(mustNum(id1,id0)&&mustChar(name1,name0)&&mustChar(user1,user0)&&mustPhone(phone1,phone0)&&mustFax(Fax1,Fax0)&&mustChar(address1,address0)){
		check=true;
	}
	return check;
}

function provider_0(id1,id0,name1,name0,textarea,textt,user1,user0,phone1,phone0,Fax1,Fax0,address1,address0){
	var check=false;
	if(mustNum(id1,id0)&&mustChar(name1,name0)&&mustChar(textarea,textt)&&mustChar(user1,user0)&&mustPhone2(phone1,phone0)&&mustFax(Fax1,Fax0)&&mustChar(address1,address0)){
		check=true;
	}
	return check;
}

function userAdd(username1,username2,pass1,pass2,word1,word2,age1,age2,phone1,phone2,address1,address2){
	var check=false;
	if( mustAll(username1,username2)&&mustAll(pass1,pass2)&&pass2(pass1,word1,word2)&&mustAge(age1,age2)&&mustPhone(phone1,phone2)&&mustChar(address1,address2)){
		check=true;
	}
	return check;
	}

function login(id1,id2,id3){
		var check=false;
	if( mustAll(id1,id2)&&mustAll(id3,id2)){
		check=true;
	}
	return check;
	}
//删除确认 
function sureDelete(){
	  var sure=false;
	  sure=confirm("确定删除吗？");
      if(sure==true){
		  sure=true;
	 }else if(sure==false){
		    sure=false;
	}
	return sure;
	
}
//提交表单
   function submitForm(sf){
		document.getElementById(sf).submit();
	}