package model;

import java.io.File;

public class Arquivo {

	
	private String nome;
	private String tipo;
	private File arq;
	private String resumo;
	
	
	
	public Arquivo() {
	
		
	}

	

	public File getArq() {
		return arq;
	}



	public void setArq(File arq) {
		this.arq = arq;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getResumo() {
		return resumo;
	}


	public int getContagem() {
		
		return 0;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	
	
}
