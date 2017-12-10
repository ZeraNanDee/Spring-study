<%@page import="com.ZeraNanDee.test2.HelloBean"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//通过web利用Spring案例,tomcat启动时默认调用配置文件web.xml内的applicationContext.xml的Spring配置文件 
		ServletContext servletContext = request.getServletContext();//通过request对象获取web服务器
		WebApplicationContext webApplicationContext;//利用Spring的静态方法，从web服务器中获取Spring容器 
		webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		HelloBean student = (HelloBean) webApplicationContext.getBean("hasp");
	%>
	姓名：<%=student.getName()%><br> 课程名：<%=student.getCourse()%><br>
	成绩：<%=student.getScore()%><br>
</body>
</html>