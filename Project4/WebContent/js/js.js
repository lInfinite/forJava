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
function ajax_sell_saveClientExecute(effect,id,show){
	var sell_client_effect=document.getElementById(effect).value;
	var sell_client_id=document.getElementById(id).value;
	var create_clinet = {"create_clinet.id":sell_client_id,"create_clinet.effect":sell_client_effect}	
	$.post("ajax_saveClientExecute", 
		   create_clinet,
		   function(date){
			   document.getElementById(show).innerHTML=date.create_clinet.effect;
		   }
	);
} 