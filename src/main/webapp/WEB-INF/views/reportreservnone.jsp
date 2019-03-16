<%-- 
    Document   : reportreservnone
    Created on : Jan 5, 2019, 1:10:22 AM
    Author     : dhaka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .error {
                color: #ff0000;
            }

        </style>
    </head>
    <body>
        <h2>Report example</h2>

        <form:form method="POST" action="reportreservation" commandName="reportInputForm">

            <table id="reptbl" width="350px" border="1">
                <tr>
                    <td colspan="2"><form:errors path="tno" cssClass="error"/></td> </tr>
                
                    
                    <tr>
                    <td colspan="2"><form:errors path="tdate" cssClass="error"/></td>
                    </tr>
                <tr>
                    <td>
                        Enter TrainNumber <form:input path="tno" id="tno"/></td>
                    <td>
                        Enter Reservation_Date <form:input path="tdate" id="tdate"/>
                        
                    </td> 

                </tr>
                <tr>
                <input type="submit"  value="Generate Report"  />
                </tr>
            </table>  
        </form:form>
    </body>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <script>
                                                        $(document).ready(function () {
                                                            var date_input = $('input[name="tdate"]'); //our date input has the name "date"
                                                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                                            date_input.datepicker({
                                                                format: 'yyyy/mm/dd',
                                                                container: container,
                                                                todayHighlight: true,
                                                                autoclose: true,
                                                            })
                                                        })
        </script>
</html>
