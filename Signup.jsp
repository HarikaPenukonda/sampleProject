<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="C"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>
</head>
<body>
	<form:form method="POST" commandName="us">
		<table>
		<tr>
				<td>User_ID :</td>
				<td><form:input path="id" /></td><td style="color:red;font-size:12px">
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('id')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="name"   /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
	
			<tr>
				<td>Contact :</td>
				<td><form:input path="contact" /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('contact')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			
			<tr>
				<td>Address :</td>
				<td><form:input path="address" /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			
			<tr>
				<td>Email :</td>
				<td><form:input path="mail" /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('mail')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			

			<tr>
				<td>Password :</td>
				<td><form:input type="password" path="password" /></td>
			</tr>
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			
			<tr>
				<td>Confirm Password :</td>
				<td><form:input type="password" path="confirmpassword" /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('confirmpassword')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			
			<tr>
			</tr>
			
		</table>
		<div class = center>
			<input type="submit" name="_eventId_submit" value="submit" ></div>
			
			</div>
		
		<br>
	</form:form>
</body>
</html>