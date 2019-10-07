<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>

<h1>Look at the users!</h1>
<c:out value = "${users.get(0).name}" />
<a href="/logout">logout</a>
</body>
</html>