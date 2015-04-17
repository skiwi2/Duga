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
    <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="<c:url value="/resources/dwi/framework.js" />"></script>
</head>
<body>
Repository link for ${repositoryLink.githubRepository.owner}/${repositoryLink.githubRepository.name}.
<p id="github_repository">
  <jsp:include page="/dwi/repository_link/${repositoryLink.githubRepository.owner}/${repositoryLink.githubRepository.name}/fragment/github_repository/normal" />
</p>
<p id="users">
  <jsp:include page="/dwi/repository_link/${repositoryLink.githubRepository.owner}/${repositoryLink.githubRepository.name}/fragment/users/normal" />
</p>
</body>
</html>
