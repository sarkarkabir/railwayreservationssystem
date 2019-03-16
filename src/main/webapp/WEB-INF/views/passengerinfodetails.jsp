<%-- 
    Document   : passengerinfodetails
    Created on : Dec 1, 2018, 12:15:16 AM
    Author     : dhaka
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">

            .form-control:FOCUS
            {
                border: 2px solid #9ccc65;
                border-radius: 5px;
            }

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
            .list-group-item {
                overflow: hidden;
                margin: 3px;
                border-radius: 3px;
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
            var cat = ${passinfomodelobject};
            console.log(cat);
            angular.module('myappp', []).controller('CategoryControllerr',
                    function ($scope) {
                        $scope.Catagorys = cat;
                    });
        </script>

    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 80%; margin-top: 10px; margin-bottom: 10px">
            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">passenger information</span>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer">
                        <c:if test="${check}">
                            <form:form name="addpassengerObject"
                                       modelAttribute="addPassengerinfoObject1" action="addingpassengerinfo"
                                       method="post">

                                <div class="form-group">
                                    <form:input class="form-control"
                                                Placeholder="passenger Id" type="text" path="passid" ></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input class="form-control"
                                                Placeholder="passenger Name" type="text" path="passname" required="true"></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input type="text" class="form-control"
                                                placeholder="passenger address" path="passadd" required="true"></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input class="form-control"
                                                Placeholder="passenger dateof birth" type="text" path="passdob" required="true"></form:input>
                                    </div>

                                    <div class="form-group">
                                        <lable>passgenger gender</lable>
                                        <lable class="radio-inline">
                                        <form:radiobutton path="passgender" value="Male"/>Male</label>


                                        <label class="radio-inline" >   <form:radiobutton path="passgender" value="Female"/>Female</lable>


                                </div>
                                        <div class="form-group">
                                    <form:input type="text" class="form-control"
                                                placeholder="passenger regdate"  path="regdate"></form:input>
                                    </div>
                                <div class="form-group">
                                    <form:input type="text" class="form-control"
                                                placeholder="passenger status" path="passstatus" required="true"></form:input>
                                    </div>
                                    <div class="form-group" >
                                    <form:input class="form-control"
                                                Placeholder="passenger Email" type="text" path="passemail" value="${UserId}" required="true"></form:input>
                                    </div>
                                <form:button id="editbuttons" type="submit" name="AddPassengerinfo"
                                             class="btn">Add passengerinfo</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>

                            </form:form>
                        </c:if>

                        <c:if test="${!check}">
                            <form:form name="addpassengerObject"
                                       modelAttribute="addPassengerinfoObject1" action="addingpassengerinfo"
                                       method="post">
                                <div class="form-group">
                                    <form:input id="name" class="form-control"
                                                Placeholder="passenger Id" type="text" path="passid" readonly="true"></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input id="name" class="form-control"
                                                Placeholder="passenger Name" type="text" path="passname"></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input type="text" class="form-control"
                                                placeholder="passenger address" path="passadd"></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input id="name" class="form-control"
                                                Placeholder="passenger dateof birth" type="text" path="passdob" readonly="true"></form:input>
                                    </div>
                                    <div class="form-group">
                                        <lable>passgenger gender</lable>
                                        <lable class="radio-inline">
                                        <form:radiobutton path="passgender" value="Male"/>Male</label>


                                        <label class="radio-inline" >   <form:radiobutton path="passgender" value="Female"/>Female</lable>


                                </div>
                                <div class="form-group">
                                    <form:input type="text" class="form-control"
                                                placeholder="passenger regdate"  path="regdate"></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input type="text" class="form-control"
                                                placeholder="passenger status" path="passstatus"></form:input>
                                    </div>
                                    <div class="form-group" >
                                    <form:input id="name" class="form-control"
                                                Placeholder="user email" value="${UserId}" type="text" path="passemail" readonly="true"></form:input>
                                    </div>

                                <form:button id="editbuttons" type="submit" name="EditPassengerinfo"
                                             class="btn">Edit passengerinfo</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>
                            </form:form>
                        </c:if>
                    </div>
                </div>
                <!-- panel1 body end -->
            </div>
            <!-- panel1 end -->
            <div class="panel animated fadeInUp delay-05s" id="panel-2">
                <div class="panel-heading">
                    <span class="lead">List Of passengerinformation</span>
                </div>
                <!-- end panel2 heading -->
                <div class="panel-body" ng-app="myappp"
                     ng-controller="CategoryControllerr" width="100%">
                    <ul class="list-group ">
                        <li class="list-group-item" height="45px"
                            ng-repeat="Cat in Catagorys">
                            <div class="pull-left">
                                <ul class="list-inline">
                                    <li><span><b>passenger Id: </b></span>{{Cat.passid}}</li>
                                    <li><span><b>passenger  Name: </b></span>{{Cat.passname}}</li>
                                    <li><span><b>passenger address </b></span>{{Cat.passadd}}</li>
                                    <li><span><b>passenger dob: </b></span>{{Cat.passdob}}</li>
                                    <li><span><b>passenger gender </b></span>{{Cat.passgender}}</li>
                                    <li><span><b>passenger Regdate </b></span>{{Cat.regdate}}</li>
                                    <li><span><b> Passengerstatus </b></span>{{Cat.passstatus}}</li>
                                </ul>
                            </div>
                            <div class="pull-right">
                                <a href="editpassengerinfobutton?getcid={{Cat.passid}}"><button id="editbuttons"
                                                                                                type="submit" class="btn">Edit</button></a> 

                                <a  href="removepassengerinfoid/{{Cat.passid}}"><button  id="removebuttons"
                                                                                         type="button" class="btn">Remove</button></a>
                            </div>
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
                                           var date_input = $('input[name="passdob"]'); //our date input has the name "date"

                                           var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                           date_input.datepicker({
                                               format: 'yyyy/mm/dd',
                                               container: container,
                                               todayHighlight: true,
                                               autoclose: true,
                                           })
                                       })
                                       $(document).ready(function () {
                                           var date_input = $('input[name="regdate"]'); //our date input has the name "date"

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

