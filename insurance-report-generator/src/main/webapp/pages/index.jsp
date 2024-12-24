<%@page import="edu.qs.entity.CitizenPlan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action = "handle_search" modelAttribute="search" method="POST" > 
	
		<table>
			<tr>
				<td>Plan Name:</td>								
				<td>
					<form:select path="planName">
						<form:option value="">-Select-</form:option>
						<form:options items="${names}"/>						
					</form:select>
				</td>
				
				
				<td>	Plan Status: </td>				
				
				<td>
					<form:select path="planStatus">
						<form:option value="">-Select-</form:option>
						<form:options items="${status}"/>						
					</form:select>
				</td>
				
				
				<td>	Gender: </td>				
				
				<td>
					<form:select path="gender">
						<form:option value="">-Select-</form:option>
						<form:option value="male">Male</form:option>
						<form:option value="female">Female</form:option>
						<form:option value="other">other</form:option>												
					</form:select>
				</td>
							
				
			</tr>
			
			
			<tr>
				<td> Start Date :</td>
				<td>
					<form:input type = "date" path="planStartDate"/>
				</td>
				
				<td> End Date</td>
				<td>
					<form:input type = "date" path="planEndDate"/>
				</td>
				
				
			</tr>
			
			<tr>
				<td> <input type = "submit" value = "search"> </td>
			</tr>
			
		
		</table>

	</form:form>
	
	<hr>
	
	<table border="1">
	
		<tr>
			<th>ID</th>
			<th>Holder Name</th>
			<th>Gender</th>
			<th>Plan Name</th>
			<th>Status</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Benefit Amount</th>
			<th>Denial Reason</th>
			<th>Termination date</th>
			<th>termination reason</th>
			
		</tr>
		

		<%
			List<CitizenPlan> plans = (List<CitizenPlan>)request.getAttribute("plans");
			if(plans != null){
		%>
		
		<% for(CitizenPlan cp : plans){ %>
		
		<tr>
			
			<td> <%= cp.getCitizenId() %> </td>
			<td> <%= cp.getCitizenName() %> </td>
			<td> <%= cp.getGender() %> </td>
			<td> <%= cp.getPlanName()%> </td>
			<td> <%= cp.getPlanStatus() %> </td>
			<td> <%= cp.getPlanStatus() %> </td>
			<td> <%= cp.getPlanStartDate() %> </td>
			<td> <%= cp.getPlanEndDate() %> </td>
			<td> <%= cp.getBenefitAmt() %> </td>
			<td> <%= cp.getDenialReason() %> </td>
			<td> <%= cp.getTerminatedDate() %> </td>
			<td> <%= cp.getTerminationReason() %> </td>
			
			
			
		</tr>
		
		
		<%
		}
			} else{
			
		%>
		
	
	</table>
		
		.....No records found ....
	
	<%
		
			}
	%>
	<hr>
	
	<table>
		<tr>
			<td> <a href = "/excel">Excel</a> </td>
			<td> <a href = "/pdf">Pdf</a> </td>
		</tr>
	</table>
	
	
</body>
</html>