<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Course To Instructor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body>
  
    <form action="addCourseToInstructor" method="post" class="mx-auto p-5 mx-auto mt-5 shadow-sm p-3 mb-5 bg-body-tertiary rounded" style="width: 600px">
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Enrollment Id</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="eid" >
   
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Course Id</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="cid" >
   
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Instructor Id</label>
    <input type="text" name="id" class="form-control" id="exampleInputPassword1" >
  </div>
  
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>