<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro carros</title>
<link rel="stylesheet" type="text/css"
	href="CSS/ordemServicos.css">
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
					<form action=ControleOrdemServico>
				Status :<select name="status">
							<option value="true">Aberta</option>
							<option value="false">Fechada</option>
						</select> 
			    Placa : <input type="text" name="placa"> 
						<input type="submit" name="acao" value="Buscar">
					</form>
				</div>
				<div id="tabela">
					<table border="1" style="width:100%;">
						<tr>
							<th>cod</th>
							<th>Cliente</th>
							<th>Veiculo</th>
							<th>Valor Total</th>
							<th>Status</th>
							<th>Opção</th>
						</tr>
						<%
							ArrayList<OrdemServico> os = (ArrayList<OrdemServico>) request.getSession().getAttribute("OrdenServicos");
							
							for(OrdemServico o:os){
						%>
						<tr>
							<td><%=o.getCodigo() %></td>
							<td><%=o.getCliente().getNome() %></td>
							<td><%=o.getCarro().getPlaca() %></td>
							<td><%=o.getValorTotal() %></td>
							<% if(o.isStatus()){ %>
							<td style="background-color:green"></td>
							<%}else{ %>
							<td style="background-color:red"></td>
							<%} %>
							<td><a href="ControleOrdemServico?acao=Detalhe&cod=<%=o.getCodigo()%>">Detalhe</a></td>
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