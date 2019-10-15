<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head></head>
    <body>
        <c:forEach items="${obj}" var="obj" >
                 ${obj.filename}
                 ${obj.username}
            </c:forEach>


            
        
            <input id="name" type="text"/>
            <script>
                var url='/download/file/';
            </script>
            <button onclick="location.href=url+document.querySelector('#name').value">download</button>
    </body>
</html>
