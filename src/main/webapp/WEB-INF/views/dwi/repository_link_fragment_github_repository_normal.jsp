<%--
  Created by IntelliJ IDEA.
  User: Frank van Heeswijk
  Date: 16-4-2015
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<b>Github Repository</b> <a href="#" onclick="showEdit('github_repository');">Edit</a><br>
<table>
  <tr>
    <td>Owner: </td>
    <td>${githubRepository.owner}</td>
  </tr>
  <tr>
    <td>Name: </td>
    <td>${githubRepository.name}</td>
  </tr>
  <tr>
    <td>Url: </td>
    <td>${githubRepository.url}</td>
  </tr>
</table>