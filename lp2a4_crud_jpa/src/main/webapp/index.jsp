<%@page import="lp2a4.controller.CommandEnum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta Aluno</title>
</head>
<body>
<form action="./controller">
	<input type="hidden" name="acao" id="acao" value="<%=CommandEnum.RETRIEVE%>"/>
	<input type="text" name="matricula" id="matricula"/>
	<input type="submit" value="Consultar matrícula!"/>
</form>
<form action="./novo_aluno.jsp">
	<input type="submit" value="Criar novo aluno!" />
</form>
</body>
</html>