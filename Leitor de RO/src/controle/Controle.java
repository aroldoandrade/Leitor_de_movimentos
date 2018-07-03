package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import jExcel.CreateExcelFile;
import model.Arquivo;
import model.Arquivo_10;
import model.Arquivo_20;
import model.Linha;
import model.Linha_10;
import model.Linha_20;
import view.View;
import view.View_Tipos;

public class Controle {
	

	Properties prop = new Properties();
	private String destinoPlan;
	private static Controle instancia;
	
	
	 
	 
	 public static Controle getInstance(){
		 
		 if(instancia == null){
			 instancia = new Controle();
			 return instancia;
		 }else{
			 return instancia;
		 }
		 
	 }

	private Controle() {
	 
		 
	}
	 public String getDestino() {
			return destinoPlan;
		}
	 
	 
	public void receberArquivo(File file, String acao) {
		
		if(acao.equals("importar"))
	 		trataArquivo(file);
	 	else if(acao.equals("validar")) {
	 		Arquivo arquivo = retornaConteudo(file.getAbsolutePath());
	 		if (arquivo==null) return;
	 		arquivo.setNome(file.getName());
	 		Controle_validador.getInstance().trataArquivo(arquivo); 
	 	}
		
	}
	
	public void trataArquivo(File file) {
		
		
		Arquivo arquivo = retornaConteudo(file.getAbsolutePath());
		if(arquivo == null) return;
		
		
		arquivo.setArq(file);
		arquivo.setNome(file.getName());
		
		
		 if(arquivo.getTipo().equals("20")){
			 
			 Controle_Tipo_20.getInstance().receberArquivo((Arquivo_20)arquivo);
			 
		 }else if(arquivo.getTipo().equals("10")){
			 
			 Controle_Tipo_10.getInstance().receberArquivo((Arquivo_10)arquivo);
			  
			  
			  
		 }else{
			  JOptionPane.showMessageDialog(null, "Arquivo desconhecido!");
			  
		  }
		
	}
	
	
	public void MontarExcel(Arquivo arq) {
		
	
		if(arq.getTipo().equals("10")) {
			
			CreateExcelFile.getInstance().ExcelTipo10(((Arquivo_10)arq).getLinhas(), arq.getArq().getParent(),arq.getArq().getName());
			
		}else if (arq.getTipo().equals("20")) {
			
			CreateExcelFile.getInstance().ExcelTipo20(((Arquivo_20)arq).getLinhas(), arq.getArq().getParent(),arq.getArq().getName());
				
		}	
	}
	
	private boolean VerificarProp(){
		File cret = new File("conf\\");
		 if(!cret.exists()){
			 
			 int opt = JOptionPane.showConfirmDialog(null, "Tem algo de errado na pasta de propriedades, você quer que eu crie uma nova?","ATENï¿½ï¿½O",
					 JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			 if(opt == 0){
			 cret.mkdir();
			 FileWriter arq;
			try {
				arq = new FileWriter("conf\\prop.properties");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.println("Pasta.destino.planilhas = res\\\\");
				arq.flush();
				arq.close();
				prop = getProp();
				destinoPlan = prop.getProperty("Pasta.destino.planilhas");
				
			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "Deu zebra na criação das propriedades.");
				logErro(e.toString(),"VerificarProp",this.getClass().getName());
			}
			
			 }else{
				 JOptionPane.showMessageDialog(null, "Ok, porem ate alguémm criar eu não posso continuar.");
				 return false;
			 }
			 
		 }
		
		return true;
		
	}
	 
	 public Properties getProp() throws IOException {
			Properties props = new Properties();
			FileInputStream file = new FileInputStream(
					"conf\\prop.properties");
			props.load(file);
			return props;

		}
	 
	 public void logErro(String erro, String metodo, String classe){
		 
		 File cret = new File("log\\");
		 if(!cret.exists()){
			 
			 int opt = JOptionPane.showConfirmDialog(null, "Acho que a pasta de log nï¿½o foi criada, posso chama no mamï¿½o nessa criaï¿½ï¿½o?","ATENï¿½ï¿½O",
					 JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			 if(opt == 0){
				 cret.mkdir(); 
				 
			 }else{
				 JOptionPane.showMessageDialog(null, "Certo, mas eu nï¿½o me responsabilizo por vocï¿½ nï¿½o saber o que deu de errado.");
				 
			 }
		 
		 }
		 try {
			 
				FileWriter fil = new FileWriter("log\\logErro.txt", true);
				PrintWriter gravarArq = new PrintWriter(fil);
				gravarArq.println("-----------------------------------------------------------------");
				gravarArq.println(erro.toString());
				gravarArq.println("Metodo: "+metodo+"  Classe: "+classe);
				gravarArq.println(new Date().toString());
				gravarArq.println("------------------------------------------------------------------");
				fil.flush();
				fil.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo de log");
				JOptionPane.showMessageDialog(null, e1.toString());
			}
		 
	 }
	 
	 public Arquivo retornaConteudo(String nome){
		 
		 Arquivo arquivo = null;
		 String linha = "";
		
		 try {
		        FileReader arq = new FileReader(nome);
		        BufferedReader lerArq = new BufferedReader(arq);
		        linha = lerArq.readLine();//header
		        linha = lerArq.readLine();//primeiralinha
		        
		        if(linha.startsWith("10")) {
		        	
		        	arquivo = new Arquivo_10();
		        	arquivo.setTipo("10");
		        	
		        }else if(linha.startsWith("20")) {
		        	
		        	arquivo = new Arquivo_20();
		        	arquivo.setTipo("20");
		        	
		        }else {
		        	LancaException("Tipo de arquivo desconhecido");
		        }
		        
		     while (linha != null) { 
		    	 
		        if(linha.startsWith("10")) {
		        	
		        	
		        	Linha_10 lin10 = new Linha_10(); 
		        	
		        	lin10.setTipoDeRegistro(linha.substring(0, 2));
		        	lin10.setNumeroDeAvisoDeSinistro(linha.substring(2, 13));
		        	lin10.setNumeroDaApolice(linha.substring(13, 24));
		        	lin10.setNumeroDoEndosso(linha.substring(24, 30));
		        	lin10.setCodigoDoItemDeSinistro(linha.substring(30, 34));
		        	lin10.setNumeroDeOrdemDoOcorrido(linha.substring(34, 38));
		        	lin10.setCodigoDoRamo(linha.substring(38, 42));
		        	lin10.setCodigoDaCobertura(linha.substring(42, 46));
		        	lin10.setCodigoDoEvento(linha.substring(46, 51));
		        	lin10.setDataDoAviso(linha.substring(51, 59));
		        	lin10.setDataDaOcorroncia(linha.substring(59, 67));
		        	lin10.setTipoDeComunicante(linha.substring(67, 68));
		        	lin10.setNumeroDoSinistroNoIRB(linha.substring(68, 88));
		        	lin10.setCodigoDaMoeda(linha.substring(88, 92));
		        	lin10.setDescricaoDoSinistro(linha.substring(92, 592));
		        	lin10.setValorDoAviso(linha.substring(592, 607));
		        	lin10.setDataDoContratoHabitacional(linha.substring(607, 615));
					lin10.setNumeoDoContratoHabitacional(linha.substring(615, 645));
					lin10.setUFDoContratoHabitacional(linha.substring(645, 647));
					lin10.setNomeDoMutuarioOuSegurado(linha.substring(647, 697));
					lin10.setDataNascimentoMutuarioOuSegurado(linha.substring(697, 705));
					lin10.setSexoDoMutuarioOuSegurado(linha.substring(705, 706));
					lin10.setNumeroCPFMutuarioOuSegurado(linha.substring(706, 721));
					lin10.setEnderecoDoSinistro(linha.substring(721, 821));
					lin10.setNumeroDeEnderecoDoSinistro(linha.substring(821, 826));
					lin10.setDescricaoDoComplementoDoEndereco(linha.substring(826, 866));
					lin10.setNomeDoBairroDoSinistro(linha.substring(866, 896));
					lin10.setNomeDaCidade(linha.substring(896, 926));
					lin10.setUFDoSinistro(linha.substring(926, 928));
					lin10.setFiller(linha.substring(928, 932));
					lin10.setLinha(linha);
					
		        	((Arquivo_10)arquivo).getLinhas().add(lin10);
					
		        }else if(linha.startsWith("20")) {
		        	
		        	Linha_20 lin20 = new Linha_20();
		        	lin20.setTipoDeRegistro(linha.substring(0, 2));
		        	lin20.setNumeroDeAvisoDeSinistro(linha.substring(2, 13));
		        	lin20.setCodigoDoItemDeSinistro(linha.substring(13, 17));
		        	lin20.setNumeroDeOrdemDoOcorrido(linha.substring(17, 21));
		        	lin20.setCodigoDoRamo(linha.substring(21, 25));
		        	lin20.setCodigoDaCobertura(linha.substring(25, 29));
		        	lin20.setTipodeMovimento(linha.substring(29, 31));
		        	lin20.setCodigoDoEvento(linha.substring(31, 36));
		        	lin20.setTipoDeOperacao(linha.substring(36, 41));
		        	lin20.setDataDoMovimento(linha.substring(41, 49));
		        	lin20.setNomedoRecebedorOuBeneficiario(linha.substring(49, 99));
		        	lin20.setNumeroCPFRecebedorOuBeneficiario(linha.substring(99, 114));
		        	lin20.setValorMovimento(linha.substring(114, 132));
		        	lin20.setValorEstimativaIndenizacao(linha.substring(132, 150));
		        	lin20.setValorEstimativaDespesa(linha.substring(150, 167));
		        	lin20.setValorEstimativaHonorario(linha.substring(167, 186));
		        	lin20.setNumeroDoSinistroNoIRB(linha.substring(186, 206));
		        	lin20.setFiller(linha.substring(206, 207));
		        	lin20.setFiller2(linha.substring(207, 932));
		        	lin20.setLinha(linha);
		        	((Arquivo_20)arquivo).getLinhas().add(lin20);
		        	
		        }else {
		        	
		        	//chegou na ultima linha
		        	
		        }
		        
		        
		        linha = lerArq.readLine(); 
		     }
		     	//System.out.println(conteudo);
		        arq.close();
		 
		 } catch (Exception e) { 
		       JOptionPane.showMessageDialog(null, "Deu erro no metodo retornaConteudo, infelizmente não vou poder processar esse arquivo;");
		       logErro(e.toString(),"retornaConteudo Nome Arquivo: "+nome,this.getClass().getName());
		       e.printStackTrace();
		       return null;
		       
		 } 
		
		 return arquivo;
	 }

	private void LancaException(String texto) throws Exception {
		throw new Exception(texto);
	}


	public void start() {
		
		new View();
		
	} 
	         

}
