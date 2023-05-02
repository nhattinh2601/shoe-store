<!-- Header -->
<header class="header-v4">
	<!-- Header desktop -->
	<div class="container-menu-desktop">
		<!-- Topbar -->
		<div class="top-bar">
			<div class="content-topbar flex-sb-m h-full container">
				<div class="left-top-bar">IT Project</div>

				<div class="right-top-bar flex-w h-full">		 
					
					<c:if test="${empty USERMODEL}">
						<a href='<c:url value="/login?action=login"/>'
							class="flex-c-m trans-04 p-lr-25"> Login </a>
					</c:if>
					<c:if test="${not empty USERMODEL}">
						<a href="${pageContext.request.contextPath}/profile" class="flex-c-m trans-04 p-lr-25"> My Account </a>
						<a href="#" class="flex-c-m trans-04 p-lr-25"> Welcome ,
							${sessionScope.USERMODEL.fullname } </a>
						<a href='<c:url value="/logout?action=logout"/>'
							class="flex-c-m trans-04 p-lr-25"> Logout </a>
					</c:if>
				</div>
			</div>
		</div>

		<div class="wrap-menu-desktop how-shadow1">
			<nav class="limiter-menu-desktop container" style=" top: 0px;">

				<!-- Logo desktop -->
				<a href="#" class="logo"> <img
					src="<c:url value='/template/web/images/icons/logostore2.jpg' />"
					style="width: 400%; height: 400%;" alt="IMG-LOGO">
				</a>

				<!-- Menu desktop -->
				<div  class="menu-desktop">
					<ul class="main-menu">
						<li><a href="${pageContext.request.contextPath}/homemain">Home</a> <!-- <ul class="sub-menu">
								<li><a href="index.html">Homepage 1</a></li>
								<li><a href="home-02.html">Homepage 2</a></li>
								<li><a href="home-03.html">Homepage 3</a></li>
							</ul></li> -->
						<%-- <li class="<!-- active- -->menu" data-menu="hot"><a href="${pageContext.request.contextPath}/category/list">Category</a></li> --%>

						<li class="label1" data-label1="hot"><a
							href="${pageContext.request.contextPath}/category/list">Category</a></li>

						<!-- <li><a href="blog.html">Blog</a></li> -->

						<!-- <li><a href="about.html">About</a></li>
 -->
						<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
					</ul>
				</div>

				<!-- Icon header -->
				<div class="wrap-icon-header flex-w flex-r-m">
					<div class="input-group input-group-sm" style="width: 50%;">
						<form action="${pageContext.request.contextPath}/search" method="post"
							class="form-inline my-2 my-lg-0">
							<div class="input-group input-group-sm">
								<input oninput="searchByName(this)" value="${txtS}" name="txt"
									type="text" class="form-control" aria-label="Small"
									aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
								<div class="input-group-append">
									<button type="submit" class="btn btn-secondary btn-number">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
					<!-- Icon header -->


					<c:if test="${empty USERMODEL}">
						<div
						class="icon-header-item ">
						<a href="${pageContext.request.contextPath}/login"> <i class="zmdi zmdi-shopping-cart"></i></a>
						
					</div>
					</c:if>
					<c:if test="${not empty USERMODEL}">

<div
						class="icon-header-item ">
							<a href="${pageContext.request.contextPath}/cart"> <i
								class="zmdi zmdi-shopping-cart"></i></a>

						</div>

					</c:if>

					<a href="#"
						class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti"
						data-notify="0"> <i class="zmdi zmdi-favorite-outline"></i>
					</a>
				</div>
				</nav>
		</div>
		
	</div>



	<!-- Cart -->
	<div class="wrap-header-cart js-panel-cart">
		<div class="s-full js-hide-cart"></div>

		<div class="header-cart flex-col-l p-l-65 p-r-25">
			<div class="header-cart-title flex-w flex-sb-m p-b-8">
				<span class="mtext-103 cl2"> Your Cart </span>

				<div
					class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart">
					<i class="zmdi zmdi-close"></i>
				</div>
			</div>

			<div class="header-cart-content flex-w js-pscroll">
				<ul class="header-cart-wrapitem w-full">
					<li class="header-cart-item flex-w flex-t m-b-12">
						<div class="header-cart-item-img">
							<img src="images/item-cart-01.jpg" alt="IMG">
						</div>

						<div class="header-cart-item-txt p-t-8">
							<a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
								White Shirt Pleat </a> <span class="header-cart-item-info"> 1
								x $19.00 </span>
						</div>
					</li>

					<li class="header-cart-item flex-w flex-t m-b-12">
						<div class="header-cart-item-img">
							<img src="images/item-cart-02.jpg" alt="IMG">
						</div>

						<div class="header-cart-item-txt p-t-8">
							<a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
								Converse All Star </a> <span class="header-cart-item-info"> 1
								x $39.00 </span>
						</div>
					</li>

					<li class="header-cart-item flex-w flex-t m-b-12">
						<div class="header-cart-item-img">
							<img src="images/item-cart-03.jpg" alt="IMG">
						</div>

						<div class="header-cart-item-txt p-t-8">
							<a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
								Nixon Porter Leather </a> <span class="header-cart-item-info">
								1 x $17.00 </span>
						</div>
					</li>
				</ul>

				<div class="w-full">
					<div class="header-cart-total w-full p-tb-40">Total: $75.00</div>

					<div class="header-cart-buttons flex-w w-full">
						<a href="shoping-cart.html"
							class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
							View Cart </a> <a href="shoping-cart.html"
							class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-b-10">
							Check Out </a>
					</div>
				</div>
			</div>
		</div>
	</div>


</header>

