package model;

import java.text.NumberFormat;
import java.util.ArrayList;

import enums.Movimentos;

public class Arquivo_20 extends Arquivo {

	
	
	//private double valorTotalMovimento;
	private double valorTotalPagamento;
	private double valorTotalInd;
	private double valorTotalDes;
	private double valorTotalHon;
	private ArrayList<Linha_20> linhas;
	private ArrayList<String> ramos;
	
	
	private ArrayList<Totais> ajusteReservaAMaiorTotais;
	private ArrayList<Totais> ajusteReservaAMenorTotais;
	private ArrayList<Totais> solicitacaoPagamentoTotalTotais;
	private ArrayList<Totais> cancelamentoDoAvisoTotais;
	private ArrayList<Totais> reativacaoDoAvisoTotais;
	private ArrayList<Totais> baixaSemIndenizaçãoTotais;
	private ArrayList<Totais> coberturaNegadaTotais;
	private ArrayList<Totais> solicitacaoPagamentoParcialTotais;

	
	
	
	public Arquivo_20() {
	
		linhas = new ArrayList<>();
		
	}
	
	public ArrayList<String> getRamos() {
		ramos = new ArrayList<>();
		
		for (Linha_20 linha_20 : getLinhas()) {
			String ramo = linha_20.getCodigoDoRamo();
			if(!ramos.contains(ramo))ramos.add(ramo);
		}
		
		
		return ramos;
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

	
	public ArrayList<Totais> somarMovimentacao(Movimentos mov) {
		ArrayList<Totais> ret = new ArrayList<>();
		
		Totais tot;
		for(String ramo : getRamos()) {
			tot = new Totais();
			tot.setRamo(ramo);
			tot.setMovimento(mov);
			double val_tot = 0;
			for (Linha_20 linha_20 : getLinhas()) {
				if(Integer.parseInt(linha_20.getTipodeMovimento()) == tot.getMovimento().valor) {
					val_tot += (Double.parseDouble(linha_20.getValorMovimento())/100);
				}
			}
			tot.setTotal(val_tot);
			ret.add(tot);
		}
		return ret;
	}
	
	
	public ArrayList<Totais> getAjusteReservaAMaiorTotais() {
		return ajusteReservaAMaiorTotais = somarMovimentacao(Movimentos.Ajuste_reserva_a_maior);
	}

	public ArrayList<Totais> getAjusteReservaAMenorTotais() {
		return ajusteReservaAMenorTotais = somarMovimentacao(Movimentos.Ajuste_reserva_a_menor);
	}

	public ArrayList<Totais> getSolicitacaoPagamentoTotalTotais() {
		return solicitacaoPagamentoTotalTotais = somarMovimentacao(Movimentos.Solicitação_Pagamento_Total);
	}

	public ArrayList<Totais> getCancelamentoDoAvisoTotais() {
		return cancelamentoDoAvisoTotais = somarMovimentacao(Movimentos.Cancelamento_do_Aviso);
	}

	public ArrayList<Totais> getReativacaoDoAvisoTotais() {
		return reativacaoDoAvisoTotais = somarMovimentacao(Movimentos.Reativação_do_Aviso);
	}

	public ArrayList<Totais> getBaixaSemIndenizaçãoTotais() {
		return baixaSemIndenizaçãoTotais = somarMovimentacao(Movimentos.Baixa_sem_indenização);
	}

	public ArrayList<Totais> getCoberturaNegadaTotais() {
		return coberturaNegadaTotais = somarMovimentacao(Movimentos.Cobertura_Negada);
	}

	public ArrayList<Totais> getSolicitacaoPagamentoParcialTotais() {
		return solicitacaoPagamentoParcialTotais = somarMovimentacao(Movimentos.Solicitação_Pagamento_Parcial);
	}
	
	
	
	


	









}
