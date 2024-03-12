<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="a.b.c.com.os.mem.vo.OsMemVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<style type="text/css">
div,h3  {
		 text-align: center;
	}
			
	/* a 태그 밑줄 없애기 */
	a { text-decoration:none }
</style>

<script type="text/javascript">
	
</script>

</head>
<body>
<h3>Login Session Testing :: LOGIN SUCCCESS</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("listLogin");
	if(obj == null) return;
	List<OsMemVO> list = (List<OsMemVO>)obj;
	int nCnt = list.size();
	
	Object remoteInfoObj = request.getAttribute("remoteInfo");
	List<String> riObj = (List<String>)remoteInfoObj;
	
	if(nCnt == 1){
		String mid = list.get(0).getMid();
		
		String remoteIp = riObj.get(0);
		String remoteBrowser = riObj.get(1);
	

%>
			<script>
			alert("<%= mid %> 님 로그인 성공 \n"
					+ "접속 아이피 : <%= remoteIp %> \n"
					+ "접속 브라우저 : <%= remoteBrowser %>");
		</script>
		<div>
  			<a href="logout.h?mid=<%= mid %>">로그아웃 하기</a>
		</div>
<% 		
	}
%>

</body>
</html>