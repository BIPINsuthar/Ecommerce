<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="com.bipin.E__COMMERCE.Dto.*"%>
<%@page import="com.bipin.E__COMMERCE.Dao.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@ include file="./shared/bootstrap1.jsp"%>
<script src="${js}/card.js"></script>
<style>
body {
	background-image: linear-gradient(to right, #ff5722, #ff9800);
}

.card:hover {
	background-color: #e2e2e2;
}

.list:hover {
	background-color: blue;
	color: white;
}
</style>

</head>
<body>
	<%
		HttpSession h = request.getSession();
		ProductDao product = new ProductDao();
		List<Product> pro = product.getAllproduct();

		String cat = request.getParameter("category");
		System.out.println(cat);
		if (cat == null || cat.trim().equals("all")) {
			pro = product.getAllproduct();
		} else {
			int cid = Integer.parseInt(cat.trim());
			pro = product.getAllproductbyId(cid);
		}
	%>
	<!-- header -->
	<header>
		<%@include file="./shared/header.jsp"%>
	</header>
	<section>
		<div class="row mt-4 mx-2">
			<!-- for category -->
			<div class="col-md-2">
				<div class="list-group">
					<a href="demo?category=all"
						class="list-group-item list-group-item-action active">All
						Category</a>
					<%
						CategoryDao categorydao = new CategoryDao();
						List<Category> catlist = categorydao.getAllCategory();
						for (Category c : catlist) {
					%>
					<a href="demo?category=<%=c.getcId()%>"
						class="list list-group-item list-group-item-action"><%=c.getcTitle()%></a>
					<%
						}
					%>
				</div>
			</div>
			<!-- for product  -->

			<div class="col-md-8">

				<div class="row">
					<div class="container">
						<div class="card-columns">
							<%
								for (Product p : pro) {
							%>
							<div class="card">
								<div class="card-body">
									<img class="card-img-top img img-fluid"
										src="${product}/<%=p.getpPhoto()%>"
										style="height: 230px; width: 230px;">
									<h5 class="card-title"><%=p.getpTitle()%></h5>
									<p class="card-text"><%=p.getpDesc()%></p>
								</div>
								<div class="card-footer">
									<div class="container">
										<button class="btn btn-success"
											onclick="insertcart(<%=p.getpId()%>,'<%=p.getpTitle()%>',<%=p.getpPrice()%>)">AddCard</button>
										<button class="btn btn-outline-primary">
											&#X20B9;<%=p.getpPrice()%></button>
									</div>
								</div>
							</div>
							<%
								}
								if (pro.size() == 0) {
									h.setAttribute("message", "no item in this category!!");
								}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@include file="./shared/bootstrap2.jsp"%>
	<%@include file="./shared/cart_modal.jsp"%>
</body>
</html>