package model;

import enums.Movimentos;

public class Totais {
	
	
	private String ramo = "";
	private double Total = 0;
	private Movimentos movimento;
	
	
	
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	public Movimentos getMovimento() {
		return movimento;
	}
	public void setMovimento(Movimentos movimento) {
		this.movimento = movimento;
	}
	
	public boolean comparaRamo(String ramo) {
		
		if (ramo.equals(this.ramo)) return true;
		
		return false;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
