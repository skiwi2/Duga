<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Frank van Heeswijk
  Date: 15-4-2015
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Repository link for ${repositoryLink.githubRepository.owner}/${repositoryLink.githubRepository.name}</title>
</head>
<body>
Repository link for ${repositoryLink.githubRepository.owner}/${repositoryLink.githubRepository.name}.
<p>
  <b>Github Repository</b><br>
  <table>
    <tr>
      <td>Owner: </td>
      <td>${repositoryLink.githubRepository.owner}</td>
    </tr>
  <tr>
    <td>Name: </td>
    <td>${repositoryLink.githubRepository.name}</td>
  </tr>
  <tr>
    <td>Url: </td>
    <td>${repositoryLink.githubRepository.url}</td>
  </tr>
  </table>
</p>
<p>
  <b>Users</b><br>
  <table>
    <c:forEach var="user" items="${repositoryLink.dugaUsers}">
      <tr>
        <td>${user.login}</td>
      </tr>
    </c:forEach>
  </table>
</p>
</body>
</html>
