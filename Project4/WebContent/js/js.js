// JavaScript Document
function Id(id){
	return document.getElementById(id);
}

function showButton(id){
	var len = id.length;
	for(var i=0; i<len; i++){
		if(Id(id[i]).style.display=="block"){
            Id(id[i]).style.display="none";
		}else{
            Id(id[i]).style.display="block";
		}
	}
}

function handelCheckbox(id){
	var len = id.length;
	for(var i=0; i<len; i++){
		if(Id(id[i]).checked==false){
        Id(id[i]).checked=true;		
		}else{
		Id(id[i]).checked=false;
		}
    }
}
function checkedAll(id,bton){
	var ipt = Id(id).getElementsByTagName('input');
	var len = ipt.length;
	var str= document.getElementById(bton).value;
	for(var i=0; i<len; i++){
		if(str=="全选"){
	    ipt[i].checked=true;
		}else if(str="全部选"){
		ipt[i].checked=false;
		}
	}
}



// ajax
function ajax_sell_saveClientExecute(id){
	var sell_client_effect=document.getElementById(id).value;
	alert(sell_client_effect);
	var create_clinet={"effect":sell_client_effect};	
	$.post("ajax_saveClientExecute", 
		   create_clinet,
		   function(date){
			   $("#ShowNames").html(date.u.names);
		   }
	);
} 