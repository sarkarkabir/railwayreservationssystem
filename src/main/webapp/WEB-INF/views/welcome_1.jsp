<%-- 
    Document   : welcome
    Created on : Nov 20, 2018, 4:20:01 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <h1>Welcome ${sessionScope.UserLoggedIn}</h1>
        <a href="logout">Logout</a>|
         <a href="showingcategorypage">Add Category</a>|
         <a href="traininformationpage">Traininfo</a>|
         <a href="stationpage">Add Station</a>|
          <a href="compartpage">comparttype</a>|
         <a href="passengerpage">add passengerinfo</a>|
         <a href="typepassengerpage">passengertype</a>|
         <a href="showtrainpage">Trainseat</a>|
         <a href="showcomsubtypepage">Compartmentsub type</a>|
         <a href="farechartpage">FareChart </a>|
         <!--<a href="reservationpage">reservation </a>|-->
         <a href="reservationdetailspage">reservationdetails </a>|
         <a href="availabletrainpage">search train </a>
         
    </body>
</html>
