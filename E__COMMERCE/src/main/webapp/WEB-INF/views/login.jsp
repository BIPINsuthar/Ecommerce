<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@page import="com.bipin.E__COMMERCE.Dto.*"%>
	<%
	   response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	   response.setHeader("pragma", "no-cache");
	   response.setHeader("Expires","0");
	   response.setDateHeader("Expires", -1); 
	%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="image" value="/resources/images" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<%@include file="./shared/bootstrap1.jsp" %>
<link rel="stylesheet" href="${css}/login.css" type="text/css">
<script src="${js}/login.js" type="text/javascript"></script>

<!--  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${css}/bootstrap.css" rel="stylesheet">
<script src="${js}/bootstrap.js" type="text/javascript"></script>
<link rel="stylesheet" href="${css}/login.css" type="text/css">
<script src="${js}/login.js" type="text/javascript"></script>
-->
</head>
<body>
	<!-- header file -->
	<header> 
	<%@include file="./shared/header.jsp"%>
	</header>
	<!-- section no.1 -->
	<section>
		<div class="container text-center">
			<div class="card ml-5 " style="width:500px">
			    <div class="container">
				<image style="max-width:150px;"src="${image}/man.png" class="img img-fluid" />  
				</div>
				<div class="card-body">
					<%@ include file="./shared/message.jsp"%>
					<form action="loginpage" onsubmit="return validate()" method="post">
						<div class="row  text-center justify-content-md-center">
							<div class="form-group col-lg-9 col-12 ">
								<input class="form-control" autocomplete="off" type="text" id="user"
									name="user" placeholder="enter Email ">
							</div>
							<div class="form-group col-lg-9 col-12 ">
								<input class="form-control " type="password" name="pass" id="pass"
									placeholder="enter password">
							</div>
							<div class="form-group col-lg-4 pt-2">
								<button class="btn btn-success">LOGIN</button>
							</div>
							 <div class="form-group col-lg-9 col-12  ">
								<a href="#">Forgot Password</a>
							</div>
							<div class="form-group col-lg-9 col-12 ">
								<a href="registration">New User? Registration</a>
							</div>
						</div>
					</form>
					
				</div>
			</div>
		</div>
	</section>
	</body>
	<%@ include file="./shared/bootstrap2.jsp" %>
</html>

