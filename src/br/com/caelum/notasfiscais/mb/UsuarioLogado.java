package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public boolean isLogado() {
		return usuario != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
