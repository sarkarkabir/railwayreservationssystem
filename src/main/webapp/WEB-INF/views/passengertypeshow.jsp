

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
            var cat = ${passtypeshowmodelobject};
            console.log(cat);
            angular.module('myappt', []).controller('CategoryControllert',
                    function ($scope) {
                        $scope.Catagoryt = cat;
                    });
        </script>
        
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 80%; margin-top: 10px; margin-bottom: 10px">
            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Passenger Type</span>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer">
                        <c:if test="${check}">
                            <form:form name="addPassegerObject"
                                       modelAttribute="addPassengersObject1" action="addingpassengerty"
                                       method="post">
                                <div class="form-group">
                                    <form:input class="form-control"
                                                Placeholder="passenger typeid" type="text" path="passtypeid" ></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input class="form-control"
                                                Placeholder="Category Name" type="text" path="passtype" required="true"></form:input>
                                    </div>
                                     
                                <form:button id="editbuttons" type="submit" name="Addpassengertype"
                                             class="btn">Add Category</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>

                            </form:form>
                        </c:if>

                        <c:if test="${!check}">
                            <form:form name="addPassegerObject"
                                       modelAttribute="addPassengersObject1" action="addingpassengerty"
                                       method="post">
                                <div class="form-group">
                                    <form:input id="name" class="form-control"
                                                Placeholder="passenger typeId" type="text" path="passtypeid" readonly="true"></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input id="name" class="form-control"
                                                Placeholder="passenger type" type="text" path="passtype"></form:input>
                                    </div>
                                    
                                <form:button id="editbuttons" type="submit" name="Editpassengertype"
                                             class="btn">Edit passtype</form:button>
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
                    <span class="lead">List Of passengertype</span>
                </div>
                <!-- end panel2 heading -->
                <div class="panel-body" ng-app="myappt"
                     ng-controller="CategoryControllert" width="100%">
                    <ul class="list-group ">
                        <li class="list-group-item" height="45px"
                            ng-repeat="Cat in Catagoryt">
                            <div class="pull-left">
                                <ul class="list-inline">
                                    <li><span><b>Passenger typeId: </b></span>{{Cat.passtypeid}}</li>
                                    <li><span><b>Passenger type: </b></span>{{Cat.passtype}}</li>
                                   
                                </ul>
                            </div>
                            <div class="pull-right">
                                <a href="editremovepassengertbutton?getcid={{Cat.passtypeid}}"><button id="editbuttons"
                                                                                          type="submit" class="btn">Edit</button></a> 
                                                                                        
                                   <a  href="removepassengerst/{{Cat.passtypeid}}"><button  id="removebuttons"
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
    </body>
</html>
