package model;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Arquivo_10 extends Arquivo {
	
	
	
	private double valorTotalAviso;
	private ArrayList<Linha_10> linhas;

	
	
	public Arquivo_10() {
		
		linhas = new ArrayList<>();
		
	}
	
	
	@Override
	public void setResumo(String resumo) {
		super.setResumo(resumo);
	}


	@Override
	public String getResumo() {
		
		return super.getResumo();
	}

	@Override
	public int getContagem() {
		
		return linhas.size();
		
	}

/*
	public double getValorTotalAviso() {
		valorTotalAviso = 0;
		
		for (Linha_10 linha_10 : linhas) {
			
			valorTotalAviso += (Double.parseDouble(linha_10.getValorDoAviso())/100);
			
		}
		
		return valorTotalAviso;
	}
*/


	public void setValorTotalAviso(double valorTotalAviso) {
		this.valorTotalAviso = valorTotalAviso;
	}



	public ArrayList<Linha_10> getLinhas() {
		return linhas;
	}



	public void setLinhas(ArrayList<Linha_10> linhas) {
		this.linhas = linhas;
	}

	
	
	
	

}
