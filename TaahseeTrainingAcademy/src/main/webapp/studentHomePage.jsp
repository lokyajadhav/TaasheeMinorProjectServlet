<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body>
   <nav class="navbar "style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="studentHomePage.jsp">
      <img src="https://www.taashee.com/wp-content/uploads/2023/02/taashee-logo-1000-x-2001.png" alt="Logo" width="280" height="60" class="d-inline-block align-text-top" style="margin-top: -20px">
      <span class="fs-1 fw-bold">T</span><span class="fs-3 " style="color:#61CE70">raining</span><span class="fs-1 fw-bold">A</span><span  class="fs-3" style="color:rgb(113,206,126)">cademy</span>
    </a>
   
    <div   style="margin-right:100px">
    <a  href="studentlogout"  >
           <button type="button" class="btn btn-success">Logout</button>
          </a>
  		
    </div>
  </div>
</nav>
<h1 class="text-center text-success p-5">The Details of Student</h1>
    <table class="table table-striped p-5 mx-auto mt-5 shadow-sm p-3 mb-5 bg-body-tertiary rounded" style="width: 600px">
	<thead>
		<tr>
		<th>Student Id</th>
		<th>Student Name</th>
		<th>Student City</th>
		<th>Student Age</th>
		
		
		
		</tr>
	</thead>
	<tbody>
		
			<tr>
			<td><c:out value="${student.id }"></c:out></td>
			
			<td><c:out value="${student.name }"></c:out></td>
			
			<td><c:out value="${studentr.city }"></c:out></td>
			<td><c:out value="${student.age }"></c:out></td>
			
			
			</tr>
		
	</tbody>
</table>

<h1 class="p-5 text-center text-primary">Student registered Courses </h1>
<table class="table table-striped p-5 mx-auto  shadow-sm p-3  bg-body-tertiary rounded" style="width: 700px">
	<thead>
		<tr>
		<th>Course Id</th>
		<th>Course Name</th>
		<th>Course Description</th>
		
		
		</tr>
	</thead>
	<tbody>
		<c:forEach var="course" items="${courses}">
			<tr>
			<td><c:out value="${course.id }"></c:out></td>
			
			<td><c:out value="${course.name}"></c:out></td>
			<td><c:out value="${course.description }"></c:out></td>
			
			
			
			
			
			
			
			</tr>
			
		</c:forEach>
	</tbody>
</table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>