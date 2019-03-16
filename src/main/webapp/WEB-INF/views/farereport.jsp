<%-- 
    Document   : report
    Created on : Mar 29, 2018, 10:46:50 AM
    Author     : User
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
        <h2>Fare Report</h2>

        <form:form method="POST" action="reservationfareamt" commandName="reportInputForm">

            <table id="reptbl" width="350px" border="1">
                <tr>
                    <td colspan="2"><form:errors path="fromst" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors path="tost" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors path="comn" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>
                        Enter Fromstation Name <form:input path="fromst" id="fromst"/>
                        
                    </td> 
                    <td>
                        Enter Tostation Name<form:input path="tost" id="tost"/>
                        
                    </td> 
                    <td>
                        Enter Compartment Name<form:input path="comn" id="comn"/>
                        
                    </td> 

                </tr>
                <tr>
                <input type="submit"  value="Generate Report" />
                </tr>
            </table>  
        </form:form>
    </body>
</html>
