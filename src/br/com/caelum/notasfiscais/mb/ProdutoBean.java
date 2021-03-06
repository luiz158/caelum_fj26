package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@ViewScoped
public class ProdutoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();

	private List<Produto> produtos;
	
	public void grava(){
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		if(produto.getId() == null) {
			dao.adiciona(produto);
		}else {
			dao.atualiza(produto);
		}
		this.produto = new Produto();
		this.produtos = null;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if(produtos == null) {
			System.out.println("Carregando produtos...");
			produtos = new DAO<Produto>(Produto.class).listaTodos();
		}
		return produtos;
	}
	
	public void remove(Produto produto) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}
}
