package controle;

import java.text.NumberFormat;
import java.util.ArrayList;

import model.Arquivo;
import model.Arquivo_10;
import model.Linha_10;
import view.View_Tipos;

public class Controle_Tipo_10 {
	
	private static Controle_Tipo_10 instancia;
	private Arquivo_10 arquivo;
	
	public static Controle_Tipo_10 getInstance(){
		 
		 if(instancia == null){
			 instancia = new Controle_Tipo_10();
			 return instancia;
		 }else{
			 return instancia;
		 }
		 
	 }
	
	
	public void receberArquivo(Arquivo_10 arquivo) {
		
		
		//teste de commit 3
		this.arquivo = arquivo;
		gerarResumo();
		new View_Tipos(arquivo,true);
		
		
	}
	
	public void gerarResumo() {
		
		NumberFormat df = NumberFormat.getCurrencyInstance();
		ArrayList<String> ramos = new ArrayList<>();
		String resumo = "";
		double valor = 0;
		
		for (Linha_10 linha_10 : arquivo.getLinhas()) {
			String ramo = linha_10.getCodigoDoRamo();
			if(!ramos.contains(ramo))ramos.add(ramo);
		}
		
		for (String string : ramos) {
			int contador = 0;
			for (Linha_10 linha_10 : arquivo.getLinhas()) {
				
				if(linha_10.getCodigoDoRamo().equals(string)) {
					valor += (Double.parseDouble(linha_10.getValorDoAviso())/100);
					contador++;
				}
					//System.out.println(linha_10.getValorDoAviso());
				
			}
			
			resumo += string+" - "+df.format(valor)+" - "+contador+"\n";
			valor = 0;
		}
		
		
		
		arquivo.setResumo(resumo);
		
	}

}
