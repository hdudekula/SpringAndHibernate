<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>

<head>
<title>List of Customers</title>

<!-- Reference our style sheet -->
<link type="text/css"
	  rel="stylesheet"
	  href=${pageContext.request.contextPath}/resources/css/style.css/>

</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM- Customer Relational Mapping</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<!-- Add a new button -->
			<input type="button" value="Add new customer"
				onclick="window.location.href='showFormForAdd'; return false"
				class="add-button"
			/>
			<!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			<!-- add our html table -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>email</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<!-- construct an "update" link with customer ID -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" /></c:url>
						
					<!-- construct an "delete" link with customer ID -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" /></c:url>
				
				
					<tr>
						<td> ${tempCustomer.firstName}</td>
						<td> ${tempCustomer.lastName}</td>
						<td> ${tempCustomer.email}</td>
						
						<!-- display the update link -->
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete student?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
			
			
			</table>
		
		</div>
	
	</div>
</body>
</html>