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
	var ident=document.getElementsByName("vip.ident")[0].value;
	if(ident==null||ident==""){alert("证件不能为空!");return false;}
	return true;
}
</script>
<body>

	<form action="vip!update.action" method="post" onsubmit="return checkForm()">
	<input type="hidden" name="vip.id" value="${vip.id}"/>
	姓名：<input type="text" name="vip.name" value="${vip.name}"/><br>
	性别：<select name="vip.sex" style="width:154px">
			<option value="${vip.sex}"><s:if test="request.vip.sex==1">男</s:if><s:if test="request.vip.sex==0">女</s:if></option><option value="1">男</option><option value="0">女</option></select><br>
	电话：<input type="text" name="vip.phone" value="${vip.phone}"/><br>
	证件：<input type="text" name="vip.ident"  value="${vip.ident}"/><font color="red">*</font><br>
	地址：<input type="text" name="vip.address" value="${vip.address}"/><br>
	<input type="submit" value="确认修改"/>
	</form>
	
</body>
</html>
