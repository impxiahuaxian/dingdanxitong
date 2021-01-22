<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function checkForm(){
	var name=document.getElementsByName("goods.name")[0].value;
	var phone=document.getElementsByName("goods.type")[0].value;
	var ident=document.getElementsByName("goods.price")[0].value;
	if(name==null||name==""){alert("商品名不能为空!");return false;}
	if(phone==null||phone==""){alert("类型不能为空!");return false;}
	if(ident==null||ident==""){alert("单价不能为空!");return false;}
	return true;
}
</script>
<body>

	<form action="goods!update.action" method="post" onsubmit="return checkForm()">
			<input type="hidden" name="goods.id" value="${goods.id}"/>
	商品：<input type="text" name="goods.name" value="${goods.name}"/><font color="red">*</font><br>
	类型：<input type="text" name="goods.type" value="${goods.type}"/><font color="red">*</font><br>
	单价：<input type="text" name="goods.price" value="${goods.price}"/><font color="red">*</font><br>
	产日：<input type="text" name="goods.start" value="${goods.start}"/>(2012-01-01)<br>
	保质：<input type="text" name="goods.keep" value="${goods.keep}"/>(单位:月)<br>
	产地：<input type="text" name="goods.place" value="${goods.place}"/>(北京)<br>
	厂商：<select name="goods.factory.id" style="width: 150px">
				<option value="${goods.factory.id}">${goods.factory.name}</option>
				<s:iterator value="#request.factories">
					<option value="<s:property value='id'/>"><s:property value='name'/></option>
				</s:iterator>
			</select><br>
	备注：<input type="text" name="goods.remark" value="${goods.remark}"/><br>
	<input type="submit" value="确认修改"/>
	</form>
	
</body>
</html>
