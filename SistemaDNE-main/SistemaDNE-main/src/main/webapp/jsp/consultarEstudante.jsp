<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Sistema Acadêmico </title>
	</head>
<center>
	<body>
		<h2>Consultar Carteirinha </h2>
		<jsp:useBean id="estudantes" scope="session" class="br.edu.dne.model.Estudantes" />
	<form>
		<table border="1">
			<tr>
				<td>Email:</td>
				<td><input type="text" size="50" name="txtEmail" value="<%=estudantes.getEmail()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" size="60" name="txtNome" value="<%=estudantes.getNome()%>"readonly="readonly"  /></td>
			</tr>
			<tr>
				<td>Data de nascimento:</td>
				<td><input type="text" size="12" name="txtData" value="<%=estudantes.getDataNascimento()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>CPF:</td>
				<td><input type="text" size="16" name="txtCpf" value="<%=estudantes.getCpf()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Cep:</td>
				<td><input type="text" size="10" name="txtCep" value="<%=estudantes.getCep()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Numero da Casa:</td>
				<td><input type="text" size="6" name="txtNumero" value="<%=estudantes.getNumero()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td><input type="text" size="15" name="txtCelular" value="<%=estudantes.getCelular()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Escolaridade:</td>
				<td><input type="text" size="30" name="cmbEscolaridade" value="<%=estudantes.getEscolaridade()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Nome do Curso:</td>
				<td><input type="text" size="50" name="txtNomeCurso" value="<%=estudantes.getNomeCurso()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Saldo:</td>
				<td><input type="number" size="50" name="numSaldo" value="<%=estudantes.getSaldo()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Carteirinha suspensa:</td>
				<td><input type="text" size="50" name="cmbSuspender" value="<%=estudantes.getSuspender()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<th colspan="2"><a href="index.html">Página Principal</a></th>
			</tr>
		</table>
	</form>
 </center>
</body>
</html>
