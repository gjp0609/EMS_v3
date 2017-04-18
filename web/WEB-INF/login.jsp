<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.3.31
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="<s:url value="/css/style.css" />">
    <script type="text/javascript">
        function checkUsername() {
            var username = document.getElementById("username");
            var span = document.getElementById("usernameSp");
            if (username.value.length <= 1) {
                span.innerHTML = "用户名长度不够";
                span.style.color = "red";
                return false;
            } else {
                span.innerHTML = "";
                return true;
            }
        }

        function checkPassword() {
            var password = document.getElementById("password");
            var span = document.getElementById("passwordSp");
            if (password.value.length <= 2) {
                span.innerHTML = "密码长度不够";
                span.style.color = "red";
                return false;
            } else {
                span.innerHTML = "";
                return true;
            }
        }

        function checkVcode() {
            var vcode = document.getElementById("vcode");
            var span = document.getElementById("vcodeSp");
            if (vcode.value.length < 4) {
                span.innerHTML = "验证码长度不够";
                span.style.color = "red";
                return false;
            } else {
                span.innerHTML = "";
                return true;
            }
        }

        function checkAll() {
            if (!checkUsername()) return false;
            if (!checkPassword()) return false;
            if (!checkVcode()) return false;
        }

    </script>
</head>
<%
    //在 pageContext 中存入当前时间
    pageContext.setAttribute("date", new Date());
    // 获取 cookie
    Cookie[] cks = request.getCookies();
    if (cks == null || cks.length < 1) {
    } else for (Cookie ck : cks)
        if (ck.getName().equals("username"))
            pageContext.setAttribute("ck", ck.getValue());

%>


<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p><s:date name="#attr.date" format="yyyy/MM/dd"/></p>
            </div>
            <div id="topheader">
                <h1 id="title"><a href="<s:url value="login.jsp"/>">Main</a></h1>
            </div>
            <div id="navigation"></div>
        </div>
        <div id="content">
            <p id="whereami"></p>
            <h1> login </h1>
            <form action="<s:url namespace="/manager" action="login"/>" method="post" onsubmit="return checkAll()">
                <table cellpadding="0" cellspacing="0" border="0" class="form_table">
                    <tr>
                        <td valign="middle" align="right"> username:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="manager.name" maxlength="12"
                                   onblur="checkUsername()"
                                   value="<s:property value=" #attr.ck"/>" title="此处输入用户名" id="username"/>
                            <span id="usernameSp"></span>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right"> password:</td>
                        <td valign="middle" align="left">
                            <input type="password" maxlength="10" class="inputgri" name="manager.password"
                                   title="此处输入密码"
                                   id="password" onblur="checkPassword()"/>
                            <span id="passwordSp"></span>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right"></td>
                        <td valign="middle" align="left">
                            <img src="<s:url namespace="/commons" action="getVCode"/>?name=adminLogin"
                                 title="<s:property value="#session.adminLoginVCode"/>" alt="验证码图片">
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right"> verify code:</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" maxlength="4" name="vcode" title="此处输入验证码"
                                   id="vcode" onblur="checkVcode()"/>
                            <span id="vcodeSp"></span>
                        </td>
                    </tr>
                    <tr>
                        <td><a href="<s:url namespace="/commons" action="register" />">
                            <input type="button" value="Register" title="点击注册"/> </a></td>
                        <td><input type="submit" value="Submit" title="点击登陆"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg"><a href="mailto:gjp0609@163.com">gjp0609@163.com</a></div>
    </div>
</div>
</body>
</html>