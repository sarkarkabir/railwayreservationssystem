<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html lang="zxx">

    <head>
        <title>login form</title>
        <!-- Meta tag Keywords -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="UTF-8" />
        <meta name="keywords" content="Validify Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"
              />
        <script>
            addEventListener("load", function () {
                setTimeout(hideURLbar, 0);
            }, false);

            function hideURLbar() {
                window.scrollTo(0, 1);
            }
        </script>
        <!-- Meta tag Keywords -->
        <!-- css files -->
        <link rel="stylesheet" href="resources/loginplugs/css/style.css" type="text/css" media="all" />
        <!-- Style-CSS -->
        <link rel="stylesheet" href="resources/loginplugs/css/fontawesome-all.css">
        <!-- Font-Awesome-Icons-CSS -->
        <!-- //css files -->
        <!-- web-fonts -->
        <link href="resources/loginplugs/fonts.googleapis.com/css?family=Nova+Round" rel="stylesheet">
        <link href="resources/loginplugs/fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <!-- //web-fonts -->
    </head>

    <body>
        <!-- title -->
        <h1>
            <span>R</span>ailway 
            <span>S</span>ign in 
            <span>L</span>ogin
            <span>F</span>orm
        </h1>
        <!-- //title -->
        <!-- content -->
        <div class="sub-main-w3">
            <form id="demo"  novalidate action="perform_login" method="post">
                <h2>Login Your Account</h2>
                <div class="form-group">
                    <input type="email" class="form-control textbox" name="usename"  placeholder="E-mail" required="true">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control textbox" name="userpassword" placeholder="Password" required="true">
                </div>
                <div class="form-group-2">
                    <a href="login"><button class="btn btn-success" type="submit">Login</button></a>  
                </div>
            </form>
        <!-- //switch -->
    </div>
        <p align="center" class="fa-anchor">if you are not user please signup first</p>
        <div align="center">
            <form id="demo" action="signup">
                                    <a href="signup"><button class="btn btn-success"  >Signup</button></a> 	           
            </form>
        </div>
    <!-- //content -->

    <!-- copyright -->
    <div class="footer">
        <p>&copy; 2018 Validify Login Form. All rights reserved | Design by
            <a href="railwayreservationssystem.com">railwayreservation</a>
        </p>
    </div>
    <!-- //copyright -->

    <!-- Jquery -->
    <script src="resources/loginplugs/js/jquery-2.2.3.min.js"></script>
    <!-- //Jquery -->
    <!-- validify plugin -->
    <script src="resources/loginplugs/js/validify.js"></script>
    <!--	<script>
                    $("#demo").validify({
                            onSubmit: function (e, $this) {
                                    $this.find('.alert').removeClass('hidden')
                            },
                            onFormSuccess: function (form) {
                                    console.log("Form is valid now!")
                            },
                            onFormFail: function (form) {
                                    console.log("Form is not valid :(")
                            }
                    });
                    $("#demo").validify({
                            errorStyle: "validifyError",
                            successStyle: "validifySuccess",
                            emailFieldName: "email",
                            emailCheck: true,
                            requiredAttr: "required",
                    });
            </script>-->
    <!-- //validify plugin -->

</body>

</html>