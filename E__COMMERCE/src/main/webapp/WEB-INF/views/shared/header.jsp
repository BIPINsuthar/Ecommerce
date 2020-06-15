<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.bipin.E__COMMERCE.Dto.User"%>
<%
	User u = (User) session.getAttribute("current-user");
%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg   mt-auto"> <a
		class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto mr-2  ">
			<li class="nav-item active "><a class="nav-link text-info "
				href="${contextRoot}/home">Home <span class="sr-only">(current)</span></a>
			</li>
	
			<li class="nav-item"><a class="nav-link"
				href="${contextRoot}/admin">admin</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${contextRoot}/login">about us</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${contextRoot}/registration">registration</a></li>
				<li class="nav-item mr-2">
				<a class="nav-link" data-toggle="modal" data-target="#cart" href="#"><i class="fa fa-cart-plus" style="font-size:25px; color:yellow;"></i><span  style="font-size:20px;color:yellow;margin-top:-10px;" class="card-item">( )</span></a>
				</li>
			<%
				if (u == null) {
			%>
			<li><a href="${contextRoot}/login"><button
						class="btn btn-outline-primary">Login</button></a></li>
			<%
				} else {
			%>
			<li><a href="${contextRoot}/logout"><button
						class="btn btn-outline-warnning">Logout</button></a></li>
			<!--<li><a href="${contextRoot}/#"> </a></li> -->
			<!-- Button trigger modal -->
			<li data-toggle="modal" data-target="#profile"><a href="#"><button class="btn btn-info"><%=u.getFname() %></button></a></li>
			<%
				}
			%>

	      </ul>
		
	</div>
		<!-- Modal for profile-->
	<div class="modal fade" id="profile" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">profile</h5>
					  <div class="container text-center">
				     <img src="${image}/login.jpeg" class="img img-fluid" style="max-width:130px;">
				     </div>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				    <div class="container">
				     
				   <form class="">
				     <div class="form-group">
				       <input class="form-control" type="text" id="name" name="name" placeholder="add category name">
				     </div>
				     <div class="form-group">
				       <input class="form-control" type="text" id="name" name="name">
				     </div>
				     <div class="form-group">
				       <input class="form-control" type="text" id="name" name="name">
				     </div>
				     <div class="form-group">
				       <input class="form-control" type="text" id="name" name="name">
				     </div>
				   </form>
				   </div>
				
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	<!-- model end -->

	</nav>
    
</body>
</html>