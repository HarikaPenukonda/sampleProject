<%@ include file="Header.jsp"%>
<br>
<br>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);

	function MyController($scope, $http) {

		$scope.sortType = 'name'; // set the default sort type
		$scope.sortReverse = false; // set the default sort order
		$scope.searchBTitle = '';

		$scope.getDataFromServer = function() {
			$http({
				method : 'GET',
				url : 'GsonCon'
			}).success(function(data, status, headers, config) {
				$scope.prod = data;
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
		};
	};
</script>

<div>
	<div class="container">
		<div ng-app="myApp" ng-controller="dataCtrl">

			<hr></hr>
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Quantity</th>
					

					<th>Product Image</th>
				</tr>
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td><form method="post"
							action="buy${loggedInUserID}&${product.id }">
							Quantity:<input type="text" name="quantity" /> 
							<input type="submit" value="submit" />
					</form></td>
					
								
						

					<td><img src="resources/images/${product.name}.jpg"
						style="height: 100px; width: 100px;" /></td>
					
				
					
				</tr>
					
				
			</table>
			
		</div>
	</div>
</div>

<%@ include file="Footer.jsp"%>
