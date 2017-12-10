<%@page import="com.ZeraNanDee.test3.Person"%>
<%@page import="com.ZeraNanDee.test3.Student"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人物：老师和学生</title>
</head>
<body>
	<%
		ServletContext servletContext = request.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		Student student = (Student) context.getBean("student");
		Person person = (Person) context.getBean("person3");
	%>
	学生姓名：<%=student.getName()%><br> 
	学生学号:<%=student.getNumber()%><br>
	学生课程：<%=student.getCourse()%><br> 
	学生成绩:<%=student.getScore()%><br>
	<p>
		老师姓名：<%=person.getName()%><br> 
	    老师学号:   <%=person.getNumber() %><br>
		老师工资:    <%=person.getTeacher().getGongzi()%><br>
</body>
</html>