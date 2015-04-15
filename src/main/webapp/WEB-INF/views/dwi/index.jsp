<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Frank van Heeswijk
  Date: 14-4-2015
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index - Duga Web Interface</title>
</head>
<body>
Welcome ${username}.
<p>
  <b>Linked repositories</b> <a href="<c:url value="/dwi/link_repository" />">Link repository</a><br>
  <table>
    <c:forEach var="link" items="${repositoryLinks}">
      <tr>
        <td><a href="<c:url value="/dwi/repository_link/${link.githubRepository.owner}/${link.githubRepository.name}" />">${link.githubRepository.owner}/${link.githubRepository.name}</a></td>
      </tr>
    </c:forEach>
  </table>
</p>
</body>
</html>
