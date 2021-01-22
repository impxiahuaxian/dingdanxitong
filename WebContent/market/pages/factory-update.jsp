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

<body>

	<form action="factory!update.action" method="post">
	<input type="hidden" name="factory.id" value="${factory.id}"/>
	厂商：<input type="text" name="factory.name" value="${factory.name}"/><br>
	姓名：<input type="text" name="factory.linkman" value="${factory.linkman}"/><br>
	电话：<input type="text" name="factory.phone" value="${factory.phone}"/><br>
	地址：<input type="text" name="factory.address" value="${factory.address}"/><br>
	备注：<input type="text" name="factory.remark" value="${factory.remark}"/><br>
	<input type="submit" value="确认修改"/>
	</form>
	
</body>
</html>
