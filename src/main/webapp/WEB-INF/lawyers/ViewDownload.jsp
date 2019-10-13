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
</head>
<body>
<div class="main">
<div class="page">
<div class="header">
<div class="header-img">
<h1 style="color: brown;">Narayana's Lawyers & Legal Consultancy</h1>
<!-- <p style="color: brown;"><i>Justice Always Prevails</i> -->
</p>
</div>
<div class="menu">
<ul>
  <li><a href="http://localhost:8080/home">Home</a></li>
  <li><a href="http://localhost:8080/viewAnn">General Announcements</a></li>
  <li><a href="http://localhost:8080/viewMess">Messages from the lawyer</a></li>
  <li><a href="http://localhost:8080/viewCase">My Cases</a></li>
  <li><a href="http://localhost:8080/downloads">My Documents</a></li>
  <li><a href="http://localhost:8080/upload">Upload files</a></li>
</ul>
</div>
</div>
<div class="content">
<div class="left-panel">
<div class="left-panel-in">
<h2 class="title">Download Files</h2>
<p>&nbsp;</p>
<c:forEach items="${obj}" var="obj" >
                 ${obj.filename}
            </c:forEach>


            
        
            <input id="name" type="text"/>
            <script>
                var url='http://localhost:8080/download/file/';
            </script>
            <button onclick="location.href=url+document.querySelector('#name').value">download</button>
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
        <p>&copy; Copyright 2019. Narayana's Lawyers & Legal Consultancy
            </p>
</div>
</div>
</div>

</body></html>