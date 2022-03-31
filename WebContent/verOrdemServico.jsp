<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes Ordem de Serviço</title>
<link rel="stylesheet" type="text/css" href="CSS/verOrdemServico.css">
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
				<div id="dados">
					<%
						ArrayList<OrdemServico> os = (ArrayList<OrdemServico>) request.getSession().getAttribute("OrdenServico");

						for (OrdemServico o : os) {
					%>
					<table>
						<tr>
							<th>Cod:</th>
							<td><%=o.getCodigo()%></td>
						</tr>
						<tr>
							<th>Cliente:</th>
							<td><%=o.getCliente().getNome()%></td>
						</tr>
						<tr>
							<th>Veiculo:</th>
							<td><%=o.getCarro().getPlaca()%></td>
						</tr>
						<tr>
							<th>Status:</th>
							<td><%=o.isStatus()%></td>
						</tr>

					</table>

				</div>
				<div id="formulario">
					<form action="ControleOrdemServico">
						Serviço :<input type="text" name="nomeservico"> Valor :<input
							type="text" name="valor"> <input type="hidden" name="cod"
							value="<%=o.getCodigo()%>">
						<%
							}
						%>
						<input type="submit" name="acao" value="Adicionar">
					</form>
				</div>
				<div id="tabela">
					<table border="1" style="width: 100%;">
						<tr>
							<th>Serviço</th>
							<th>Valor</th>
							<th>Opção</th>
						</tr>
						<%
							for (OrdemServico os2 : os) {

								for (Servico s : os2.getServicos()) {
						%>
						<tr>
							<td><%=s.getNome()%></td>
							<td><%=s.getValor()%></td>
							<%if(os2.isStatus()) {%>
							<td align="center"><a href="ControleOrdemServico?acao=Remover&cod=<%=os2.getCodigo()%>&servico=<%=s.getNome()%>">REMOVER</a></td>
							<%}else{ %>
							<td></td>
							<%} %>	
						</tr>
						<%
							}
						%>
						<tr>
							<td colspan="1">Total</td>
							<td><%=os2.getValorTotal()%></td>
							<td align="center"><a href="ControleOrdemServico?acao=Fechar&cod=<%=os2.getCodigo() %>">Finalizar/Reabrir</a></td>
						</tr>

						<%
							}
						%>
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