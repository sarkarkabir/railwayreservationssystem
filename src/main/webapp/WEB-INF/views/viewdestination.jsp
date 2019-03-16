<<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
            var sujan = ${Traininforlist};

            console.log(sujan);

            angular.module('viwebdtrain', []).controller('viewpageController',
                    function ($scope) {
                        $scope.tlist = sujan;

                        console.log($scope.sujan);
                    });
        </script>
    </head>
    <body ng-app="viwebdtrain" ng-controller="viewpageController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Train info list</span>
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
                    <span class="lead">Traininformation List</span>
                </div>
                <p><input type="text" ng-model="test" class="form-control" placeholder="Search railways"></p>
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="tli in tlist| filter:test">
                            <table style="width: 100%">
                                <tr>

                                    <td>
                                        <ul>
                                               <li><span><b>Train Id: </b></span>{{tli.trainid}}</li>
                                            <li><span><b>Train Number: </b></span>{{tli.trainnumber}}</li>
                                            <li><span><b>Train name: </b></span>{{tli.trainname}}</li>
                                            <li><span><b>From stationId : </b></span>{{tli.fromstationid}}</li>
                                            <li><span><b>To stationId : </b></span>{{tli.tostationid}}</li>
                                            <li><span><b>Depature Time : </b></span>{{tli.depaturetime}}</li>
                                            <li><span><b>ArivalTime : </b></span>{{tli.arivaltime}}</li>
                                            <li><span><b>Day off Train: </b></span>{{tli.dayoff}}</li>
                                            <li><span><b>Day Train: </b></span>${d}</li>
                                            

                                        </ul>
                                    </td>
                                   <td> 
                                    <a href="buyticet?gettid={{tli.trainid}}"><button id="editbuttons"
                                                                                                      type="submit" class="btn">Buy Ticket</button></a>
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

