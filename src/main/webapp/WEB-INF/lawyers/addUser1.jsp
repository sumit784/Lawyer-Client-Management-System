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
  <script type="text/javascript">
    var datefield=document.createElement("input")
    datefield.setAttribute("type", "date")
    if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
        document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
        document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n') 
    }
</script>
 
 <script>
        if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
            jQuery(function($){ //on document.ready
                $('#birthday').datepicker();
            })
        }
        </script>
  
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
    <li><a href="http://localhost:8080/viewAppointments">Appointments</a></li>
        <li><a href="http://localhost:8080/viewUsers">Clients</a></li>
        <li><a href="http://localhost:8080/viewAllCases">Cases</a></li>
        <li><a href="http://localhost:8080/addCase">New Case</a></li>
        <li><a href="http://localhost:8080/findCase">Search</a></li>
        <li><a href="http://localhost:8080/addUser">New Client</a></li>
        <li><a href="http://localhost:8080/publishJournal">Journal</a></li>
        <li><a href="http://localhost:8080/addMessage">Message</a></li>
   </ul>
</div>
</div>
<div class="content">
<div class="left-panel">
<div class="left-panel-in">
<h2 class="title">Regisration form for new client</h2>
<p>&nbsp;</p>
<form:form id='login-form' action="/addUser" method='POST' modelAttribute="user">
                    <form:input path="username" type='text' placeholder="Enter username"/>
                    <form:input path="phone" type='text' placeholder="Enter phone number"/>
                    <form:input path="email" type='text' placeholder="Enter mail"/>
                    <form:input path="address" type='text' placeholder="Enter address"/>
                    <form:input path="password" placeholder="Enter password" type='password'/>
                    <input name="submit" type="submit" value="submit" />
                </form:form>
<p>&nbsp;</p>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
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
  <p>&copy; Copyright 2019. Narayana's Lawyers & Legal Consultancy  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <a href="http://localhost:8080/logout">Logout</a>
  </p>
</div>
</div>
</div>

</body></html>