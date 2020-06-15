<%@page import="com.bipin.E__COMMERCE.Dto.*"%>
<%@page import="com.bipin.E__COMMERCE.Dao.*" %>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Expires", "0");
	response.setDateHeader("Expires", -1);

	User user = (User) session.getAttribute("current-user");
	System.out.println("user" + user);
	if (user == null) {
		session.setAttribute("message", "please login first");
		response.sendRedirect("login");
		return;
	} else {
		if (user.getType().equals("normal")) {
			session.setAttribute("message", "this page only access by admin");
			response.sendRedirect("login");
		}
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.List" %>
<!-- bootstrap 1 file -->
<%@include file="./shared/bootstrap1.jsp"%>
<style>
body {
	background-image: linear-gradient(to right, #ff5722, #ff9800);
}

.card {
	border: 2px solid red;
}

.card:hover {
	background-color: #e2e2e2;
}

.modal-header {
	background-image: linear-gradient(to right, #ff5722, #ff9800);
}

.modal-body {
	
}
{
}
</style>
</head>
<body>
	<!-- header file -->
	<%@include file="./shared/header.jsp"%>

	<!-- message file -->
	<%@include file="./shared/message.jsp"%>

	<div class="container admin mt-3">
		<!-- row -->
		<div class="row">
			<!-- col 1 -->
			<div class="col-md-4">
				<div class="card text-center text-uppercase">
					<div class="card-header">
						<div class="container ">
							<img style="max-width: 100px;" src="${image}/user.png"
								class="img img-fluid">
						</div>
					</div>
					<div class="card-body">
						<h5>User</h5>
					</div>
				</div>
			</div>
			<!-- col 2 -->
			<div class="col-md-4">

				<div class="card text-center text-uppercase">
					<div class="card-header">
						<div class="container ">
							<img style="max-width: 100px;" src="${image}/product.png"
								class="img img-fluid">
						</div>
					</div>
					<div class="card-body">
						<h5>product</h5>
					</div>
				</div>
			</div>
			<!-- col 3 -->
			<div class="col-md-4">
				<div class="card text-center text-uppercase">
					<div class="card-header">
						<div class="container ">
							<img style="max-width: 100px;" src="${image}/category.png"
								class="img img-fluid">
						</div>
					</div>
					<div class="card-body">
						<h5>category</h5>
					</div>
				</div>
			</div>
		</div>
		<!-- row end -->
	</div>
	<!-- container 1 end -->
	<!-- container 2 -->
	<div class="container mt-2">
		<!-- row 2 -->
		<div class="row">
			<!-- col 1 -->
			<div class="col-md-6" data-toggle="modal" data-target="#product">
				<div class="card text-center text-uppercase">
					<div class="card-header">
						<div class="container ">
							<img style="max-width: 100px;" src="${image}/addproduct.png"
								class="img img-fluid">
						</div>
					</div>
					<div class="card-body">
						<h5>add product</h5>
					</div>
				</div>
			</div>
			<!-- col 2 -->
			<div class="col-md-6" data-toggle="modal" data-target="#exampleModal">
				<div class="card text-center text-uppercase">
					<div class="card-header">
						<div class="container ">
							<img style="max-width: 100px;" src="${image}/addcategory.png"
								class="img img-fluid">
						</div>
					</div>
					<div class="card-body">
						<h5>add category</h5>
					</div>
				</div>
			</div>
			<!-- row end -->
		</div>
		<!-- container 2 end -->
	</div>

	<!-- Modal for category -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<form action="category" method="post">
							<div class="form-group">
								<input class="form-control" type="text" id="title" name="title"
									placeholder="add category name">
							</div>
							<div class="form-group">
								<textarea class="form-control" rows="3"
									placeholder="description" id="description" name="description"></textarea>
							</div>
							<div class="container text-center">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Save</button>
							</div>

						</form>

					</div>


				</div>
			</div>
		</div>
	</div>
	<!-- model category end -->

	<!-- Modal for product -->
	<div class="modal fade" id="product" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<form action="product" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<input class="form-control form-control-sm" type="text"
									id="title" name="title" placeholder=" product title">
							</div>
							<div class="form-group">
								<textarea class="form-control form-control-sm" rows="3"
									placeholder="description" id="description" name="description"></textarea>
							</div>
							<div class="form-group">
								<input class="form-control form-control-sm" type="text"
									id="price" name="price" placeholder=" product price">
							</div>
							<div class="form-group">
								<input class="form-control form-control-sm" type="text"
									id="discount" name="discount" placeholder=" product discount">
							</div>
							<div class="form-group">
								<input class="form-control form-control-sm" type="text"
									id="quantity" name="quantity" placeholder=" product quantity">
							</div>
							<div class="form-group ">
						    <select class="form-control form-control-sm" id="cat" name="cat">
							<%
							CategoryDao d=new CategoryDao();
							List<Category> list=d.getAllCategory();
							for(Category l:list)
							{
							%>
							<option value="<%=l.getcId()%>"><%=l.getcTitle()%></option>
							
							<% 
							  }
							%>
							</select>
							</div>

							<div class="form-group">
							    <label for="file">product photo:</label> 
								<input type="file" class="form-control-file form-control-sm"
									id="file" name="file" multiple>
							</div>
							<div class="container text-center mt-3">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Save</button>
							</div>

						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- model product end -->
	<%@include file="./shared/bootstrap2.jsp"%>
</body>
</html>



