package controle;

import java.text.NumberFormat;
import java.util.ArrayList;

import model.Arquivo_20;
import model.Linha_20;
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
		ArrayList<String> ramos = new ArrayList<>();
		ArrayList<String> tp_movs = new ArrayList<>();
		
		//8 tipos de movimentos
		tp_movs.add("");tp_movs.add("");tp_movs.add("");tp_movs.add("");
		tp_movs.add("");tp_movs.add("");tp_movs.add("");tp_movs.add("");
		
		String resumo = "";
		double valor = 0;
		
		for (Linha_20 linha_20 : arquivo.getLinhas()) {
			String ramo = linha_20.getCodigoDoRamo();
			if(!ramos.contains(ramo))ramos.add(ramo);
		}
		
		for (String ramo : ramos) {
			
			for(int i = 0; i < tp_movs.size();i++) {
				int contador = 0;
				for (Linha_20 linha_20 : arquivo.getLinhas()) {
					String tp = "";
					if(i<5) tp = "0"+(i+1);
					else tp = "0"+(i+2);
					//System.out.println(tp);
					if(linha_20.getCodigoDoRamo().equals(ramo) && 
						(linha_20.getTipodeMovimento().equals(tp))) {
					valor += (Double.parseDouble(linha_20.getValorMovimento())/100);
					contador++;
					}
				
				}
			
				resumo = tp_movs.get(i);
				resumo+=ramo+" - "+df.format(valor)+" - "+contador+"\n";
				tp_movs.set(i, resumo);
				valor = 0;
			}
			
		}
		
		resumo = "Solicitaçao Pagamento Total"+"\n";
		resumo += tp_movs.get(2); //03
		resumo += "Ajuste reserva a maior "+"\n";
		resumo += tp_movs.get(0); //01
		resumo += "Ajuste reserva a menor "+"\n";
		resumo += tp_movs.get(1); //02
		resumo += "Cancelamento do Aviso "+"\n";
		resumo += tp_movs.get(3); //04
		resumo += "Cobertura Negada "+"\n";
		resumo += tp_movs.get(6); //08
		resumo += "Reativação do Aviso "+"\n";
		resumo += tp_movs.get(4); //05
		resumo += "Baixa sem indenização"+"\n";
		resumo += tp_movs.get(5); //07
		resumo += "Solicitação Pagamento Parcial "+"\n";
		resumo += tp_movs.get(7); //09
		
	
		arquivo.setResumo(resumo);
	}

}
