<%--
  Created by IntelliJ IDEA.
  User: Frank van Heeswijk
  Date: 16-4-2015
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
  function updateLocation() {
    var newOwner = $("#owner").val();
    var newName = $("#name").val();
    var newUrl = "<c:url value="/dwi/repository_link" />" + "/" + newOwner + "/" + newName;
    location.href = newUrl;
  }
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<b>Github Repository</b><br>
<form method="post" id="github_repository_form" onsubmit="event.preventDefault(); return false;">
  <table>
    <tr>
      <td>Owner: </td>
      <td><input type="text" name="github_repository_owner" id="owner" value="${githubRepository.owner}"></td>
    </tr>
    <tr>
      <td>Name: </td>
      <td><input type="text" name="github_repository_name" id="name" value="${githubRepository.name}"></td>
    </tr>
    <tr>
      <td>Url: </td>
      <td><input type="text" name="github_repository_url" size="64" value="${githubRepository.url}"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="button" value="Cancel" onclick="showNormal('github_repository');"><input type="button" value="Save" onclick="saveFragmentAndThen('github_repository', updateLocation);"></td>
    </tr>
  </table>
</form>