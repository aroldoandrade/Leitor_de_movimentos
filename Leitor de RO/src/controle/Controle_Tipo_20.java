package controle;

import java.text.NumberFormat;
import java.util.ArrayList;

import enums.Movimentos;
import model.Arquivo_20;
import model.Linha_10;
import model.Linha_20;
import model.Totais;
import view.View_Tipos;

public class Controle_Tipo_20 {
	
	private static Controle_Tipo_20 instancia;
	private Arquivo_20 arquivo;
	
	public static Controle_Tipo_20 getInstance(){
		 
		 if(instancia == null){
			 instancia = new Controle_Tipo_20();
			 return instancia;
		 }else{
			 return instancia;
		 }
		 
	 }
	
	
	public void receberArquivo(Arquivo_20 arquivo) {
		
		this.arquivo = arquivo;
		gerarResumo();
		new View_Tipos(arquivo,true);

	}
	
	
	public void gerarResumo() {
		
		NumberFormat df = NumberFormat.getCurrencyInstance();
		
		String resumo="Ajuste Reserva a Maior:\n";
		for(Totais tot : arquivo.getAjusteReservaAMaiorTotais()) {
			resumo+="Ramo: "+tot.getRamo()+"\n";
			resumo+="Valor: "+df.format(tot.getTotal())+"\n";
		}
		resumo+="Ajuste Reserva a Menor:\n";
		for(Totais tot : arquivo.getAjusteReservaAMenorTotais()) {
			resumo+="Ramo: "+tot.getRamo()+"\n";
			resumo+="Valor: "+df.format(tot.getTotal())+"\n";
		}
		
		resumo+="Solicitação Pagamento Total:\n";
		for(Totais tot : arquivo.getSolicitacaoPagamentoTotalTotais()) {
			resumo+="Ramo: "+tot.getRamo()+"\n";
			resumo+="Valor: "+df.format(tot.getTotal())+"\n";
		}
		
		resumo+="Solicitação Pagamento Parcial:\n";
		for(Totais tot : arquivo.getSolicitacaoPagamentoParcialTotais()) {
			resumo+="Ramo: "+tot.getRamo()+"\n";
			resumo+="Valor: "+df.format(tot.getTotal())+"\n";
		}
		
		arquivo.setResumo(resumo);
	}

}
