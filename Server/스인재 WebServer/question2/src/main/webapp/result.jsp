<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    table, tr, th, td{
        border:1px solid black;
        font-weight: normal;
    }
</style>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String[] list = request.getParameterValues("check");
%>	
	
	<table border="1">
		<tr>
            <th>
                이름
            </th>
            <th>
                <%=name %>
            </th> 
        </tr>
        <tr>
        	<td>좋아하는 과일</td>
        	<td>
        	<%for(String str: list){
        			out.print(str+" ");
        		}%>
        	</td>
        	
        </tr>
		</table>
		
</body>
</html>