<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="novoProduto" method="POST">
		<div>
			<label>Nome do produto:</label>
			<input type="text" name="nomeProduto" placeholder="Digite o nome do produto">
		</div>
		<div>
			<label>Descri��o do Produto:</label>
			<input type="text" name="descricaoProduto" placeholder="Digite a descri��o do produto">			
		</div>
		<div>
			<label>Pre�o do Produto:</label>
			<input name="precoProduto" placeholder="Digite o preco do produto">			
		</div>
		<div>
			<button type="submit">Cadastrar produto</button>
		</div>
	</form>
</body>
</html>