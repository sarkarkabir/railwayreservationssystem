<%-- 
    Document   : addreservationdetails
    Created on : Dec 9, 2018, 11:50:19 PM
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
            var reservationdetaillist = ${reservationdetaillist};
            var reservationslist = ${reservationslist};
            var compartservicelist = ${compartservicelist};
            var farechartslist = ${farechartslist};
           console.log(reservationdetaillist);

            angular.module('Sarkarsujan', []).controller('ProductController',
                    function ($scope) {
                        $scope.reservationdetaillist = reservationdetaillist;
                        $scope.reservationslist = reservationslist;
                        $scope.compartservicelist = compartservicelist;
                        $scope.farechartslist = farechartslist;
                       
                        console.log($scope.reservationdetaillist);
                    });
        </script>
    </head>
    <body ng-app="Sarkarsujan" ng-controller="ProductController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Add Reservation Details</span>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="newreservationdetailsObject" action="reservationDetailsadd"
                                   enctype="multipart/form-data">
                            <c:if test="${check}">
                                <div class="form-group">

                                    <form:input class="form-control" Placeholder="ReservationDetails Id"
                                                type="text" path="resdetid" required="true"></form:input>
                                </div>
                            </c:if>
                            <c:if test="${!check}">
                                <div class="form-group">
                                    <form:input class="form-control" Placeholder="ReservationDetails Id"
                                                type="text" path="resdetid" readonly="true" required="true"></form:input>
                                </div>
                            </c:if>
                               
                                <div class="form-group">
                                <select class="form-control" ng-model="resid" ng-options=" x.resid  as x.resid for x in reservationslist">
                                    <option value="">-- choose an option --</option>
                                </select>
                                    
                                </div>
                            <div class="form-group">
                                <form:hidden  class="form-control" value="{{resid}}" path="resid"></form:hidden>
                                </div>
                              
                              
                                <div class="form-group">
                                <select class="form-control" ng-model="comsubid" ng-options="x.comsubid as x.comname for x in compartservicelist" required="true">
                                    <option value="">-- choose an option --</option>
                                </select>
                                </div>
                                <div class="form-group">
                                <form:hidden  class="form-control" value="{{comsubid}}" path="comsubid"></form:hidden>
                                </div>
                                <div class="form-group">
                                <select class="form-control" ng-model="fareid" ng-options="x.fareid as x.fareid for x in farechartslist" required="true">
                                    <option value="">-- choose an option --</option>
                                </select>
                                </div>
                                <div class="form-group">
                                <form:hidden  class="form-control" value="{{fareid}}" path="fareid"></form:hidden>
                                </div>
                                
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="seatno" placeholder="Seat No" required="true"></form:input>
                                </div>
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="journeydate" placeholder="Journeydate" required="true"></form:input>
                                </div>
                                
                                
                               
                            <c:if test="${check}">
                                <form:button id="editbuttons" type="submit" name="AddReservationD" class="btn">Add
                                    Details</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>
                            </c:if>
                            <c:if test="${!check}">
                                <form:button id="editbuttons" type="submit" name="EditReservationD" class="btn">Edit
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
                    <span class="lead">Fare List</span>
                </div>
                <p><input type="text" ng-model="test" class="form-control" placeholder="Search reserve"></p>
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="reservedetail in reservationdetaillist| filter:test">
                            <table style="width: 100%">
                                <tr>
                                  
                                    <td>
                                        <ul>
                                            <li><span><b>reservationdetails Id: </b></span>{{reservedetail.resdetid}}</li>
                                            <li><span><b>reservation Id </b></span>{{reservedetail.resid}}</li>
                                            <li><span><b>CompartSubid : </b></span>{{reservedetail.comsubid}}</li>
                                            <li><span><b>Fare Id: </b></span>{{reservedetail.fareid}}</li>
                                            <li><span><b>Seat No : </b></span>{{reservedetail.seatno}}</li>
                                            <li><span><b>Journey Date: </b></span>{{reservedetail.journeydate}}</li>
                                          
                                        </ul>
                                    </td>
                                    <td><a href="editingreservationdet?getrdid={{reservedetail.resdetid}}"><button id="editbuttons"
                                                                                                      type="submit" class="btn">Edit</button></a> <a
                                            href="removingreservationDet/{{reservedetail.resdetid}}"><button id="removebuttons"
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
                                                            var date_input = $('input[name="journeydate"]'); //our date input has the name "date"
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


