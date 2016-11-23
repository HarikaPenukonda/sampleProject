<%@ include file="Header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="<c:url value= "/resources/admin.css"/>">
<html>
<head>
<title>Category Page</title>
</head>

<body>

	${message}

	<h2>Add the products</h2>
	 
	<c:url var="addAction" value="/padd">
	</c:url>
	  
	<form:form action="${addAction}" commandName="product"
		enctype="multipart/form-data">

		<table class="table table-hover">
			<tr>
				<td>PROD_ID:</td>
				<c:choose>
					<c:when test="${!empty product.id}">
						<td><form:input path="id" disable="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern="{4,7}" required="true"
								title="id should contain 4 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>PROD_NAME:</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td>PROD_DESCIPTION:</td>
				<td><form:input type="text" path="description" /></td>
			</tr>
			<tr>
				<td>PROD_PRICE</td>
				<td><form:input type="text" path="price" /></td>
			</tr>


			<tr>
				<td>CAT_ID</td>
				<td><form:select path="category.id" items="${categoryList}"
						itemValue="id" itemLabel="id"></form:select></td>
			</tr>
			<tr>
				<td>SUP_ID</td>
				<td><form:select path="supplier.id" items="${supplierList}"
						itemValue="id" itemLabel="id"></form:select></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><form:input type="File" path="image" /></td>

			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty product.name}">

						<input type="submit" value="Update Product" />
					</c:if> <c:if test="${empty product.name}">
						<input type="submit" value="Add Product" />
					</c:if></td>
			</tr>
		</table>
	</form:form>

	<br>
	<h3>Product List</h3>
	<c:if test="${!empty productList}">
		<table class="table">
			<tr>
				<th width="80">Product Id</th>
				<th width="120">Product Name</th>
				<th width="200">Description</th>
				<th width="80">Price</th>
				<th width="80">catID</th>
				<th width="80">SupID</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.catid}</td>
					<td>${product.supid}</td>
					<td><a href="<c:url value='pupdate${product.id}' />">Edit</a></td>
					<td><a href="<c:url value='productdelete${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>