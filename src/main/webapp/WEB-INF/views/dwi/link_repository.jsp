<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Frank van Heeswijk
  Date: 15-4-2015
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Link repository - Duga Web Interface</title>
</head>
<body>
Create new Repository Link.
<p>
  <form method="post" action="<c:url value="/dwi/link_repository" />">
    <b>Github Repository</b><br>
    <table>
      <tr>
        <td>Owner: </td>
        <td><input type="text" name="github_repository_owner"></td>
      </tr>
      <tr>
        <td>Name: </td>
        <td><input type="text" name="github_repository_name"></td>
      </tr>
      <tr>
        <td>Url: </td>
        <td><input type="text" name="github_repository_url" size="64"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Link repository"></td>
      </tr>
    </table>
  </form>
</p>
</body>
</html>
