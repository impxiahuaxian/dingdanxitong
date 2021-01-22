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

<body><br><br>

	<form action="card!add.action" method="post">
	会员编号：<input type="text" name="vip_id"/>
	<input type="submit" value="创建会员账单"/>
	</form><br><br><br>
	
	<form action="card!add.action" method="post">
	普通顾客：<input type="text" name="card.remark"/>
	<input type="submit" value="创建普通账单"/>
	</form>
	
</body>
</html>
