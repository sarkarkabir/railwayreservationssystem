<%-- 
    Document   : fareamount
    Created on : Dec 9, 2018, 1:41:33 AM
    Author     : dhaka
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style type="text/css">

            .panel>.panel-heading {
                color: #558b2f;
                background-color: #aed581;
                border-color: #aed581;
            }
            .panel>.panel-body
            {
                background-color: #f1f8e9;
                border-color: #aed581;
            }

            .form-control:FOCUS
            {
                border: 2px thin #9ccc65;
                border-radius: 5px;
            }
            .list-group-item {
                overflow: hidden;
            }
            #removebuttons
            {
                color: #ffffff;
                background-color: #e57373;
            }
            #removebuttons:HOVER {
                color: #ffffff;
                background-color: #e53935;
            }
            #editbuttons{
                color: #ffffff;
                background: linear-gradient(to bottom, #aed581 50%, #9ccc65 50%);	
            }
            #editbuttons:HOVER {
                color: #ffffff;
                background: linear-gradient(to bottom, #9ccc65 50%, #8bc34a 50%);	
            }
        </style>
        <script src="resources/js/angular.js"></script>

        <script>
            var farechartlist = ${farechartlist};
//            var traininfolist = ${traininfolist};
//            var comtypelist = ${comtypelist};
//            var passengertypelist = ${passengertypelist};
//            var stationservlist = ${stationservlist};
//            console.log(farechartlist);
            angular.module('Sarkar', []).controller('ProductController',
                    function ($scope) {
                        $scope.farechartlist = farechartlist;
//                        $scope.traininfolist = traininfolist;
//                        $scope.comtypelist = comtypelist;
//                        $scope.passengertypelist = passengertypelist;
//                        $scope.stationservlist = stationservlist;
                        console.log($scope.farechartlist);
                    });
        </script>
    </head>
    <body ng-app="Sarkar" ng-controller="ProductController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">List of Fare chart in railway reservation system</span>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                       
                    </div>
                    <!-- panel body end -->
                </div>
            </div>
            <!-- panel end -->
            <div class="panel animated fadeInUp delay-05s" id="panel-2">
                <div class="panel-heading">
                    <span class="lead">Fare List</span>
                </div>
                <p><input type="text" ng-model="test" class="form-control" placeholder="Search product"></p>
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="product in farechartlist| filter:test">
                            <table style="width: 100%">
                                <tr>

                                    <td>
                                        <ul>
                                            <li><span><b>Fare Id: </b></span>{{product.fareid}}</li>
                                            <li><span><b>Fromstation Id </b></span>{{product.fromstationid}}</li>
                                            <li><span><b>Tostation Id : </b></span>{{product.tostationid}}</li>
                                            <li><span><b>Comartmenttype Id: </b></span>{{product.comname}}</li>
                                            <li><span><b>Fare Amount : </b></span>{{product.fareamt}}</li>
                                            <li><span><b>passengertype Id: </b></span>{{product.passtypeid}}</li>
                                        </ul>
                                    </td>
                                    
                                </tr>
                            </table>
                        </li>
                    </ul>
                </div>
                <!-- panel2 body end -->
            </div>
            <!-- panel2 end -->
        </div>

        <jsp:include page="footer.jsp" />


    </body>
</html>
