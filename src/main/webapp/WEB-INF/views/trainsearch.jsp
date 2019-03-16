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
    //console.log(stationserlist);
            angular.module('SearchOne', []).controller('SearchOneControllers',
                    function ($scope) {
                        $scope.Traininforlist = traininforlist;
                        $scope.stationserlist = stationserlist;


                        console.log($scope.traininforlist);
                    });
        </script>

    </head>
    <body ng-app="SearchOne" ng-controller="SearchOneControllers">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Search list</span>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="addsearchoneObject" action="availableforaddtrainpage"
                                   enctype="multipart/form-data">


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
                                <form:input type="text" class="form-control"  path="d" placeholder="journey date" required="true" ></form:input>

                                </div>




                            <form:button id="editbuttons" type="submit"  class="btn">SearchTrain</form:button>
                            <form:button id="removebuttons" type="reset" class="btn">Reset
                                Details</form:button>


                        </form:form>
                    </div>
                    <!-- panel body end -->
                </div>
            </div>
            <!-- panel end -->

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
