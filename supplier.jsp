
<%@ include file="Header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="<c:url value= "/resources/admin.css"/>">
<html>
<head>
<title>Supplier Page</title>
</head>

<body>
	${msg}
	<h1>Add a Supplier</h1>
	<c:url var="addAction" value="/sadd">
	</c:url>
	<form:form action="${addAction}" commandName="supplier">
		<table class="table table-hover">
			<tr>
				<td>SUP_ID :</td>
				<c:choose>
					<c:when test="${!empty supplier.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input type="text" path="id" pattern="{4,7}" required="true"
								title="id should contain 4 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			</tr>

			<tr>
				
				<td>SUP_NAME :</td>
				<td><form:input type="text" path="name" required="true" /></td>
			</tr>

			<tr>
				
				<td>SUP_ADDRESS :</td>
				<td><form:input type="text" path="address" required="true" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><c:if test="${!empty supplier.name}">

						<input type="submit" value="Update Supplier" />
					</c:if> <c:if test="${empty supplier.name}">
						<input type="submit" value="Add Supplier" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Supplier List</h3>
	<c:if test="${!empty supplierList}">
		<table class="table">
			<tr>
				<th width="80">Supplier ID</th>
				<th width="120">Supplier Name</th>
				<th width="120">Supplier Address</th>
				<th width="60">Update</th>
				<th width="60">Delete</th>
			</tr>

			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.address}</td>
					<td><a href="<c:url value='supdate${supplier.id}'/>">Update</a></td>
					<td><a href="<c:url value='supplierdelete${supplier.id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>