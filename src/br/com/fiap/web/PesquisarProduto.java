package br.com.fiap.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.Produto;
import br.com.fiap.dao.ProdutoDAO;

@WebServlet(urlPatterns="/pesquisarProduto")
public class PesquisarProduto extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter wr = resp.getWriter();
		
		String nome = req.getParameter("nomeProduto");
		
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> prods = dao.pesquisaProduto(nome);
		
		wr.println("<body><html>");
		if(prods == null) {
			wr.println("Nenhum produto encontrado");
			wr.println("<a href='index.jsp'>Voltar</a>");
		}else {
			wr.println("Resultado da busca: <br />");
			wr.println("<a href='index.jsp'>Voltar</a>");
			for(Produto p : prods) {
				wr.println(p.getNome());
				wr.println(p.getDescricao());
				wr.println(p.getPreco());
				wr.println("<br />");
			}
		}	
		wr.println("</body></html>");
	}
}
