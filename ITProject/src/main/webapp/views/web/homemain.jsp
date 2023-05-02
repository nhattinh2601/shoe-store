<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>




              <section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">K&T Shop Home</h1>
        <p class="lead text-muted mb-0">Mang tới những đôi giày tuyệt vời là trách nhiệm của chúng tôi</p>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                 <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://cdn3.dhht.vn/wp-content/uploads/2022/07/bang-size-giay-nike-chuan-cho-nam-nu-tre-em-de-mua-sam.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://laforce.vn/wp-content/uploads/2022/01/bang-size-giay-nike-nhat-ban.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://cdn3.dhht.vn/wp-content/uploads/2021/09/1-10-thuong-hieu-giay-viet-nam-duoc-ua-chuong-nhat-hien-nay.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-12 col-md-3">
			<div class="card">
				
					<div class="card-header bg-success text-white text-uppercase">
						<i class="fa fa-heart"></i> Top one
					</div>
					<img class="img-fluid border-0"
						src="${top1.images}" width="600" height="400"
						alt="Card image cap">
					<div class="card-body">
						<h4 class="card-title text-center">
							<a href="${pageContext.request.contextPath}/product/detail?pid=${top1.productId}" title="View Product">${top1.productName}</a>
            
							
							
						</h4>
						<div class="row">
							<div class="col">
								<p class="btn btn-danger btn-block">${top1.price} </p>
							</div>
							<div class="col">
								<a href="${pageContext.request.contextPath}/product/detail?pid=${top1.productId}" class="btn btn-success btn-block">View</a>
							</div>
						</div>
					</div>				
            </div>
        </div>
    </div>
</div>


<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> New products
                </div>
                <div class="card-body">
					<div class="row">
						<core:forEach items="${top4last}" var="o">
							<div class="col-sm">
								<div class="card">
									<img class="card-img-top"
										src="${o.images }" width="600" height="400"
										alt="Card image cap">
									<div class="card-body">
										<h4 class="card-title">
											<a href="${pageContext.request.contextPath}/product/detail?pid=${o.productId}" title="View Product">${o.productName}</a>
										</h4>
										<p class="card-text">Sản Phẩm Mới</p>
										<div class="row">
											<div class="col">
												<p class="btn btn-danger btn-block">${o.price} đ</p>
											</div>
											<div class="col">
												<a href="${pageContext.request.contextPath}/cart/add?productid=${o.productId}&price=${o.price}" class="btn btn-success btn-block">Add
													to cart</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</core:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container mt-3 mb-4">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-trophy"></i> Best products
                </div>
                <div class="card-body">
					<div class="row">
						<core:forEach items="${top4best}" var="o">
							<div class="col-sm">
								<div class="card">
									<img class="card-img-top"
										src="${o.images }" width="600" height="400"
										alt="Card image cap">
									<div class="card-body">
										<h4 class="card-title">
											<a href="${pageContext.request.contextPath}/product/detail?pid=${o.productId}" title="View Product">${o.productName}</a>
										</h4>
										<p class="card-text">Hàng đẹp giá rẻ</p>
										<div class="row">
											<div class="col">
												<p class="btn btn-danger btn-block">${o.price} đ</p>
											</div>
											<div class="col">
												<a href="${pageContext.request.contextPath}/cart/add?productid=${o.productId}&price=${o.price}" class="btn btn-success btn-block">Add
													to cart</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</core:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>





<!-- JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
