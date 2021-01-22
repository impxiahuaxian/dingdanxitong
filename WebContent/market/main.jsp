<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>超市进销存系统</title>
</head>
<frameset rows="52,*,23" frameborder="no" border="0" framespacing="0">
  <frame src="market/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frame src="market/center.jsp" name="centerFrame" id="mainFrame" />
  <frame src="market/down.jsp" name="downFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>