<!DOCTYPE html>
<html lang="en">
<head>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

  <title>Fashoes</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  
</head>
<body>

<nav class="navbar navbar-expand-md bg-light navbar-light">
  <a class="navbar-brand" href="#"><img src="resources/images/logo.gif" alt="Fashoes"></img></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="index"><b>Home</b></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="aboutUs"><b>About Us</b></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contactUs"><b>Contact Us</b></a>
      </li>    
      <li class="nav-item">
        <a class="nav-link" href="category"><b>Add Category</b></a>
      </li> 
      <li class="nav-item">
        <a class="nav-link" href="product"><b>Add Product</b></a>
      </li>
      <security:authorize access="isAnonymous()">
       <li class="nav-item">
        <a class="nav-link" href="login"><b>Login</b></a>
      </li>  
      
       <li class="nav-item">
        <a class="nav-link" href="signUp"><b>SignUp</b></a>
      </li>      
      </security:authorize>
        <security:authorize access="isAuthenticated()">
       <li class="nav-item">
        <a class="nav-link" href="logout">Logout</a>
      </li>  
    </security:authorize>
   
  </div>  
</nav>


