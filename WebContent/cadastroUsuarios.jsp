<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro carros</title>
<link rel="stylesheet" type="text/css" href="CSS/ordemServicos.css">
</head>
<body>
	<div id="topo">
		<div class="centraliza">
			<div id="logos">
				<div class="logoOF">
					<img src="IMG/logo.png" />
				</div>
				<div class="logo">
					<img src="IMG/audi_logo.png" />
				</div>
				<div class="logo">
					<img src="IMG/bmw_logo.png" />
				</div>
				<div class="logo">
					<img src="IMG/ferrari_logo.png" />
				</div>
				<div class="logo">
					<img src="IMG/lamborghini_logo.png" />
				</div>
				<div class="logo">
					<img src="IMG/mercedes_logo.png" />
				</div>
				<div class="logo">
					<img src="IMG/Porsche_logo.png" />
				</div>
			</div>
			<div id="menu">
				<div class="central">
					<div class="item">
						<a href="ControleLogin?acao=Sair">SAIR</a>
					</div>
					<div class="item">
						<a href="ControleUsuario">USUARIOS</a>
					</div>
					<div class="item">
						<a href="ControleOrdemServico?acao=ler">ORDENS DE SERVIÇOS</a>
					</div>
					<div class="item">
						<a href="ControleOrdemServico">INICIO</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="conteudo">
		<div id="barra"></div>
		<div id="box">
			<div class="centraliza">
				<div id="formulario">
					<form action=ControleUsuario>
						Usuario :<input type="text" name="usuario"> 
						Senha :  <input type="password" name="senha"> 
						         <input type="submit" name="acao" value="Cadastrar">
					</form>
				</div>
			<div id="tabela">
				<table border="1" style="width: 100%;">
				<tr>
					<th colspan="4">Usuario</th><th colspan="1">Opção</th>
				</tr>
				
				<%
					ArrayList<Usuario> us = (ArrayList<Usuario>) request.getSession().getAttribute("usuarios");
				
					for(Usuario u :us){
				%>
					<tr>
					
					<td colspan="4"><%=u.getNome() %></td>
					<td colspan="1"><a href="ControleUsuario?acao=remover&us=<%=u.getNome() %>">Excluir</a></td>
					</tr>
				<%} %>
				</table>
			
			</div>
			</div>
		</div>
	</div>
	<div id="rodape">
		<div class="central"></div>
	</div>
</body>
</html>