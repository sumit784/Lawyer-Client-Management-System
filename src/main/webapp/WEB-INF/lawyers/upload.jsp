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
                <form:form id='login-form' action="/upload" method='POST' enctype="multipart/form-data">
                <p style="color:crimson;font-size:20px;font-weight: bold;">
                        File name must contain your username too.
                      </p>
                    <input type="file" name="file" /><br/><br/>
                    <input name="submit" type="submit" value="submit" />
                </form:form>
                <br><br><br>
                <br><br><br>
                <br><br><br>
                <input id="name" type="text" />
                <button onclick="location.href='/localhost:8080/download/file/'+document.querySelector('#name').value()">
            </body>
</html>



<!-- <!DOCTYPE html>
<body>

<h1>Spring Boot file upload example</h1>

<form method="POST" action="/upload" enctype="multipart/form-data">
    <input type="file" name="file" /><br/><br/>
    <input type="submit" value="Submit" />
</form>

</body>
</html> -->





    
    
    
    