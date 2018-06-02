<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.example.appengine.HelloAppEngine"%>
<html>
<head>
<link href='//fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
<title>Hello AppEngine</title>
</head>
<body>
  <h1>Hello AppEngine</h1>
  <p>
    This is
    <%=HelloAppEngine.getInfo()%>.
  </p>
  <table>
    <tr>
      <td><a href='/hello'>Hello AppEngine</a></td>
    </tr>
  </table>
</body>
</html>
