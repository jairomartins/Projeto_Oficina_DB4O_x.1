<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro carros</title>
<link rel="stylesheet" type="text/css"
	href="CSS/cadastroOrdemServico.css">
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
				<form action="ControleOrdemServico" method="get">
				<div id="box-cliente"></div>
					<fieldset >
						<legend>Cliente</legend>
						<table border="0.5px">
							<tr>
								<td>Propietário :</td>
								<td><input type="text" name="dono"></td>
								<td>Telefone</td>
								<td><input type="text" name="telefone"></td>
							</tr>
							<tr>
								<td>Endereco :</td>
								<td><input type="text" name="endereco"></td>
								<td>CPF :</td>
								<td><input type="text" name="cpf"></td>
							</tr>
						</table>
					</fieldset>
					<fieldset>
						<legend>Carro</legend>
						<table>
							<tr>
								<td style="width: 80px;">Placa :</td>
								<td><input type="text" name="placa"></td>
								<td style="width: 59px;">Marca :</td>
								<td><input type="text" name="marca"><br /></td>
							</tr>
							<tr>
								<td>Modelo :</td>
								<td><input type="text" name="modelo"></td>
								<td>Ano :</td>
								<td><input type="text" name="ano"><br /></td>
							</tr>
							<tr>
								<td>Comb :</td>
								<td><select name="combustivel" style="width: 170px">
										<option value="gasolina">Gasolina</option>
										<option value="alcool">Alcool</option>
										<option value="flex">Flex</option>
										<option value="diesel">Diesel</option>
								</select></td>
								<td></td>
							</tr>

							<tr>
								<td>Problemas :</td>
								<td colspan="3"><textarea rows="" cols="" name="problemas"
										style="margin: 0px; height: 56px; width: 410px;">
							
							</textarea></td>
							</tr>
						</table>
					</fieldset>
					<input type="submit" name="acao" value="Abrir">
				</form>
			</div>
		</div>
	</div>
	<div id="rodape">
		<div class="central"></div>
	</div>
</body>
</html>