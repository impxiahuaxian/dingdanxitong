<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
	var name=document.getElementsByName("emp.name")[0].value;
	var phone=document.getElementsByName("emp.pass")[0].value;
	var ident=document.getElementsByName("emp.type")[0].value;
	if(name==null||name==""){alert("姓名不能为空!");return false;}
	if(phone==null||phone==""){alert("密码不能为空!");return false;}
	if(ident==null||ident==""){alert("职位不能为空!");return false;}
	return true;
}
</script>
<body>

	<form action="emp!update.action" method="post" onsubmit="return checkForm()">
	<input type="hidden" name="emp.id" value="${emp.id}"/>
	姓名：<input type="text" name="emp.name" value="${emp.name}"/><font color="red">*</font><br>
	密码：<input type="text" name="emp.pass" value="${emp.pass}"/><font color="red">*</font><br>
	职位：<select name="emp.type" style="width: 155px">
				<option value="${emp.type}">
					<s:if test="request.emp.type==1">经理</s:if>
					<s:if test="request.emp.type==2">库管</s:if>
					<s:if test="request.emp.type==3">员工</s:if>
				</option>
				<option value="1">经理</option>
				<option value="2">库管</option>
				<option value="3">员工</option>
			</select><br>
	性别：<select name="emp.sex" style="width: 155px">
				<option value="${emp.sex}">
					<s:if test="request.emp.sex==1">男</s:if>
					<s:if test="request.emp.sex==0">女</s:if>
				</option>
				<option value="1">男</option>
				<option value="0">女</option>
			</select><br>
	年龄：<input type="text" name="emp.age" value="${emp.age}"/><br>
	电话：<input type="text" name="emp.phone" value="${emp.phone}"/><br>
	备注：<input type="text" name="emp.remark" value="${emp.remark}"/><br>
	<input type="submit" value="确认修改"/>
	</form>
	
</body>
</html>
