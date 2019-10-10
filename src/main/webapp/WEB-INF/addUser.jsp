<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<script language="Javascript">
    var password;
    var pass = "admin";
    password=prompt('Enter the password to view the page','');
    if(password==pass)
    alert('Correct password. Enter the page.');
    else{
        window.location="https://google.com";
    }</script>

<form:form method="post" modelAttribute="user">
    <form:input path="username" type='text'/>
    <form:input path="email" type='text'/>
    <form:input path="password" type='password'/>
    <input name="submit" type="submit" value="submit" />
</form:form>
