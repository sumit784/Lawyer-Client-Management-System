<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Narayana's Lawyers and Legal Consultancy</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">
  <link href="css/style.css" rel="stylesheet" type="text/css">
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
<!-- <p style="color: brown;"><i>Justice Always Prevails</i> -->
</p>
</div>
<div class="menu">
<ul>
  <li><a href="/home">Home</a></li>
  <li><a href="/viewAnn">General Announcements</a></li>
  <li><a href="/viewMess">Messages from the lawyer</a></li>
  <li><a href="/viewCase">My Cases</a></li>
  <li><a href="/downloads">My Documents</a></li>
  <li><a href="/upload">Upload files</a></li>
</ul>
</div>
</div>
<div class="content">
<div class="left-panel">
<div class="left-panel-in">
<h2 class="title">My Cases</h2>
<p>&nbsp;</p>
<table>
<tr>
    <th>Case Type</th>
    <th>Court Id</th>
    <th>Description</th>
    <th>Judge Id</th>
    <th>Judgement Date</th>
    <th>Next Hearing Date</th>
    <th>Previous Hearing Date</th>
    <th>Case status</th>
  </tr>
  <c:forEach items="${l}" var="il">
      <tr>
        <td>${il.caseType}</td>
        <td>${il.court_id}</td>
        <td>${il.description}</td>
        <td>${il.judge_id}</td>
        <td>${il.nextHearingDate}</td>
        <td>${il.previousHearingDate}</td>
        <td>${il.judgementDate}</td>
        <td>${il.status}</td>
        </tr>
  </c:forEach></table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>


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