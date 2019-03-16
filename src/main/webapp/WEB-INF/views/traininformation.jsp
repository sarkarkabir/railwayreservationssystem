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
            var traininforlist = ${traininforlist};
            var stationserlist = ${stationserlist};
            
     
            angular.module('kabirinfo', []).controller('TrainControllers',
                    function ($scope) {
                        $scope.traininforlist = traininforlist;
                        $scope.stationserlist = stationserlist;
                       
                        console.log($scope.traininforlist);
                    });
        </script>
    </head>
    <body ng-app="kabirinfo" ng-controller="TrainControllers">
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

                        <form:form commandName="addtraininfoObject1" action="addingtraininfo"
                                   enctype="multipart/form-data">
                            <c:if test="${check}">
                                <div class="form-group">

                                     <form:input class="form-control" Placeholder="Train  Id"
                                                type="text" path="trainid" required="true"></form:input>
                                </div>
                            </c:if>
                            <c:if test="${!check}">
                                <div class="form-group">
                                   <form:input class="form-control" Placeholder="Train Id"
                                                type="text" path="trainid" readonly="true" required="true"></form:input>
                                </div>
                            </c:if>
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="trainnumber" placeholder="Train number" required="true" id="name" ></form:input>

                                </div>
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="trainname" placeholder="Train name" required="true" id="name" ></form:input>

                                </div>

                                <div class="form-group">
                                    <select class="form-control" ng-model="fromstationid" ng-options="x.stationname as x.stationname for x in stationserlist" required="true">
                                        <option value="">-- choose an option --</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                <form:hidden  class="form-control" value="{{fromstationid}}" path="fromstationid"></form:hidden>
                                </div>


                                <div class="form-group">
                                    <select class="form-control" ng-model="tostationid" ng-options="x.stationname as x.stationname for x in stationserlist" required="true">
                                        <option value="">-- choose an option --</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                <form:hidden  class="form-control" value="{{tostationid}}" path="tostationid"></form:hidden>
                                </div>
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="depaturetime" placeholder="depature time"  ></form:input>

                                </div>
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="arivaltime" placeholder="arival time "  ></form:input>

                                </div>
                                <div class="form-group">
                                                <label>Off days</label>
                                            <form:select path="dayoff">
                                                <form:option value="NONE" label="--- Select ---"/>

                                                <form:option value="Saturday" label="Saturday"/>
                                                <form:option value="Sunday" label="Sunday"/>
                                                <form:option value="Monday" label="Monday"/>
                                                <form:option value="Tuesday" label="Tuesday"/>
                                                <form:option value="Wednesday" label="Wednesday"/>
                                                <form:option value="Thursday" label="Thursday"/>
                                                <form:option value="Friday" label="Friday"/>
                                            </form:select>
                                        </div>
                                
                               
                               
                            <c:if test="${check}">
                                <form:button id="editbuttons" type="submit" name="AddTrain" class="btn">Add
                                    Details</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>
                            </c:if>
                            <c:if test="${!check}">
                                <form:button id="editbuttons" type="submit" name="EditTrain" class="btn">Edit
                                    Details</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>
                            </c:if>
                            
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
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="railways in traininforlist| filter:test">
                            <table style="width: 100%">
                                <tr>
                                    
                                    <td>
                                        <ul>
                                           <li><span><b>Train  Id: </b></span>{{railways.trainid}}</li>
                                            <li><span><b>Train Number: </b></span>{{railways.trainnumber}}</li>
                                            <li><span><b>Train name: </b></span>{{railways.trainname}}</li>
                                            <li><span><b>From stationId : </b></span>{{railways.fromstationid}}</li>
                                            <li><span><b>To stationId : </b></span>{{railways.tostationid}}</li>
                                            <li><span><b>Depature Time : </b></span>{{railways.depaturetime}}</li>
                                            <li><span><b>ArivalTime : </b></span>{{railways.arivaltime}}</li>
                                            <li><span><b>Day Train: </b></span>{{railways.dayoff}}</li>
                                           
                                        </ul>
                                    </td>
                                    <td><a href="edittrainfobutton?gettid={{railways.trainid}}"><button id="editbuttons"
                                                                                                     type="submit" class="btn">Edit</button></a> <a
                                            href="removetraininfo/{{railways.trainid}}"><button id="removebuttons"
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
                                                            var date_input = $('input[name="dayoff"]'); //our date input has the name "date"
                                                           
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
