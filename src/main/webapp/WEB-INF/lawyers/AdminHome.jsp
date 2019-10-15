<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Panel</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">
  <link href="/css/style.css" rel="stylesheet" type="text/css">
  <style>
    table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
          }

    td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
           }

    tr:nth-child(even) {
            background-color: #dddddd;
            }
  </style>
</head>
<body>
<div class="main">
<div class="page">
<div class="header">
<div class="header-img">
<h1>Narayana's Lawyers & Legal Consultancy</h1>
</div>
<div class="menu">
<ul>
    <li><a href="/viewAppointments">Appointments</a></li>
    <li><a href="/viewUsers">Clients</a></li>
    <li><a href="/viewAllCases">Cases</a></li>
    <li><a href="/addCase">New Case</a></li>
    <li><a href="/findCase">Search</a></li>
    <li><a href="/addUser">New Client</a></li>
    <li><a href="/publishJournal">Journal</a></li>
    <li><a href="/addMessage">Message</a></li>
</ul>
</div>
</div>
<div class="content">
<div class="left-panel">
<h2 class="title">Admin Panel</h2>
<div class="left-panel-in">
  <br><br>
  <strong><p>Judges List</p></strong>
<br>
<table>
    <tr>
        <th>Judge Id</th>
        <th>Judge Name</th>
      </tr>
      <c:forEach items="${judgelist}" var="j">
          <tr>
            <td>${j.id}</td>
            <td>${j.name}</td>
            </tr>
      </c:forEach></table>

<br>
<strong><p>Courts List</p></strong>
<br>  
<table>
          <tr>
              <th>Court Id</th>
              <th>Court Name</th>
            </tr>
            <c:forEach items="${courtlist}" var="c">
                <tr>
                  <td>${c.id}</td>
                  <td>${c.name}</td>
                  </tr>
            </c:forEach></table>


<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

</div>
</div>

<div class="right-panel">
<div class="right-panel-in">

<!-- <h3>Categories</h3> -->
<!-- <ul>
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
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</div>
</div>
</div>
<div class="footer">
    <p>&copy; Copyright 2019. Narayana's Lawyers & Legal Consultancy  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <a href="/logout">Logout</a>
      </p>
</div>
</div>
</div>

</body></html>