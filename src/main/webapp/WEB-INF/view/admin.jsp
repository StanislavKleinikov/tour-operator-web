<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<title>Admin</title>

</head>
<body>
	<h1>Welcome Admin</h1>
	<div class="container">
		<div class="form-group">
			<a type="button" onclick="editNews()"  class="btn btn-success" >Edit News</a>
			<a type="button" onclick="editUsers()" class="btn btn-success" >Edit Users</a>
			<a type="button" onclick="editTours()" class="btn btn-success" >Edit Tours</a>
		</div>
		<div class="container content border">
			Content will be here
		</div>
	
	</div>
	      
	<script type="text/javascript">
        function editNews() {
            $.ajax({
                type: "POST",
                url: "editNews",
                success: function (data) {
                    $(".content").html(data);
                }
            });
        }
        function editUsers() {
			$.ajax({
                type: "POST",
                url: "editUsers",
                success: function (data) {
                    $(".content").html(data);
                }
            });
		}
		function editTours() {
			$.ajax({
                type: "POST",
                url: "editTours",
                success: function (data) {
                    $(".content").html(data);
                }
            });
		}
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>		
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>