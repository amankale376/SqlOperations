<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>

<c:import url="include/header.jsp"><c:param name="title" value="list"/></c:import>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<table border="1px">
			<thread>
			<th>Sr.No</th>
			<th>Email</th>
			<th>Operation</th>
			</thead>
			<%
			String tempURL;
			List<User> list1 = (List)request.getAttribute("list");
			for(int i = 0; i<list1.size();i++){
				out.print("<tr>");
				out.print("<td>"+list1.get(i).getUserId()+"</td>");
				out.print("<td>"+list1.get(i).getEmail()+"</td>");
				int tempID= list1.get(i).getUserId();
				tempURL = request.getContextPath()+"/HomeController?page=update&UID="+tempID+"&email="+list1.get(i).getEmail();
				out.print("<td><a href='"+tempURL+"'>UPDATE</a></td>");
				String tempURL2= request.getContextPath()+"/HomeController?page=delete&UID="+tempID;
				out.print("<td><a href='"+tempURL2+"'>DELETE</a></td>");
				
				out.print("</tr>");
			}
			%>
			</table>
		</div>
	</div>
</div>
<c:import url="include/footer.jsp"></c:import>