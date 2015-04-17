<%--
  Created by IntelliJ IDEA.
  User: Frank van Heeswijk
  Date: 17-4-2015
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" id="add_user_form" onsubmit="event.preventDefault(); return false;">
  <table>
    <tr>
      <td>Username: </td>
      <td><input type="text" name="username" value=""></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="button" value="Cancel" onclick="showNormal('add_user');"><input type="button" value="Save" onclick="saveFragmentAndThen('add_user', function() { showNormal('users'); });"></td>
    </tr>
  </table>
</form>