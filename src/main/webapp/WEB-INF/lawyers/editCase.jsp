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
                <br><br><br><br><br><br><br><br><br><br>
                <form:form id='login-form' action="/saveCase" method='POST' modelAttribute="cas">
                    <form:hidden path="id"></form:hidden>
                    <form:input path="username" type='text' />
                    <form:input path="description" type='text' />
                    <form:input path="status" type='text' />
                    <form:input path="caseType" type='text' />
                    <form:input path="judge_id" type='text' />
                    <form:input path="court_id" type='text' />
                    <form:input path="previousHearingDate" type='date' />
                    <form:input path="nextHearingDate" type='date' />
                    <form:input path="judgementDate" type='date' />
                    <input name="submit" type="submit" value="submit" />
                </form:form>
            </body>
</html>



    
    
    