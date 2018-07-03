package model;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Arquivo_20 extends Arquivo {

	
	
	//private double valorTotalMovimento;
	private double valorTotalPagamento;
	private double valorTotalInd;
	private double valorTotalDes;
	private double valorTotalHon;
	private ArrayList<Linha_20> linhas;
	private double AjusteReservaAMaior;
	private double AjusteReservaAMenor;
	private double SolicitacaoPagamentoTotal;
	private double CancelamentoDoAviso;
	private double ReativacaoDoAviso;
	private double BaixaSemIndenização;
	private double CoberturaNegada;
	private double SolicitacaoPagamentoParcial;

	
	
	
	public Arquivo_20() {
	
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




	public ArrayList<Linha_20> getLinhas() {
		return linhas;
	}



	public void setLinhas(ArrayList<Linha_20> linhas) {
		this.linhas = linhas;
	}



	
	public double getValorTotalPagamento() {
		
		valorTotalPagamento = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("03")||linha_20.getTipodeMovimento().equals("09")) {
				
				valorTotalPagamento += (Double.parseDouble(linha_20.getValorMovimento())/100);
				
			}
			
		}
		
		return valorTotalPagamento;
	}



	public void setValorTotalPagamento(double valorTotalPagamento) {
		this.valorTotalPagamento = valorTotalPagamento;
	}



	public double getValorTotalInd() {
		
		valorTotalInd = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("03")||linha_20.getTipodeMovimento().equals("09")) {
				
				valorTotalInd += (Double.parseDouble(linha_20.getValorEstimativaIndenizacao())/100);
				
			}
			
		}
		
		return valorTotalInd;
		
	}
	public void setValorTotalInd(double valorTotalInd) {
		this.valorTotalInd = valorTotalInd;
	}
	public double getValorTotalDes() {
		return valorTotalDes;
	}
	public void setValorTotalDes(double valorTotalDes) {
		
		
		valorTotalDes = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("03")||linha_20.getTipodeMovimento().equals("09")) {
				
				valorTotalDes += (Double.parseDouble(linha_20.getValorEstimativaDespesa())/100);
				
			}
			
		}
		
		
		this.valorTotalDes = valorTotalDes;
	}
	
	public double getValorTotalHon() {
		
		valorTotalHon = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("03")||linha_20.getTipodeMovimento().equals("09")) {
				
				valorTotalHon += (Double.parseDouble(linha_20.getValorEstimativaHonorario())/100);
				
			}
			
		}
		
		return valorTotalHon;
	}
	public void setValorTotalHon(double valorTotalHon) {
		this.valorTotalHon = valorTotalHon;
	}


	public double getAjusteReservaAMaior() {
		
		
		AjusteReservaAMaior = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("01")) {
				
				AjusteReservaAMaior += (Double.parseDouble(linha_20.getValorMovimento())/100);
				
			}
			
		}
		
		return AjusteReservaAMaior;
	}


	public void setAjusteReservaAMaior(double ajusteReservaAMaior) {
		AjusteReservaAMaior = ajusteReservaAMaior;
	}


	public double getAjusteReservaAMenor() {
		
		AjusteReservaAMenor = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("02")) {
				
				AjusteReservaAMenor += (Double.parseDouble(linha_20.getValorMovimento())/100);
				
			}
			
		}
		
		return AjusteReservaAMenor;
	}


	public void setAjusteReservaAMenor(double ajusteReservaAMenor) {
		AjusteReservaAMenor = ajusteReservaAMenor;
	}


	public double getSolicitacaoPagamentoTotal() {
		
		
		SolicitacaoPagamentoTotal = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("03")) {
				
				SolicitacaoPagamentoTotal += (Double.parseDouble(linha_20.getValorMovimento())/100);
				
			}
			
		}
		
		
		return SolicitacaoPagamentoTotal;
	}


	public void setSolicitacaoPagamentoTotal(double solicitacaoPagamentoTotal) {
		SolicitacaoPagamentoTotal = solicitacaoPagamentoTotal;
	}


	public double getCancelamentoDoAviso() {
		
		CancelamentoDoAviso = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("04")) {
				
				CancelamentoDoAviso += (Double.parseDouble(linha_20.getValorMovimento())/100);
				
			}
			
		}
		
		
		return CancelamentoDoAviso;
	}


	public void setCancelamentoDoAviso(double cancelamentoDoAviso) {
		CancelamentoDoAviso = cancelamentoDoAviso;
	}


	public double getReativacaoDoAviso() {
		
		ReativacaoDoAviso = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("05")) {
				
				ReativacaoDoAviso += (Double.parseDouble(linha_20.getValorMovimento())/100);
				
			}
			
		}
		
		
		return ReativacaoDoAviso;
	}


	public void setReativacaoDoAviso(double reativacaoDoAviso) {
		ReativacaoDoAviso = reativacaoDoAviso;
	}


	public double getBaixaSemIndenização() {
		
		
		BaixaSemIndenização = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("07")) {
				
				BaixaSemIndenização += (Double.parseDouble(linha_20.getValorMovimento())/100);
				
			}
			
		}
		
		
		return BaixaSemIndenização;
	}


	public void setBaixaSemIndenização(double baixaSemIndenização) {
		BaixaSemIndenização = baixaSemIndenização;
	}


	public double getCoberturaNegada() {
		
		CoberturaNegada = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("08")) {
				
				CoberturaNegada += (Double.parseDouble(linha_20.getValorMovimento())/100);
				
			}
			
		}
		
		return CoberturaNegada;
	}


	public void setCoberturaNegada(double coberturaNegada) {
		CoberturaNegada = coberturaNegada;
	}


	public double getSolicitacaoPagamentoParcial() {
		
		SolicitacaoPagamentoParcial = 0;
		
		for (Linha_20 linha_20 : linhas) {
			
			if(linha_20.getTipodeMovimento().equals("09")) {
				
				SolicitacaoPagamentoParcial += (Double.parseDouble(linha_20.getValorMovimento())/100);
				
			}
			
		}
		
		return SolicitacaoPagamentoParcial;
	}

	public void setSolicitacaoPagamentoParcial(double solicitacaoPagamentoParcial) {
		SolicitacaoPagamentoParcial = solicitacaoPagamentoParcial;
	}
}
