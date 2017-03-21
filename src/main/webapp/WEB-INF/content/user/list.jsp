<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2017/3/21
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="/repo/bootstrap/css/bootstrap.min.css">
</head>
<body>
    <div class="container">

        <div class="row">
            <h3></h3>
            <form action="/user/new" method="post">
                <button class="btn btn-primary">添加</button>
            </form>
            <h3></h3>
            <form action="/user/list" class="form-inline">
                <input type="text" name="q_like_s_userName" class="form-control">
                <button class="btn btn-default">搜索</button>
            </form>


            <table class="table">
                <thead>
                <tr>
                    <td>用户名</td>
                    <td>金额</td>
                    <td>状态</td>
                    <td>#</td>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="userList" var="user">
                    <tr>
                        <td><s:property value="#user.userName"></s:property> </td>
                        <td>${user.money}</td>
                        <td>${user.enable}</td>
                        <td>
                            <a href="/user/edit?id=${user.id}">编辑</a> \
                            <a href="/user/del?id=${user.id}">删除</a>
                        </td>
                    </tr>
                </s:iterator>

                </tbody>



            </table>
        </div>

    </div>


</body>
</html>
