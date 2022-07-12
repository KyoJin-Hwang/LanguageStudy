<!-- join.jsp -> web.xml -> JoinCon -> DAO -> sql세션매니저(config도 들림) -> 
		다시 DAO -> Mapper(값받아오기) -> DAO(종료)
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="JoinCon" method="post">
<table>
   <tr>
      <td>ID : </td>
      <td><input type="text" name="id"></td>
   </tr>
   <tr>
      <td>PW : </td>
      <td><input type="text" name="pw"></td>
   </tr>
   <tr>
      <td>nick : </td>
      <td><input type="text" name="nick"></td>
   </tr>
   <tr><td></td>
      <td align="right"><input type="submit" value="회원가입"> </td>
   </tr>
</table>
</form>
</body>
</html>