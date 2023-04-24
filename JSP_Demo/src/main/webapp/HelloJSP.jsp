<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HELLO JSP</title>
</head>
<body>
<h1>Hello JSP world</h1>
<%! String name(){ 
	return "Prem";
	}
%>
<%=name()%>
<%
	for(int i=0;i<3;i++){
		out.print("<br/>");
		out.print(i);
	}
%>
</body>
</html>