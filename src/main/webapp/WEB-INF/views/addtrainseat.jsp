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
            var trainseatlist = ${trainseatlist};
            var traininfolist = ${traininfolist};
            var comtypelist = ${comtypelist};

            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                        $scope.trainseatlist = trainseatlist;
                        $scope.traininfolist = traininfolist;
                        $scope.comtypelist = comtypelist;
                        console.log($scope.traininfolist);
                    });
        </script>
    </head>
    <body ng-app="organocartpackage" ng-controller="ProductController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Train Seat Manage</span>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="newtrainObject" action="trainseatadd"
                                   enctype="multipart/form-data">
                            <c:if test="${check}">
                                <div class="form-group">

                                    <form:input class="form-control" Placeholder="Seat Id"
                                                type="text" path="seatid" required="true"></form:input>
                                </div>
                            </c:if>
                            <c:if test="${!check}">
                                <div class="form-group">
                                    <form:input class="form-control" Placeholder="Seat Id"
                                                type="text" path="seatid" readonly="true" required="true"></form:input>
                                </div>
                            </c:if>
                                <div class="form-group">
                                <select class="form-control" ng-model="tid" ng-options="x.trainid as x.trainname for x in traininfolist" required="true">
                                    <option value="">-- choose an option --</option>
                                </select>
                                </div>
                                <div class="form-group">
                                <form:hidden  class="form-control" value="{{tid}}" path="trainid"></form:hidden>
                                </div>
                                
                               
                                <div class="form-group">
                                <select class="form-control" ng-model="comid" ng-options="x.comtypeid as x.comname for x in comtypelist" required="true">
                                    <option value="">-- choose an option --</option>
                                </select>
                                </div>
                                <div class="form-group">
                                <form:hidden  class="form-control" value="{{comid}}" path="comtypeid"></form:hidden>
                                </div>
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="noofcompartment" placeholder="compartment" required="true" id="name" ></form:input>

                                </div>
                                
                               
                               
                            <c:if test="${check}">
                                <form:button id="editbuttons" type="submit" name="Add" class="btn">Add
                                    Details</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>
                            </c:if>
                            <c:if test="${!check}">
                                <form:button id="editbuttons" type="submit" name="Edit" class="btn">Edit
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
                    <span class="lead">Products List</span>
                </div>
                <p><input type="text" ng-model="test" class="form-control" placeholder="Search Product"></p>
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="product in trainseatlist| filter:test">
                            <table style="width: 100%">
                                <tr>
                                    
                                    <td>
                                        <ul>
                                            <li><span><b>Seat Id: </b></span>{{product.seatid}}</li>
                                            <li><span><b>Train Id: </b></span>{{product.trainid}}</li>
                                            <li><span><b>Compartment id: </b></span>{{product.comtypeid}}</li>
                                            <li><span><b>Component number: </b></span>{{product.noofcompartment}}</li>
                                           
                                        </ul>
                                    </td>
                                    <td><a href="editingtrainseat?gettid={{product.seatid}}"><button id="editbuttons"
                                                                                                      type="submit" class="btn">Edit</button></a> <a
                                            href="removingtrainseat/{{product.seatid}}"><button id="removebuttons"
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


       
    </body>
</html>
