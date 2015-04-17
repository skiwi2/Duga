<%--
  Created by IntelliJ IDEA.
  User: Frank van Heeswijk
  Date: 17-4-2015
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<b>Users</b><br>
<table>
  <c:forEach var="user" items="${dugaUsers}">
    <tr>
      <td>${user.login}</td>
    </tr>
  </c:forEach>
</table>
<span id="add_user">
  <jsp:include page="/dwi/repository_link/${repositoryLink.githubRepository.owner}/${repositoryLink.githubRepository.name}/fragment/add_user/normal" />
</span>