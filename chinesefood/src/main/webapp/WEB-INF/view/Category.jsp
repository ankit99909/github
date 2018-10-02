<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@include file="Header.jsp"  %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Category</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
   <style>
   body {
     background: url('resources/images/shoe-background-hd-1280x854-81842.jpg') fixed;
    background-size: cover;}   
    div{background-color:#F2F2F2;}
  </style>

</head>
<body>
<br><br>
<div class="container">
<h2 align="center">Add Category</h2><hr>
<spring:form action="${pageContext.request.contextPath}/addCategory" modelAttribute="cat" method="POST">
<div class="form-group">
<c:if test="${not empty cat.categoryName}">
<label for="cid">Category ID:</label>
<spring:input type="text" path="categoryId" class="form-control" id="cid" readonly="true" disabled="true"/>
<spring:hidden path="categoryId"/>
</c:if>
</div>
<div class="form-group">
<label for="cname">Category Name:</label>
<spring:input type="text" class="form-control" id="cname" path="categoryName"/>
 </div>
 
 <div class="form-group">
<label for="cdesc">Category Description:</label>
 <spring:input type="text" class="form-control" id="cdesc" path="categoryDescription"/>
</div>


<c:if test="${empty cat.categoryName}">
<button type="submit" class="btn btn-outline-success my-2 my-sm-0">ADD</button></c:if>
<c:if test="${not empty cat.categoryName}"><button type="submit" class="btn btn-outline-success my-2 my-sm-0">Update</button></c:if>

</spring:form>
</div>


<br><br>
<c:if test="${not empty categoryList}">
<div class="container">
<table class="table table-hover" >
 <thead>
<tr><th>Category Id</th>
<th><b>Category Name</b></th>
<th><b>Category Description</b></th>

<th><b>Category Edit</b></th>
<th><b>Category Delete</b></th>
</tr>
</thead>

<c:forEach items="${categoryList}" var="cate">
<tbody>
<tr>
<td><b>${cate.categoryId}</b></td>
<td><b>${cate.categoryName}</b></td>
<td><b>${cate.categoryDescription}</b></td>

<td><a href="editCategory/${cate.categoryId}"><b>Edit</b></a></td>

<td><a href="deleteCategory/${cate.categoryId}"><b>Delete</b></a></td>
</tr>
</tbody>
</c:forEach>
</table>
</div>
</c:if>

</body>
</html>