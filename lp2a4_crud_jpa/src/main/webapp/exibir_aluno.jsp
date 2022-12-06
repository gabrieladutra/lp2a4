<%@page import="lp2a4.controller.CommandEnum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lp2a4.modelo.AlunoPOJO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aluno CRUD</title>
</head>
<body>
<!-- Configurar o escopo com request permite receber o atributo colocado no request -->
<!-- o id deve ter o mesmo nome do atributo configurado no request -->
<jsp:useBean id="aluno" class="lp2a4.modelo.AlunoPOJO" scope="request"></jsp:useBean>

<form id="exibir_form" action="./controller">
	<input type="hidden" name="acao" id="acao" value="<%=CommandEnum.NAVIGATE_UPDATE%>"/>
	<input type="hidden" name="matricula" id="matricula" value="<jsp:getProperty property="matricula" name="aluno"/>"/>
	<table border="1">
		<tr>
			<td>Matrícula : </td>
			<td><%=aluno.getMatricula()%></td>
		</tr>
		<tr>
			<td>Nome : </td>
			<td>
				<jsp:getProperty property="nome" name="aluno"/>
			</td>
		</tr>
		<tr>
			<td>Endereço : </td>
			<td>
				<jsp:getProperty property="endereco" name="aluno"/>
			</td>
		</tr>
		<tr>
			<td>Data Ingresso : </td>
			<td>
				<jsp:getProperty property="dataIngresso" name="aluno"/>
			</td>
		</tr>
		<tr>
			<td>Data Término : </td>
			<td>
				<jsp:getProperty property="dataConclusao" name="aluno"/>
			</td>
		</tr>
	</table>
	<input type="submit" value="Editar aluno!"/>
</form>
<form id="delete_form" action="./controller">
	<input type="hidden" name="acao" id="acao" value="<%=CommandEnum.DELETE%>"/>
	<input type="hidden" name="matricula" id="matricula" value="<jsp:getProperty property="matricula" name="aluno"/>"/>
	<input type="submit" value="Apagar estudante!"/>
</form>
<form id="novo_form" action="./novo_aluno.jsp">
	<input type="submit" value="Criar novo aluno!" />
</form>
</body>
</html>