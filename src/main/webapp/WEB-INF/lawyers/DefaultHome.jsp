<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <meta charset="UTF-8">
  <title>Narayana's Lawyers and Legal Consultancy</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">
  <link href="/css/style.css" rel="stylesheet" type="text/css">
  <style>
    body {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	color: #333333;
	background-color: #d7d7bd;
	margin: 30px;
}
h1, h2, h3, h4, h5, h6, p, ul, ol, li, form, input, textarea {
	padding: 0px;
	margin: 0px;
}
a {
	color: #035c7a;
	text-decoration: underline;
}
a:hover {
	color: #035c7a;
	text-decoration: none;
}
.main {
	width: 840px;
	margin: 0px auto;
}
.page {
	background-color: #FFFFFF;
	width: 800px;
	float: left;
	padding: 20px;
}
.header {
	width: 800px;
	float: left;
}
.header-img {
	background-image: url(../images/header.jpg);
	background-repeat: no-repeat;
	background-position: left top;
	text-align: right;
	width: 800px;
	height: 249px;
	float: left;
}
.header-img h1 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 36px;
	font-weight: normal;
	line-height: 100%;
	color: #FFFFFF;
	margin-top: 63px;
	margin-right: 72px;
}
.header-img p {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-weight: bold;
	color: #FFFFFF;
	margin-top: 10px;
	margin-right: 136px;
}
.menu {
	background-color: #000000;
	width: 800px;
	height: 51px;
	float: left;
}
.menu ul {
	list-style-type: none;
}
.menu ul li {
	display: inline;
}
.menu ul li a {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
	line-height: 51px;
	color: #FFFFFF;
	text-decoration: none;
	padding-right: 25px;
	padding-left: 25px;
}
.menu ul li a:hover {
	color: #4BC4EF;
}
.content {
	width: 800px;
	float: left;
	padding-top: 12px;
}
.left-panel {
	width: 480px;
	float: left;
	padding: 20px 50px 20px 20px;
}
.left-panel-in {
	text-align: justify;
	clear: both;
}
.title {
	font-size: 18px;
	font-weight: normal;
	color: #035c7a;
	padding-bottom: 3px;
	border-bottom-width: 1px;
	border-bottom-style: dashed;
	border-bottom-color: #CCCCCC;
}
.copyright {
	border: 0px;
	height: 1px;
	width: 1px;
}
.right-panel {
	width: 250px;
	float: right;
}
.right-panel-in {
	clear: both;
}
.right-panel-in h3 {
	font-size: 20px;
	font-weight: normal;
	color: #346397;
	margin-top: 25px;
	margin-bottom: 17px;
	margin-left: 3px;
}
.right-panel-in ul {
	list-style-type: none;
}
.right-panel-in ul li {
	padding-top: 8px;
	padding-bottom: 8px;
	border-bottom-width: 1px;
	border-bottom-style: dashed;
	border-bottom-color: #CCCCCC;
}
.right-panel-in ul li a {
	color: #003366;
	text-decoration: none;
}
.right-panel-in ul li a:hover {
	text-decoration: underline;
}
.footer {
	background-color: #000000;
	width: 800px;
	height: 55px;
	float: left;
}
.footer p {
	color: #FFFFFF;
	margin-top: 20px;
	text-align:center;
}

.footer a {
	color: #FFFFFF;
}

  </style>
</head>
<body>
<div class="main">
<div class="page">
<div class="header">
<!-- <div class="header-img">
<h1>Narayana's Lawyers and Legal Consultancy</h1>
</div>  -->
<div class="menu">
<ul>
  <li><a href="#">Home</a></li>
  <li><a href="http://localhost:8080/addAppointment">Schedule an Appointment</a></li>
  <li><a href="http://localhost:8080/addMail">Subscribe to my Weekly Law Journal</a></li>
</ul>
</div>
</div>
<div class="content">
<div class="left-panel">
<div class="left-panel-in">
<h2 class="title">Welcome, Enter your credentials.</h2>
<p>&nbsp;</p>
<form id='login-form' action="login" method='POST'>
	<input type="text" placeholder="Username" name='username' value='' required>
	<input type="password" placeholder="Password" name='password' required>
	<button type='submit'>Login</button>
	</form>
<p>&nbsp;</p>
<p>&nbsp;</p>
Please check the spam folder in your mail in case it didn't appear in your inbox.
<br>
<p>&nbsp;</p>
Please feel free to subscribe to my Weekly Law Journal.

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>


</div>
</div>

<div class="right-panel">
<div class="right-panel-in">

<!-- <h3>Categories</h3>
<ul>
  <li><a href="#">Link item 1<br>
    </a></li>
  <li><a href="index.html#">Link item 2<br>
    </a></li>
  <li><a href="index.html#">Link item 3<br>
    </a></li>
  <li><a href="index.html#">Link item 4<br>
    </a></li>
  <li><a href="index.html#">Link item 5<br>
    </a></li>
  <li><a href="index.html#">Link item 6<br>
    </a></li>
</ul>
<h3>Blogroll</h3>
<ul>
  <li><a href="#">Blogroll link 1<br>
    </a></li>
  <li><a href="index.html#">Blogroll link 2<br>
    </a></li>
  <li><a href="index.html#">Blogroll link 3<br>
    </a></li>
  <li><a href="index.html#">Blogroll link 4<br>
    </a></li>
  <li><a href="index.html#">Blogroll link 5<br>
    </a></li>
  <li><a href="index.html#">Blogroll link 6<br>
    </a></li>
</ul> -->
<p>&nbsp;</p>
<p>&nbsp;</p>

</div>
</div>
</div>
<div class="footer">
<p>&copy; Copyright 2019. Narayana's Lawyers & Legal Consultancy
</p>
</div>
</div>
</div>

</body>