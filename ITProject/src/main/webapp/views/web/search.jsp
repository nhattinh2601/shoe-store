<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>



<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">K&T SHOP SEARCH</h1>
		<p class="lead text-muted mb-0">Có rất nhiều lựa chọn dành cho bạn</p>
	</div>
</section>
<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">						
					<li class="breadcrumb-item"><a>Các kết quả tìm kiếm của "${txtname}"</a></li>
					<!-- <li class="breadcrumb-item"><a href="category">Category</a></li>
					<li class="breadcrumb-item active" aria-current="page">Sub-category</li> -->
				</ol>
			</nav>
		</div>
	</div>
</div>
 <div class="container">
	<div class="row">
		<div class="col-12 col-sm-0">
			<%-- <div class="card bg-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-list"></i> Categories
				</div>
				<ul class="list-group category_block">
					<core:forEach items="${allcategory}" var="o">
		
						<li class="list-group-item ${cid==o.cateId? 'active':''} "><a href="productbycategory?cid=${o.cateId}"	 >${o.cateName}</a></li>
					</core:forEach>
				</ul>
			</div> --%>
			<div class="card bg-light mb-3">
				<%--<div class="card-header bg-success text-white text-uppercase">Last
					product</div>
				 <div class="card">
					<img class="img-fluid border-0" src="${top1.image}"
						alt="Card image cap">
					<div class="card-body">
						<h4 class="card-title text-center">
							<a href="productdetail" title="View Product">${top1.productName}</a>
						</h4>
						<div class="row">
							<div class="col">
								<p class="btn btn-danger btn-block">${top1.price} đ</p>
							</div>
							<div class="col">
								<a href="productdetail" class="btn btn-success btn-block">View</a>
							</div>
						</div>
					</div>
				</div> --%>
			</div>
		</div>


		<div class="col">
			<div class="row">

				<core:forEach items="${list}" var="o">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.images}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="${pageContext.request.contextPath}/product/detail?pid=${o.productId}" title="View Product">${o.productName}</a></h4>
                                        <p class="card-text show_txt">Giá tốt</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.price} đ</p>
                                            </div>
                                            <div class="col">
                                                <a href="${pageContext.request.contextPath}/cart/add?productid=${o.productId}&price=${o.price}" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </core:forEach>

			














			</div>
			<nav aria-label="Page navigation example">
			<ul class="pagination">
			<core:forEach begin ="1" end="${numpage}" var="i"> 
				<li class="page-item"><a class="page-link" href="category?index=${i}"${index==i? "style=\"color: red;\"":""}>${i}</a></li>
			</core:forEach>

			</ul>
		</nav>
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
			<!-- JS -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"
			type="text/javascript"></script>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
			</script><script
src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript">
		</script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
			type="text/javascript"></script>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	
	
	
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	
	<script>
	
		$(window).scroll(
				function() {
					if ($(window).scrollTop() + $(window).height() >= $(
							document).height()) {
						loadMore();
					}
				}); 
		function loadMore() {
			var amount = document.getElementsByClassName("product").length;
			$.ajax({
				url : "/LTWeb/productLoadAjaxController",
				type : "get", //send it through get method
				data : {
					exits : amount
				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML += data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		function searchByName(param) {
			var txtSearch = param.value;
			$.ajax({
				url : "/WebBanGiay2/searchAjax",
				type : "get", //send it through get method
				data : {
					txt : txtSearch
				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
	</script>

	
</body>
</html>



	