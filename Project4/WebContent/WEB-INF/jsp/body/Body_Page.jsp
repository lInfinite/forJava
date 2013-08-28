<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
        <span>共<s:property value="page.list_size"/>条记录</span>
        <span>每页<input readonly class="page" type="text" style="width:30px;" value='<s:property value="page.max_results"/>' />条</span>
        <span>第<input readonly class="page" type="text" style="width:30px;" value='<s:property value="page.page+1"/>' />页/共<s:property value="page.end"/>页</span>
        <span>
            <a id="top" onClick="page('top')">第一页</a>
            <a id="back" onClick="page('back')">上一页</a>
            <a id="next" onClick="page('next')">下一页</a>
            <a id="end" onClick="page('end')">最后一页</a>
            <input id="page" type="hidden" name="page.page" value="0"/>
            <script type="text/javascript">
                function page(id){
					var page = document.getElementById("page");
				    var str = document.getElementById(id).innerHTML;	
					if(str=="第一页"){
					    page.value=0;
					}else if(str=="上一页"){
						if(<s:property value="page.back"/> >0){
							page.value=<s:property value="page.back"/>;
					    }else{
						    page.value=0;
						}
					}else if(str=="下一页"){
						if(<s:property value="page.next"/> < <s:property value="page.end"/>){
							page.value=<s:property value="page.next"/>;
						}else{
							page.value=<s:property value="page.end"/>;
						}
					}else if(str=="最后一页"){
					    page.value=<s:property value="page.end"/>;
					}
					document.getElementsByTagName("form").item(0).submit();
				}
            </script>
        </span>
        <span>转到第<input id="gotopage" class="page" type="text" style="width:30px;"/>页<input type="button" onClick="goto_page()" value="GO"/></span>
        <script type="text/javascript">
            function goto_page(){
				document.getElementById("page").value = document.getElementById("gotopage").value-1;
			    
				document.getElementsByTagName("form").item(0).submit();
			}
        </script>
        
</div>
