package br.com.fiap.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.Produto;
import br.com.fiap.dao.ProdutoDAO;

@WebServlet(urlPatterns = "/novoProduto")
public class CadastroProduto extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter wr = resp.getWriter();
		
		//criando 3 variáveis para receber o que vem do formulário
		
		String nome = req.getParameter("nomeProduto");
		String descricao = req.getParameter("descricaoProduto");
		double preco = Double.parseDouble(req.getParameter("precoProduto"));
		
		//instanciando a classe Produto usando construtor cheio
		Produto p = new Produto(nome, descricao, preco);
		
		//instanciando a classe ProdutoDAO
		ProdutoDAO dao = new ProdutoDAO();
		
		//inserindo um novo produto e armazenando em uma variável o retorno do método
		String result = dao.novoProduto(p);
		wr.println("<html><body>");
		if(!(result.equals("Produto cadastrado com sucesso!"))) {
			//o cadastro não foi bem sucedido
			wr.println("Ocorreu um erro ao cadastrar o produto!");
			wr.println("<a href='index.jsp'>Voltar</a>");
		}else {
			//o cadastro foi bem sucedido
			wr.println("Cadastro realizado com sucesso!");
			wr.println("<a href='pesquisarProduto.jsp'>Pesquisar Produto</a>");
			wr.println("<a href='index.jsp'>Voltar</a>");
		}
		wr.println("</body></html>");
	}
}
