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
		$('#myModal').reveal();
	});
	
	
</script>

</head>

<body>


	
	<div id="myModal" class="reveal-modal">
		<h3 class="scott">Login</h3>
		<form:form method="POST" commandName="userlogin" action="/common/" >
			<form:errors path="*" cssClass="errorblock" element="div"  />
			<table width=100%>
				<tr>
					<td><form:input path="username" autocomplete="off" size="18px" placeholder="Username"  /></td>
				</tr>
				<tr>
					<td><form:password path="password" size="18px" placeholder="Password"  /></td>
				</tr>
				
					
			</table>
			<br><div><input type="submit" value="Login" /></div>
		</form:form>

		<!--   <a class="close-reveal-modal">&#215;</a> -->
		
		<div align="left"><a href="/common/register" >register</a></div>
	</div>
	
	
	
	
	
	
	

</body>
</html>
