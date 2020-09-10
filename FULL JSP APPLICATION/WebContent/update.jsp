<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="include/header.jsp"><c:param name="title" value="UpdateEmail"/></c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
		<form action="<%= request.getContextPath()%>/HomeController" method="post">
		Email:<input type="text" name="email" value="<%= request.getParameter("email")%>" required="required"/><br/><br/>
		<input type="hidden" name="userid" value="${param.UID}"/>
		<input type="hidden" name="form" value="updateEmail"/>
		<input type="submit" name="submit" value="submit"/>
		
		</form>
		</div>
		</div>
		</div>
		<c:import url="include/footer.jsp"></c:import>