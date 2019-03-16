<!DOCTYPE html>
<html lang="en">
<head>
	<title>RailwayLogin</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="resources/loginplug/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginplug/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginplug/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginplug/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginplug/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/loginplug/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginplug/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginplug/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/loginplug/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginplug/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/loginplug/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
                    
			<div class="wrap-login100">
                            
				<form action="perform_login" method="post" class="login100-form validate-form">
					<span class="login100-form-title p-b-34">
                                            <p>WELCOME TO BANGLADESH RAILWAY E-TICKETING SERVICE
Purchasing tickets through Internet is another convenient way to travel with Bangladesh Railway. Register yourself with your cell phone number, book online and your ticket details will then be emailed to you instantly after payment through your any VISA/MASTER, DBBL Nexus/VISA/MASTER/Mobile Banking and City bank Amex cards. Print it out and bring it along with your valid Identity card to the station at least 15 minutes prior to your journey. If you purchase e-ticket for other persons, you have to print out hard copy of e-ticket from designated counters of any online stations. </p>
						Railway user Login
					</span>
					
					<div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
						<input id="first-name" class="input100" type="text" name="usename" placeholder="User name">
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
						<input class="input100" type="password" name="userpassword" placeholder="Password">
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Sign in
						</button>
					</div>

					<div class="w-full text-center p-t-27 p-b-239">
						<span class="txt1">
							Forgot
						</span>

						<a href="signup" class="txt2">
							User name / password?
						</a>
					</div>

					<div class="w-full text-center">
						<a href="signup" class="txt3">
							Sign Up
						</a>
					</div>
				</form>

				<div class="login100-more" style="background-image: url('resources/loginplug/images/t.jpg');"></div>
			</div>
		</div>
	</div>
	
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="resources/loginplug/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginplug/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginplug/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/loginplug/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginplug/vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>
<!--===============================================================================================-->
	<script src="resources/loginplug/vendor/daterangepicker/moment.min.js"></script>
	<script src="resources/loginplug/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginplug/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginplug/js/main.js"></script>

</body>
</html>