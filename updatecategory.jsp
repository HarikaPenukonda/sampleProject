<%-- <%@ include file = "Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <link rel="stylesheet" href="<c:url value= "/resources/admin.css"/>">
 <html>
 <head>
 <title>Category Page</title>
 </head>
 <body>
 <center>
 <h2>Update Categories</h2>
		  <c:url var="addAction" value="category/edit"> </c:url>
 <form:form action="${addAction}" commandName="category">

			<table class="table table-hover">
				<tr>
					<td>CAT_ID:</td>
					<c:choose>
						<c:when test="${!empty category.id}">
							<td><form:input path="id" disable="true" readonly="true" /></td>
						</c:when>
						<c:otherwise>
							<td><form:input path="id" pattern=".{4,7}" required="true"
									title="id should contain 4 to 7 characters" /></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>CAT_NAME:</td>
					<td><form:input type="text" path="name" /></td>
				</tr>
				<tr>
					<td>CAT_DESCIPTION:</td>
					<td><form:input type="text" path="description" /></td>
				</tr>
				
				
				</table>
				</form:form> --%>