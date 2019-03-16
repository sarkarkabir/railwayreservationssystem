<%-- 
    Document   : buyticketpassenger
    Created on : Dec 15, 2018, 6:38:53 PM
    Author     : C5
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add buy seat Page</title>

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
            var traininforlist = ${traininforlist};
            var reservartionslist=${reservartionslist};
             var stationserlist = ${stationserlist};
            var compartmentlist=${compartmentlist};
           
    //console.log(stationserlist);
            angular.module('SearchOne2', []).controller('SearchOneControllers2',
                    function ($scope) {
                        $scope.traininforlist = traininforlist;
                        $scope.reservartionslist = reservartionslist;
                         $scope.stationserlist = stationserlist;
                        $scope.compartmentlist = compartmentlist;
                        
                       


                        console.log($scope.traininforlist);
                    });
        </script>

    </head>
    <body ng-app="SearchOne2" ng-controller="SearchOneControllers2">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">purchase seat</span>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="viewtrainlistc" action="reservationpage"
                                   enctype="multipart/form-data">

                                
                                <div class="form-group">
                                <form:input  class="form-control"  path="adult" placeholder="Number of adult" required="true" ></form:input>

                                </div>
<!--                                 
-->                                <div class="form-group">
                                <form:input class="form-control"   path="child" placeholder="Number of Child" required="true" ></form:input>

                                </div>
                               
                                <div class="form-group">
                                <form:input class="form-control" type="text"  path="d"  value="${d}"  ></form:input>

                                </div>
                                <form:hidden path="trainid" value="${traininforlistsp.trainid}"></form:hidden>
                                
                                <form:hidden path="trainnumber" value="${traininforlistsp.trainnumber}"></form:hidden>
                                
                                <form:hidden path="fromstationid" value="${traininforlistsp.fromstationid}"></form:hidden>

                                <form:hidden path="tostationid" value="${traininforlistsp.tostationid}"></form:hidden>
                                
                                <form:hidden path="depaturetime" value="${traininforlistsp.depaturetime}"></form:hidden>
                                
                                <form:hidden path="arivaltime" value="${traininforlistsp.arivaltime}"></form:hidden>
                               
                               

                                <form:hidden path="d" value="${d}"></form:hidden>

                          
                           <button id="editbuttons" type="submit" class="btn">Buy seat</button>                


                        </form:form>
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
<!--                  end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            >
                            <table style="width: 100%">
                                <tr>

                                    <td>
                                        <ul>
                                            <li><span><b>Train Id: </b></span>${traininforlistsp.trainid}</li>
                                            <li><span><b>Train Number: </b></span>${traininforlistsp.trainnumber}</li>
                                            <li><span><b>Train name: </b></span>${traininforlistsp.trainname}</li>
                                            <li><span><b>From stationId : </b></span>${traininforlistsp.fromstationid}</li>
                                            <li><span><b>To stationId : </b></span>${traininforlistsp.tostationid}</li>
                                            <li><span><b>Depature Time : </b></span>${traininforlistsp.depaturetime}</li>
                                            <li><span><b>ArivalTime : </b></span>${traininforlistsp.arivaltime}</li>
                                            <li><span><b>Day Train: </b></span>${traininforlistsp.dayoff}</li><!--
                                            <li><span><b> adult person: </b></span>{{tli.adult}}</li>
                                            <li><span><b>child person: </b></span>{{tli.child}}</li>-->
                                        </ul>
                                    </td>
                                    
                                </tr>
                            </table>
                        </li>
                    </ul>
                </div>
<!--                 panel2 body end -->
            </div>

            <!-- panel2 end -->
        </div>

        <jsp:include page="footer.jsp" />

        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <script>
                $(document).ready(function () {
                    var date_input = $('input[name="d"]'); //our date input has the name "date"

                    var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                    date_input.datepicker({
                        format: 'yyyy/mm/dd',
                        container: container,
                        todayHighlight: true,
                        autoclose: true,
                    })
                })
        </script>


    </body>
</html>
