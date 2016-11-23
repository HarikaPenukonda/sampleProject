
<%@ include file="Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="content">
		<fieldset>
			<legend>Confirm Details</legend>
			<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
			<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /> <br />
			<form:form modelAttribute="us">
				<form:label path="id">User ID :</form:label>${us.id}
					<br />
				<br />
				<form:label path="name"> User Name:</form:label>${us.name}
					<br />
				<br />
				<form:label path="password">Password :</form:label>${us.password}
					<br />


				<form:label path="mail">Email:</form:label>${us.mail}
					<br />
				<br />
				<form:label path="contact">Contact:</form:label>${us.contact}
					<br />
				<br />
				<form:label path="address">Address :</form:label>${us.address}
					<br />
				<br />
				<input name="_eventId_edit" type="submit" value="Edit" />
				<input name="_eventId_submit" type="submit" value="confirm Details" />
				<br />
			</form:form>
		</fieldset>
	</div>


<%@ include file="Footer.jsp" %>