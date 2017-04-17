<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.16
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新部门信息</title>
    <link rel="stylesheet" href="<s:url value="/css/style.css" />">
</head>
<%
    //在 pageContext 中存入当前时间
    pageContext.setAttribute("date", new Date());
%>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader"><p><s:date name="#attr.date" format="yyyy/MM/dd"/></p></div>
            <div id="topheader">
                <h1 id="title"><a href="<s:url value="login.jsp"/>">Main</a></h1>
            </div>
            <div id="navigation"><span>当前登录：<s:property value="#session.manager.name"/></span></div>
        </div>
        <div id="content">
            <p id="whereami"></p>
            <h1> 更新部门信息 </h1>
            <form action="<s:url namespace="/dept" action="toUpdateDept" />" method="post">
                <table cellpadding="0" cellspacing="0" border="0" class="form_table">
                    <tr>
                        <td valign="middle" align="right">部门ID：</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="deptId"
                                   value="<s:property value="id" />" title="部门 ID 不能修改" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">部门名称：</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="deptName"
                                   value="<s:property value="name" />" title="部门名称"/>
                        </td>
                    </tr>
                </table>
                <p><input type="submit" value="确认"/></p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg"><a href="mailto:gjp0609@163.com">gjp0609@163.com</a></div>
    </div>
</div>
</body>

</html>