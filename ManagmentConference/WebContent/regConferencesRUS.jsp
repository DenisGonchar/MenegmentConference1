<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body { background: url(img/speaker.png);
  }
   h1 {
    background: #b24fe0;
    color: white;
    padding: 1px;
   }
</style>
</head>
<body>
<h1>
Здесь вы можете изменить параметры конференции.
</h1>
<form action="jumptoadminpageservlet" method="get">
<input type="submit" value="Назад">
</form>
<form action="saveconferenceservlet" method="get">
<input type="text" name="nameConf" value="<c:out value="${conference.nameConf}"></c:out>">
<br>
<input type="text" name="place" value="<c:out value="${conference.place}"></c:out>">
<br>
<input type="text" name="date" value="<c:out value="${conference.date}"></c:out>">
<br>
<input type="text" name="time" value="<c:out value="${conference.time}"></c:out>">
<br>
<input type="submit" value="Сохранить">
</form>
</body>
</html>