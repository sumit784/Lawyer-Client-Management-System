<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<form:form method="post" modelAttribute="massmail" action="/massMail">
    <form:input path="body" type='text'/>
    <input name="submit" type="submit" value="submit" />
</form:form>