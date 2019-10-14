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
<h2 class="title">Send A Message to Client</h2>
<p>&nbsp;</p>
<form:form id='login-form' action="/addMessage" method='POST' modelAttribute="message">
                    <form:input path="body" type='text' placeholder="Enter the Message body..."/>
                    <form:input path="user" type='text' placeholder="Enter the UserId.."/>
                    <input name="submit" type="submit" value="submit" />
                </form:form>
<!-- <table>
        <tr>
            <th>Username</th>
            <th>Status</th>
            <th>Description</th>
            <th>Case Type</th>
            <th>Judge Id</th>
            <th>Court Id</th>
            <th>Previous Hearing Date</th>
            <th>Next Hearing Date</th>
            <th>Judgement Date</th>
          </tr>
          <c:forEach items="${l}" var="il">
              <tr>
                <td>${il.username}</td>
                <td>${il.status}</td>
                <td>${il.description}</td>
                <td>${il.caseType}</td>
                <td>${il.judge_id}</td>
                <td>${il.court_id}</td>
                <td>${il.previousHearingDate}</td>
                <td>${il.nextHearingDate}</td>
                <td>${il.judgementDate}</td>
              </tr>
          </c:forEach></table> -->
<!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse
id purus nisi, in rutrum nunc. Donec non orci eros, ut sollicitudin
risus. Vivamus at lacinia enim. Nam tincidunt nisl eget erat
sollicitudin vitae accumsan felis eleifend. Phasellus eu ante non magna
egestas tincidunt ut varius lorem. Nunc ornare feugiat ligula, ut
tincidunt enim porta nec. Curabitur interdum, ante non vehicula semper,
quam arcu condimentum velit, at elementum justo nisi eget urna. Fusce
vulputate malesuada euismod. Morbi condimentum tincidunt molestie. In
vulputate neque et augue posuere fringilla. Nunc nec tempus nibh.
Integer interdum suscipit urna, nec interdum nisi aliquet et. Quisque
augue tortor, porta et malesuada dapibus, tempor ut mauris. Nullam
dictum posuere ante at tincidunt. Praesent sed lorem enim, vitae
scelerisque dui. Etiam ac purus est, et accumsan sem. In hac habitasse
platea dictumst. Maecenas a dui leo, sit amet dignissim nisi. </p>
<p>&nbsp;</p>
Nam sit amet arcu nisi. Proin sagittis, nisi sed sollicitudin
elementum, urna justo porta enim, nec semper massa nunc non eros.
Nullam molestie, quam quis egestas porta, ligula elit laoreet ante, a
convallis lectus sem volutpat urna. Donec congue purus placerat quam
sodales quis suscipit leo ullamcorper. Quisque vulputate metus vel
risus aliquam dictum. Pellentesque habitant morbi tristique senectus et
netus et malesuada fames ac turpis egestas. Vestibulum eget justo et
orci viverra pulvinar eu non magna. Nam vehicula convallis erat
suscipit laoreet. Phasellus at nisl ut diam aliquam ultricies non vel
quam. Donec mattis porttitor ante lacinia dapibus. Cras vitae massa
sem, ac pharetra felis. Praesent tincidunt interdum neque, et semper
nulla suscipit a. Nullam ultricies varius orci, nec pharetra quam
accumsan id. Donec vel nulla quis sem aliquet suscipit. Aenean at
lectus mauris, non tristique dui. Curabitur eu diam mi, eget blandit
dolor.
<p>&nbsp;</p>
<p>&nbsp;</p>
<h2 class="title">Recent articles<br>
</h2>
<p>&nbsp;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse
id purus nisi, in rutrum nunc. Donec non orci eros, ut sollicitudin
risus. Vivamus at lacinia enim. Nam tincidunt nisl eget erat
sollicitudin vitae accumsan felis eleifend. Phasellus eu ante non magna
egestas tincidunt ut varius lorem. Nunc ornare feugiat ligula, ut
tincidunt enim porta nec. Curabitur interdum, ante non vehicula semper,
quam arcu condimentum velit, at elementum justo nisi eget urna. Fusce
vulputate malesuada euismod. Morbi condimentum tincidunt molestie. In
vulputate neque et augue posuere fringilla. Nunc nec tempus nibh.
Integer interdum suscipit urna, nec interdum nisi aliquet et. Quisque
augue tortor, porta et malesuada dapibus, tempor ut mauris. Nullam
dictum posuere ante at tincidunt. Praesent sed lorem enim, vitae
scelerisque dui. Etiam ac purus est, et accumsan sem. In hac habitasse
platea dictumst. Maecenas a dui leo, sit amet dignissim nisi.<br>
<br>
</p> -->
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