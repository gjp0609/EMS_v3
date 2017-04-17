<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.14
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String url = response.encodeRedirectURL(request.getContextPath() + "/commons/welcome.action");
    response.sendRedirect(url);
%>
</body>
</html>
