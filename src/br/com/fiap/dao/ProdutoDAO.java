package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Produto;

public class ProdutoDAO {
	//Substitui o banco de dados por uma lista
	private static final List<Produto>PRODUTOS = new ArrayList<Produto>();
	
	//Instancia 2 objetos Produto na hora de sua execu��o
	static {
		PRODUTOS.add(new Produto("Notebook Asus", "Memoria interna 1TB, Memoria RAM 16GB, 4 porta USB 4.0" ,2.500));
		PRODUTOS.add(new Produto("Smartphone Samsumg S9", "Memoria interna 64GB, Fast Charge, Camera 18MP", 3.900));
	}
	
	//Adiciona um novo produto atrav�s do par�metro que � passado para ele
	public String novoProduto(Produto prod) {
		PRODUTOS.add(prod);
		return "Produto cadastrado com sucesso!";
	}
	
	//Pesquisa por produtos retornando uma lista
	public List<Produto> pesquisaProduto(String nome){
		//Verifica se o parametro est� vazio, caso o user n�o tenha digitado nada
		if(nome == null) {
			return PRODUTOS;
		}
		//Sen�o retorna o que ele pesquisou
		List<Produto> produtosPesquisados = new ArrayList<Produto>();
		//Percorre toda lista de produtos e verifica se existe um produto semelhante ao pesquisado
		for(Produto p : PRODUTOS) {
			if(p.getNome().toLowerCase().contains(nome.toLowerCase())) {
				produtosPesquisados.add(p);
			}		
		}
		return produtosPesquisados;
	}
}
