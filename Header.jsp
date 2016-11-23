<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<style>
<
script>var app = angular.module ('myApp ', [] ); function MyController 
	($scope, $http ) { $scope .sortType = 'name '; //
	set the default sort type $scope.sortReverse = false ; // set the
	default sort order $scope.searchBTitle = ''; $scope .getDataFromServer
	 = function () { $http ({ method :'GET', url : 'GsonCon'
	
}
)
.success
 
(
function
(data,status,headers,config)
{
$scope.prod=data;
}
)
.error
 
(function
(data,status,headers,config)
{
//
called

	
asynchronously
 
if
 
an
 
error
 
occurs
//
 
or
 
server
 
returns
 
response
 
with
 
an

	
error
 
status
.

	

}
);
}
;
}
;
</
script
>
</style>

</head>
<body bgcolor="#E6E6FA">
	<c:choose>
		<c:when test="${isAdmin==1 }">


			<nav class="navbar navbar-light" style="background-color: #80bfff;">
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${empty loggedInUser}">
						
						<input class="form-control" type="text" placeholder="Search">

							<li><a href="#"><span class="glyphicon glyphicon-search"></span>
									search</a></li>

							<li><a href="memberShip.obj"><span
									class="glyphicon glyphicon-user"></span> Sign Up</a></li>
							<li><a href="Signin"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>

						</c:when>
						<c:when test="${not empty loggedInUser}">
							<td>Welcome ${loggedInUser}</td>
							<li><a href="perform_logout"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</c:when>
					</c:choose>

				</ul>
			</nav>
			<div class="jumbotron">
				<div class=center>

					<c:if test="${Page1==1 }">
						<center>
							<h1>Hello, Admin!</h1>
							<p>click here to make your changes</p>
							<span class="glyphicon glyphicon-hand-down"></span>
						</center>
					</c:if>

					<center>



						<div class="container">
							<a href="category" class="btn btn-info" role="button">Category</a>
							<a href="product" class="btn btn-info" role="button">Product</a>
							<a href="supplier" class="btn btn-info" role="button">Supplier</a>
					</center>
				</div>
			</div>
		



		</c:when>
		<c:otherwise>
			<nav class="navbar navbar-light" style="background-color: #80bfff;">

				<div class="container-fluid">

					<div class="navbar-header">
						<a class="navbar-brand" href="#"> <img src="resources/images/H1.jpg" style="width:100px;height:100px;"></a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="HomePage.jsp">Home</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Books <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Education</a></li>
								<li><a href="#">Literature</a></li>
								<li><a href="#">Spirutuality</a></li>
								<li><a href="#">Philosophy</a></li>
								<li><a href="#">Relationships</a></li>
								<li><a href="#">Business</a></li>
								<li><a href="#">Comics</a></li>
							</ul></li>








						<li><a href="products">Products</a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${empty loggedInUser}">

							
								<li><a href="memberShip.obj"><span
										class="glyphicon glyphicon-user"></span> Sign Up</a></li>
								<li><a href="Signin"><span
										class="glyphicon glyphicon-log-in"></span> Login</a></li>

							</c:when>
							<c:when test="${not empty loggedInUser}">
								<td>Welcome ${loggedInUser}</td>
								<li><a href="perform_logout"><span
										class="glyphicon glyphicon-log-out"></span> Logout</a></li>


							</c:when>
						</c:choose>
						<li><a href="viewmycart${loggedInUserID}"><span
								class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>


					</ul>
				</div>
			</nav>


		</c:otherwise>


	</c:choose>

</body>

