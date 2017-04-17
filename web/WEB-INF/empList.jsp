<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.4.4
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@ page import="cn.gjp0609.ems.v3.entity.Department" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>emplist</title>
    <link rel="stylesheet" href="<s:url value="/css/style.css" />">
</head>
<%
    pageContext.setAttribute("date", new Date());

//    ActionContext cxt = ActionContext.getContext();
//    ValueStack vs = cxt.getValueStack();
//    List<Department> depts = (List<Department>) vs.findValue("depts");
//
//    // 把查询到的部门 ID 与部门名称以 Map 的方式存储在 session 中
//    Map<Integer, String> ds = new HashMap<>();
//    if (depts == null || depts.size() < 1) {
//        System.out.println("None");
//    } else {
//        for (Department d : depts) {
//            ds.put(d.getId(), d.getName());
////            System.out.println(d.getId() + "<><><>" + d.getName());
//        }
//    }
//    vs.setValue("#session.depts", ds);
%>
<s:action namespace="/dept" name="getAllDepts"/>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p><s:date name="#attr.date" format="yyyy/MM/dd"/></p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="<s:url namespace="/emp" action="queryAllEmp"/>">主页</a>
                </h1>
            </div>
            <div id="navigation"><span>当前登录：<s:property value="#session.manager.name"/></span></div>
        </div>
        <div id="content">
            <p id="whereami">
            <h1>所有员工</h1></p>
            <form action="<s:url namespace="/emp" action="deleteEmps"/>" method="post">
                <table class="table">
                    <tr class="table_header">
                        <td>
                            <input type="submit" title="点击删除多个" value="多选删除"/>
                        </td>
                        <td>员工 ID</td>
                        <td>员工姓名</td>
                        <td>性别</td>
                        <td>出生日期</td>
                        <td>薪资</td>
                        <td>所在部门</td>
                        <td>操作</td>
                    </tr>

                    <%--<s:iterator var="dept" value="depts">--%>
                    <%--<s:iterator value="#dept.emps" var="emp" step="2">--%>
                    <s:iterator var="emp" value="employees">
                        <%--<s:property/>--%>
                        <tr class="row1">

                            <td>
                                <input type="checkbox" name="choose" id="<s:property value="#emp.id"/>"
                                       value="<s:property value="#emp.id"/>"/>
                                <label for="<s:property value="#emp.id"/>">选择</label>
                            </td>

                            <td><s:property value="#emp.id"/></td>
                            <td><s:property value="#emp.name"/></td>
                            <td><s:property value="#emp.sex"/></td>
                            <td><s:date name="birthday" format="yyyy-MM-dd"/></td>
                            <td><s:property value="#emp.salary"/></td>
                            <td align="center">
                                <a href="<s:url namespace="/dept" action="getDeptInfo" >
                                    <s:param name="deptId" value="#emp.department.id"/></s:url>">
                                    <s:property value="#emp.department.name"/></a>
                            </td>
                            <td>
                                <a href="<s:url namespace="/emp" action="deleteEmp"  >
                                    <s:param name="id" value="#emp.id"/>
                                    </s:url>">delete
                                </a>
                                <a href="<s:url namespace="/emp" action="getEmpInfo" >
                                    <s:param name="id" value="#emp.id"/>
                                    </s:url>">update
                                </a>
                            </td>

                        </tr>
                    </s:iterator>
                    <%--</s:iterator>--%>
                    <%--</s:iterator>--%>
                </table>
            </form>
            <p>
                <a href="<s:url  namespace="/commons" action="addEmp" />">
                    <input type="button" value="添加用户" title="点击添加用户"/></a>

                <a href="<s:url  namespace="/commons" action="addDept" />">
                    <input type="button" value="添加部门" title="点击添加部门"/></a>
                <s:if test="page.hasPrePage">
                <a href="<s:url namespace='/emp' action='queryAllEmp'>
                            <s:param name="page.pageIndex" value="page.pageIndex-1"/></s:url>">上一页
                </a>
                </s:if>
                <s:else>下一页</s:else>
                <s:if test="page.hasNextPage">
                <a href="<s:url namespace='/emp' action='queryAllEmp'>
                            <s:param name="page.pageIndex" value="page.pageIndex+1"/></s:url>">下一页
                </a>
                </s:if>
                <s:else>下一页</s:else>
            <form action="<s:url namespace="/dept" action="getDeptInfo" />" method="post" style="display: inline">
                <select name="deptId" title="此处选择员工部门">
                    <s:iterator value="#session.depts" var="dept">
                        <option value="<s:property value="#dept.key"/>">
                            <s:property value="#dept.value"/>
                        </option>
                    </s:iterator>
                </select>
                <input type="submit" title="点击管理部门" value="管理部门"/>
            </form>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            <a href="mailto:gjp0609@163.com">gjp0609@163.com</a>
        </div>
    </div>
</div>

<%--<s:debug/>--%>

</body>
</html>