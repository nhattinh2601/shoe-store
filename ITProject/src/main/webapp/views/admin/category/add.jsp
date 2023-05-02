<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>

</head>

<body class="no-skin">




	<div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Add <b>Category</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            
            
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="${pageContext.request.contextPath}/admin-category/create" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Add Category</h4>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Name</label>
                                    <input name="categoryName" type="text" class="form-control" >
                                </div>
                                
                                <div class="form-group">
                                    <label>Image</label>
                                    <input  name="images" type="text" class="form-control" >
                                </div>

                                    <input type="hidden" value="1" name="status" type="text" class="form-control" >
                                

                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>



        </div>
        

</body>
</html>