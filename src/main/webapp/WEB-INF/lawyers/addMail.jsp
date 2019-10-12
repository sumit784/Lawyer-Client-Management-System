<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
        <head>
                <style>
                        form {
                          margin:0 auto;
                          width:300px
                        }
                        input {
                        margin-bottom:3px;
                        padding:10px;
                        width: 100%;
                        border:1px solid #CCC
                        }
                        button {
                        padding:10px
                        }
                        vertical-center {
                        margin: 0;
                        position: absolute;
                        top: 50%;
                        -ms-transform: translateY(-50%);
                        transform: translateY(-50%);
                        }
                        label {
                        cursor:pointer
                        }
                        #form-switch {
                        display:none
                        }
                        #register-form {
                        display:none
                        }
                        #form-switch:checked~#register-form {
                        display:block
                        }
                        #form-switch:checked~#login-form {
                        display:none
                        }
                </style>
            </head>
            <body>
                <br><br><br><br><br><br><br><br><br><br>
                <form:form id='login-form' action="/addEmail" method='POST' modelAttribute="mail">
                    <form:input path="email" type='text' placeholder="Enter your mail"/>
                    <input name="submit" type="submit" value="submit" />
                </form:form>
            </body>
</html>





<!-- 
<form:form method="post" modelAttribute="mail" action="/addEmail">
    <form:input path="email" type='text' placeholder="Enter your mail"/>
    <input name="submit" type="submit" value="submit" />
</form:form> -->
    
    
    
    