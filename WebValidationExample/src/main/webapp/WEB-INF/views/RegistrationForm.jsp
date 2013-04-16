<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>



<script src="<c:url value="resources/javascript/jquery-1.4.4.min.js" />"></script>
<script src="<c:url value="resources/javascript/jquery.reveal.js" />"></script>
<style type="text/css" media="all">@IMPORT url("resources/css/reveal.css");</style>


<script type="text/javascript">
	$(document).ready(function() {
		$('#myModalReg').reveal();
	});
	
	
</script>

</head>

<body>

<div id="myModalReg" class="reveal-modal">
		<h3 class="scott">Register</h3>
		<form:form method="POST" commandName="userregistration" action="/common/register" >
			<form:errors path="*"  cssClass="errorblock" element="div"  />
			<table width=100% >
				<tr>
					<td><form:input path="firstname" autocomplete="off" size="18px" title="First Name" placeholder="First Name"  /></td>
				</tr>
				<tr>
					<td><form:input path="lastname" size="18px" autocomplete="off" title="Last Name" placeholder="Last Name"  /></td>
				</tr>
				<tr>
					<td><form:input path="email" autocomplete="off" size="18px" title="Email Address" placeholder="Email"  /></td>
				</tr>
				<tr>
					<td><form:input path="username" autocomplete="off" size="18px" title="Username" placeholder="Username"  /></td>
				</tr>
				<tr>
					<td><form:password path="password" autocomplete="off" size="18px" title="Password" placeholder="Password"  /></td>
				</tr>
				<tr>
					<td><form:password path="password2" autocomplete="off" size="18px" title="Re-type Password" placeholder="Re-type Password"  /></td>
				</tr>
				
					
			</table>
			<br><div><input type="submit" value="Register" /></div>
		</form:form>

		<!--   <a class="close-reveal-modal">&#215;</a> -->
		
	</div>



</body>
</html>
