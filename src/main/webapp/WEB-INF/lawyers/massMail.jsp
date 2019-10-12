<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
        <head>
                <style>
                        form {
                          margin:0 auto;
                          width:1000px
                        }
                        input {
                        margin-bottom:3px;
                        padding:10px;
                        width: 10%;
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
                <form:form id='login-form' action="/massMail" method='POST' modelAttribute="massmail">
                <form:textarea path="body" rows="60" cols="120" />
                <input name="submit" type="submit" value="submit" />
                </form:form>
            </body>
</html>







    
    
    
    