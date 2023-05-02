<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
    
        
        <form action="${pageContext.request.contextPath}/updateuser" method="get">
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <a href="${pageContext.request.contextPath}/changePassword"><h4 class="text-right">Change Password</h4></a>
                </div>
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <a href="${pageContext.request.contextPath}/BillControl"><h4 class="text-right">Order</h4></a>
                </div>
                <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="${sessionScope.USERMODEL.images }"></span></div>
        </div>
                <div class="row mt-2">
                    <div class="col-md-6"><label class="labels">Username</label><input type="text" class="form-control" placeholder="User name" name="username" value="${sessionScope.USERMODEL.username }"></div>
                    
                </div>
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control" placeholder="enter email" name="email" value="${sessionScope.USERMODEL.email }"></div>
                    <div class="col-md-12"><label class="labels">Full name</label><input type="text" class="form-control" placeholder="enter fullname" name=fullname value="${sessionScope.USERMODEL.fullname }"></div>
                    <div class="col-md-12"><label class="labels">Phone</label><input type="text" class="form-control" placeholder="enter phone number" name="phone" value="${sessionScope.USERMODEL.phone }"></div>
                    
                </div>
                <div class="mt-5 text-center"><input type="submit" class="btn btn-success" value="Edit"></div>
            </div>
            </form>
        </div>
    </div>

</body>
</html>