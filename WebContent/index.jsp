<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>OFICINA DB4O TABD</title>
	<link rel="stylesheet" href="CSS/index.css"/>
</head>
<body>
	<section id="topo">
		<div class="centraliza">
			<div id="logos">
				<div class="logoOF"><img src="IMG/logo.png"/></div>
				<div class="logo"><img src="IMG/audi_logo.png"/></div>
				<div class="logo"><img src="IMG/bmw_logo.png"/></div>
				<div class="logo"><img src="IMG/ferrari_logo.png"/></div>
				<div class="logo"><img src="IMG/lamborghini_logo.png"/></div>
				<div class="logo"><img src="IMG/mercedes_logo.png"/></div>
				<div class="logo"><img src="IMG/Porsche_logo.png"/></div>
			</div>
			<div id="formularioLogin">
				<form action="ControleLogin">
					<input type="text" name="usuario" placeholder="Usuario">
					<input type="password" name="senha" placeholder="Senha">
					<input type="submit" name="acao" value="Entrar">
				</form>
			</div>
		</div>
	</section>
	<section id="conteudo"></section>
	<section id="rodape"></section>
</body>
</html>