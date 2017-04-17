<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.4
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
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
                <h1 id="title"><a href="<s:url value="login.jsp"/>">&diamondsuit; 主页 &diamondsuit;</a></h1></div>
            <div id="navigation"><span>当前登录：<s:property value="#session.manager.name"/></span></div>
        </div>
        <div id="content">
            <p id="whereami"></p>
            <h1>添加部门信息 </h1>
            <form action="<s:url namespace="/dept" action="addDept"/>" method="post">
                <table cellpadding="0" cellspacing="0" border="0" class="form_table">
                    <tr>
                        <td valign="middle" align="right">部门ID：</td>
                        <td valign="middle" align="left">
                            <input type="number" maxlength="3" class="inputgri" name="deptId" title="此处输入部门ID"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">部门名称：</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="deptName" title="此处输入部门名称"/>
                        </td>
                    </tr>
                </table>
                <p><input type="submit" class="button" value="Confirm"/></p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            <a href="mailto:gjp0609@163.com">gjp0609@163.com</a>
        </div>
    </div>
</div>
</body>
</html>