<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<section class="jumbotron text-center">
		<div class="container">
			<h1 class="jumbotron-heading">PRODUCT DETAIL</h1>
			<p class="lead text-muted mb-0">CHI TIẾT SẢN PHẨM</p>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/">Home</a></li>
						<li class="breadcrumb-item"><a href="category.html">Category</a></li>
						<li class="breadcrumb-item active" aria-current="page">Product</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<!-- Image -->
			<div class="col-12 col-lg-6">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<a href="" data-toggle="modal" data-target="#productModal"> <img
							class="img-fluid" src=${detail.images } />
							<p class="text-center">Zoom</p>
						</a>
					</div>
				</div>
			</div>

			<!-- Add to cart -->
			<div class="col-12 col-lg-6 add_to_cart_block">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<p class="price">$ ${detail.price}</p>
						<!-- <p class="price_discounted">0 đ </p> -->
						<form method="get" action="${pageContext.request.contextPath}/addcartitemondetail">
							<div class="form-group">
								<label for="colors">SIZE</label> <select class="custom-select"
									id="colors">
									<option value="0">38</option>
									<option value="1">39</option>
									<option value="2">40</option>
									<option value="3">41</option>
								</select>
							</div>
							<div class="form-group">
								<label>Quantity :</label>
								<div class="input-group mb-3">
									<!-- <div class="input-group-prepend">
										<button type="button"
											class="quantity-left-minus btn btn-danger btn-number"
											data-type="minus" data-field="">
											<i class="fa fa-minus"></i>
										</button>
									</div>	 -->
																	
									<input type="number" class="form-control"
										name="quantity2" min="1" max="100" value="1">
										<input type="hidden" class="form-control"
										name="productid" value="${detail.productId }">
										<input type="hidden" class="form-control"
										name="price" value="${detail.price }">
									<!-- <div class="input-group-append">
										<button type="button"
											class="quantity-right-plus btn btn-success btn-number"
											data-type="plus" data-field="">
											<i class="fa fa-plus"></i>
										</button>
									</div> -->
								</div>
							</div>
							<%-- <a href="${pageContext.request.contextPath}/addcartitemondetail?productid=${detail.productId}&price=${detail.price}"
								class="btn btn-success btn-lg btn-block text-uppercase"> <i
								class="fa fa-shopping-cart"></i> Add To Cart
								
							</a> --%>
							<button class="btn btn-lg btn-block btn-success text-uppercase">ĐẶT HÀNG</button>
					<!-- 	</form> -->
						<div class="product_rassurance">
							<ul class="list-inline">
								<li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br />Fast
									delivery</li>
								<li class="list-inline-item"><i
									class="fa fa-credit-card fa-2x"></i><br />Secure payment</li>
								<li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br />+33
									1 22 54 65 60</li>
							</ul>
						</div>
						<div class="reviews_product p-3 mb-2 ">
							3 reviews <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> (4/5) <a class="pull-right"
								href="#reviews">View all reviews</a>
						</div>
						<div class="datasheet p-3 mb-2 bg-info text-white">
							<a href="" class="text-white"><i class="fa fa-file-text"></i>
								Download DataSheet</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<!-- Description -->
			<div class="col-12">
				<div class="card border-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-align-justify"></i> Description
					</div>
					<div class="card-body">
						<p class="card-text">${detail.description}</p>
						<p class="card-text"></p>
					</div>
				</div>
			</div>

			<!-- Reviews -->
			<div class="col-12" id="reviews">
				<div class="card border-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-comment"></i> Reviews
					</div>
					<div class="card-body">
						<div class="review">
							<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
							<meta itemprop="datePublished" content="01-01-2016">
							January 01, 2018 <span class="fa fa-star"></span> <span
								class="fa fa-star"></span> <span class="fa fa-star"></span> <span
								class="fa fa-star"></span> <span class="fa fa-star"></span> by
							Paul Smith
							<p class="blockquote">
							<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
								adipiscing elit. Integer posuere erat a ante.</p>
							</p>
							<hr>
						</div>
						<div class="review">
							<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
							<meta itemprop="datePublished" content="01-01-2016">
							January 01, 2018 <span class="fa fa-star" aria-hidden="true"></span>
							<span class="fa fa-star" aria-hidden="true"></span> <span
								class="fa fa-star" aria-hidden="true"></span> <span
								class="fa fa-star" aria-hidden="true"></span> <span
								class="fa fa-star" aria-hidden="true"></span> by Paul Smith
							<p class="blockquote">
							<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
								adipiscing elit. Integer posuere erat a ante.</p>
							</p>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	


	<!-- Modal image -->
	<div class="modal fade" id="productModal" tabindex="-1" role="dialog"
		aria-labelledby="productModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="productModalLabel">Product title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<img class="img-fluid"
						src="https://dummyimage.com/1200x1200/55595c/fff" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"></script>
	
	
	
</body>
</html>