<%-- 
    Document   : addreservation
    Created on : Dec 9, 2018, 10:21:26 PM
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
            var reservationlist = ${reservationlist};
            var passerngerinfolist = ${passerngerinfolist};

            var compartmentlist = ${compartmentlist};

            angular.module('reservationspackege', []).controller('ResecomorveController',
                    function ($scope) {
                        $scope.reservationlist = reservationlist;
                        $scope.passerngerinfolist = passerngerinfolist;

                        $scope.compartmentone = compartmentlist;
                    });
        </script>
    </head>
    <body ng-app="reservationspackege" ng-controller="ResecomorveController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Add Reservation</span>
                </div>




                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">
                        <form:form commandName="newreservationObject" action="reservationadd"
                                   enctype="multipart/form-data">
                            <div class="form-group">
                                <lable>reservation id</lable> 
                                    <form:input class="form-control" 
                                                type="text" path="resid" ></form:input>
                                </div>
                                <div class="form-group">
                                    <lable>passenger id</lable> 
                                    <form:input class="form-control" 
                                                type="text" path="passid"  ></form:input>
                                </div>

                                <div class="form-group">
                                    <lable>Reservation date</lable> 
                                    <form:input type="text" class="form-control"  path="resdate"  required="true"></form:input>
                                </div>
                                <div class="form-group">
                                    <lable>ptn number</lable>
                                    <form:input type="text" class="form-control"  path="ptn" required="true"></form:input>
                                </div>
                                <div class="form-group">
                                    <lable>Reservation Status</lable>
                                    <form:input type="text" class="form-control"  path="resstatus" ></form:input>
                                </div>

                                <div class="form-group">
                                    <select class="form-control" ng-model="comtypeid" ng-options=" x.comtypeid as x.comname   for x in compartmentlist" required="true">
                                        <option value="">-- choose an option --</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                <form:hidden  class="form-control" value="{{comtypeid}}" path="comtypeid"></form:hidden>
                                </div>
                                <div class="form-group">
                                    <lable>Trainid</lable> 
                                    <form:input class="form-control"  path="trainid" value="${trainsid}"  ></form:input>

                                </div>

                                <div class="form-group">
                                    <lable>Fromstation Name</lable>
                                    <form:input class="form-control"   path="fromstationid" value="${fromstationid}"  ></form:input>

                                </div>
                                <div class="form-group">
                                    <lable>Tostation Name</lable>
                                    <form:input class="form-control"   path="tostationid" value="${tostationid}"  ></form:input>

                                </div>
                                <div class="form-group">
                                    <lable>depature time</lable> 
                                    <form:input class="form-control"   path="depaturetime"  value="${dtime}" ></form:input>

                                </div>

                                <div class="form-group">
                                    <lable>arivaltime</lable> 
                                    <form:input class="form-control"   path="arivaltime" value="${atime}"  ></form:input>


                                </div>
                                <div class="form-group">
                                    <lable>Adult seat</lable>
                                    <form:input type="text" class="form-control" value="${adltseat}"  path="adult" placeholder="Adult persion" required="true"></form:input>
                                </div>
                                <div class="form-group">
                                    <lable>child seat</lable>
                                    <form:input type="text" class="form-control" value="${childs}"  path="child" placeholder="child persion" required="true"></form:input>
                                </div>
                                <div class="form-group">
                                    <lable>user email</lable> 
                                    <form:input class="form-control"   path="emailid"  value="${UserId}" ></form:input>

                                </div>
                                <div class="form-group">
                                    <lable>Journey Date</lable> 
                                    <form:input class="form-control"   path="d"  value="${d}"  ></form:input>

                                </div>








                                <a href="#"><button id="editbuttons" type="submit" name="AddReser" class="btn">confirm</button></a>                


                        </form:form>

                    </div>
                    <!-- panel body end -->
                </div>
            </div>
            <!-- panel end -->
            <div class="panel animated fadeInUp delay-05s" id="panel-2">
                <div class="panel-heading">
                    <span class="lead">reserve list</span>
                </div>
                <p><input type="text" ng-model="test" class="form-control" placeholder="Search reserve"></p>
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="R in reservationlist| filter:test">
                            <table style="width: 100%">
                                <tr>

                                    <td>
                                        <ul>
                                            <li><span><b>Reservation Id: </b></span>{{R.resid}}</li>
                                            <li><span><b>Train Id: </b></span>${R.passid}</li>
                                            <li><span><b>Reservation Date: </b></span>${R.resdate}</li>
                                            <li><span><b>Train Number: </b></span>${R.trainnumber}</li>
                                            <li><span><b>Train name: </b></span>${R.traininforlistsp.trainname}</li>
                                            <li><span><b>From stationId : </b></span>${traininforlistsp.fromstationid}</li>
                                            <li><span><b>To stationId : </b></span>${traininforlistsp.tostationid}</li>
                                            <li><span><b>Depature Time : </b></span>${traininforlistsp.depaturetime}</li>
                                            <li><span><b>ArivalTime : </b></span>${traininforlistsp.arivaltime}</li>
                                            <li><span><b>Journey date: </b></span>${traininforlistsp.dayoff}</li>

                                        </ul>
                                    </td>
                                    <td><a href="editingreservation?getrid={{reserve.resid}}"><button id="editbuttons"
                                                                                                      type="submit" class="btn">Edit</button></a> <a
                                            href="removingreservation/{{reserve.resid}}"><button id="removebuttons"
                                                                                             type="button" class="btn">Remove</button></a></td>
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
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <script>
                                                        $(document).ready(function () {
                                                            var date_input = $('input[name="resdate"]'); //our date input has the name "date"
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

