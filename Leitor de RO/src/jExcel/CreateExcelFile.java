package jExcel;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controle.Controle;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import model.Linha_10;
import model.Linha_20;

public class CreateExcelFile {
	
	static CreateExcelFile instancia;
	
	private CreateExcelFile() {
	}
	
	public static CreateExcelFile getInstance(){
		
		if(instancia==null){
			instancia = new CreateExcelFile();
			return instancia;
		}else{
			return instancia;
		}
		
	}
	
	public void ExcelTipo10(ArrayList<Linha_10> Conteudo,String name,String namearq){
		ArrayList<Linha_10> con = Conteudo;
		
		try {
			
			System.out.println(name+"\\"+namearq);
			
			WritableWorkbook planilha = Workbook.createWorkbook(new File(
					name+"\\"+namearq+".xls"));
			
			WritableSheet aba = planilha.createSheet("Movimento", 0);
			
			Colour bckcolor = Colour.ICE_BLUE;
			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setBackground(bckcolor);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			WritableFont fonte = new WritableFont(WritableFont.ARIAL);
			fonte.setColour(Colour.BLACK);
			cellFormat.setFont(fonte);
			
			
			
			String cabecalho[] = new String[30];
			cabecalho[0] = "Tipo de Registro";
			cabecalho[1] = "Número de Aviso de Sinistro";
			cabecalho[2] = "Número da Apólice";
			cabecalho[3] = "Número do Endosso";
			cabecalho[4] = "Código do Item de Sinistro";
			cabecalho[5] = "Número de Ordem do Ocorrido";
			cabecalho[6] = "Código do Ramo";
			cabecalho[7] = "Código da Cobertura";
			cabecalho[8] = "Código do Evento";
			cabecalho[9] = "Data do Aviso";
			cabecalho[10] = "Data da Ocorrência";
			cabecalho[11] = "Tipo de Comunicante";
			cabecalho[12] = "Número do Sinistro no IRB";
			cabecalho[13] = "Código da Moeda";
			cabecalho[14] = "Descrição do Sinistro";
			cabecalho[15] = "Valor do Aviso";
			cabecalho[16] = "Data do Contrato Habitacional";
			cabecalho[17] = "Numeo do Contrato Habitacional";
			cabecalho[18] = "UF do Contrato Habitacional";
			cabecalho[19] = "Nome do Mutuário/Segurado";
			cabecalho[20] = "Data Nascimento Mutuário/Segurado";
			cabecalho[21] = "Sexo do Mutuário/Segurado";
			cabecalho[22] = "Numero CPF Mutuário/Segurado";
			cabecalho[23] = "Endereço do Sinistro";
			cabecalho[24] = "Número de Endereço do Sinistro";
			cabecalho[25] = "Descrição do Complemento do Endereço";
			cabecalho[26] = "Nome do Bairro do Sinistro";
			cabecalho[27] = "Nome da Cidade";
			cabecalho[28] = "UF do Sinistro";
			cabecalho[29] = "filler";
		
		for (int i = 0; i < cabecalho.length; i++) {
				Label label = new Label(i, 0, cabecalho[i]);
				aba.addCell(label);
				
				WritableCell cell = aba.getWritableCell(i, 0);
				cell.setCellFormat(cellFormat);
				
			}
		
		
		for(int linha=0; linha< con.size();linha++){
			
			Label label = new Label(0, (linha+1), Conteudo.get(linha).getLinha().substring(0, 2));
			aba.addCell(label);
			Label label1 = new Label(1, (linha+1), Conteudo.get(linha).getLinha().substring(2, 13));
			aba.addCell(label1);
			Label label2 = new Label(2, (linha+1), Conteudo.get(linha).getLinha().substring(13, 24));
			aba.addCell(label2);
			Label label3 = new Label(3, (linha+1), Conteudo.get(linha).getLinha().substring(24, 30));
			aba.addCell(label3);
			Label label4 = new Label(4, (linha+1), Conteudo.get(linha).getLinha().substring(30, 34));
			aba.addCell(label4);
			Label label5 = new Label(5, (linha+1), Conteudo.get(linha).getLinha().substring(34, 38));
			aba.addCell(label5);
			Label label6 = new Label(6, (linha+1), Conteudo.get(linha).getLinha().substring(38, 42));
			aba.addCell(label6);
			Label label7 = new Label(7, (linha+1), Conteudo.get(linha).getLinha().substring(42, 46));
			aba.addCell(label7);
			Label label8 = new Label(8, (linha+1), Conteudo.get(linha).getLinha().substring(46, 51));
			aba.addCell(label8);
			Label label9 = new Label(9, (linha+1), Conteudo.get(linha).getLinha().substring(51, 59));
			aba.addCell(label9);
			Label label10 = new Label(10, (linha+1), Conteudo.get(linha).getLinha().substring(59, 67));
			aba.addCell(label10);
			Label label11 = new Label(11, (linha+1), Conteudo.get(linha).getLinha().substring(67, 68));
			aba.addCell(label11);
			Label label12 = new Label(12, (linha+1), Conteudo.get(linha).getLinha().substring(68, 88));
			aba.addCell(label12);
			Label label13 = new Label(13, (linha+1), Conteudo.get(linha).getLinha().substring(88, 92));
			aba.addCell(label13);
			Label label14 = new Label(14, (linha+1), Conteudo.get(linha).getLinha().substring(92, 592).trim());
			aba.addCell(label14);
			Label label15 = new Label(15, (linha+1), Conteudo.get(linha).getLinha().substring(592, 607));
			aba.addCell(label15);
			Label label16 = new Label(16, (linha+1), Conteudo.get(linha).getLinha().substring(607, 615));
			aba.addCell(label16);
			Label label17 = new Label(17, (linha+1), Conteudo.get(linha).getLinha().substring(615, 645));
			aba.addCell(label17);
			Label label18 = new Label(18, (linha+1), Conteudo.get(linha).getLinha().substring(645, 647));
			aba.addCell(label18);
			Label label19 = new Label(19, (linha+1), Conteudo.get(linha).getLinha().substring(647, 697));
			aba.addCell(label19);
			Label label20 = new Label(20, (linha+1), Conteudo.get(linha).getLinha().substring(697, 705));
			aba.addCell(label20);
			Label label21 = new Label(21, (linha+1), Conteudo.get(linha).getLinha().substring(705, 706));
			aba.addCell(label21);
			Label label22 = new Label(22, (linha+1), Conteudo.get(linha).getLinha().substring(706, 721));
			aba.addCell(label22);
			Label label23 = new Label(23, (linha+1), Conteudo.get(linha).getLinha().substring(721, 821));
			aba.addCell(label23);
			Label label24 = new Label(24, (linha+1), Conteudo.get(linha).getLinha().substring(821, 826));
			aba.addCell(label24);
			Label label25 = new Label(25, (linha+1), Conteudo.get(linha).getLinha().substring(826, 866));
			aba.addCell(label25);
			Label label26 = new Label(26, (linha+1), Conteudo.get(linha).getLinha().substring(866, 896));
			aba.addCell(label26);
			Label label27 = new Label(27, (linha+1), Conteudo.get(linha).getLinha().substring(896, 926));
			aba.addCell(label27);
			Label label28 = new Label(28, (linha+1), Conteudo.get(linha).getLinha().substring(926, 928));
			aba.addCell(label28);
			Label label29 = new Label(29, (linha+1), Conteudo.get(linha).getLinha().substring(928, 932));
			aba.addCell(label29);
			
			
		}
		
		planilha.write();
		// Fecha o arquivo
		planilha.close();	
		
		//JOptionPane.showMessageDialog(null, "Planilha Criada em: "+destino+name);
		
		int opt = JOptionPane.showOptionDialog(null, "Planilha Criada em: "+name, "Informação", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Abrir Pasta","Continuar"}, new String[]{"Abrir Pasta"});
		if (opt == 0){
			Runtime.getRuntime().exec("explorer "+name);
		}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "300 anos tentando mas algo falhou na criação de planilha do tipo 10");
			Controle.getInstance().logErro(e.toString(),"ExcelTipo10",this.getClass().getName());
			e.printStackTrace();
			
			
		}
		
		
		
		
	}
	
	public void ExcelTipo20(ArrayList<Linha_20> Conteudo,String name,String namearq){
		ArrayList<Linha_20> con = Conteudo;
		
		
		
		try {
			System.out.println(name+"\\"+namearq);
		
			WritableWorkbook planilha = Workbook.createWorkbook(new File(name+"\\"+namearq+".xls"));
			
			WritableSheet aba = planilha.createSheet("Movimento", 0);
			
			Colour bckcolor = Colour.ICE_BLUE;
			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setBackground(bckcolor);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			WritableFont fonte = new WritableFont(WritableFont.ARIAL);
			fonte.setColour(Colour.BLACK);
			cellFormat.setFont(fonte);
			
			String cabecalho[] = new String[19];
			cabecalho[0] = "Tipo de Registro";
			cabecalho[1] = "Número de Aviso de Sinistro";
			cabecalho[2] = "Código do Item de Sinistro";
			cabecalho[3] = "Número de Ordem do Ocorrido";
			cabecalho[4] = "Código do Ramo";
			cabecalho[5] = "Código da Cobertura";
			cabecalho[6] = "Tipo de Movimento";
			cabecalho[7] = "Código do Evento";
			cabecalho[8] = "Tipo de Operação";
			cabecalho[9] = "Data do Movimento";
			cabecalho[10] = "Nome do Recebedor/Beneficiário";
			cabecalho[11] = "Numero CPF Recebedor/Beneficiário";
			cabecalho[12] = "Valor Movimento";
			cabecalho[13] = "Valor Estimativa Indenização";
			cabecalho[14] = "Valor Estimativa Despesa";
			cabecalho[15] = "Valor Estimativa Honorário";
			cabecalho[16] = "Número do Sinistro no IRB";
			cabecalho[17] = "Filler";
			cabecalho[18] = "Filler";
			
		
		for (int i = 0; i < cabecalho.length; i++) {
				Label label = new Label(i, 0, cabecalho[i]);
				aba.addCell(label);
				
				WritableCell cell = aba.getWritableCell(i, 0);
				cell.setCellFormat(cellFormat);
				
			}
		
		
		for(int linha=0; linha< con.size();linha++){
			
			Label label = new Label(0, (linha+1), Conteudo.get(linha).getLinha().substring(0, 2));
			aba.addCell(label);
			Label label1 = new Label(1, (linha+1), Conteudo.get(linha).getLinha().substring(2, 13));
			aba.addCell(label1);
			Label label2 = new Label(2, (linha+1), Conteudo.get(linha).getLinha().substring(13, 17));
			aba.addCell(label2);
			Label label3 = new Label(3, (linha+1), Conteudo.get(linha).getLinha().substring(17, 21));
			aba.addCell(label3);
			Label label4 = new Label(4, (linha+1), Conteudo.get(linha).getLinha().substring(21, 25));
			aba.addCell(label4);
			Label label5 = new Label(5, (linha+1), Conteudo.get(linha).getLinha().substring(25, 29));
			aba.addCell(label5);
			Label label6 = new Label(6, (linha+1), Conteudo.get(linha).getLinha().substring(29, 31));
			aba.addCell(label6);
			Label label7 = new Label(7, (linha+1), Conteudo.get(linha).getLinha().substring(31, 36));
			aba.addCell(label7);
			Label label8 = new Label(8, (linha+1), Conteudo.get(linha).getLinha().substring(36, 41));
			aba.addCell(label8);
			Label label9 = new Label(9, (linha+1), Conteudo.get(linha).getLinha().substring(41, 49));
			aba.addCell(label9);
			Label label10 = new Label(10, (linha+1), Conteudo.get(linha).getLinha().substring(49, 99));
			aba.addCell(label10);
			Label label11 = new Label(11, (linha+1), Conteudo.get(linha).getLinha().substring(99, 114));
			aba.addCell(label11);
			Label label12 = new Label(12, (linha+1), Conteudo.get(linha).getLinha().substring(114, 132));
			aba.addCell(label12);
			Label label13 = new Label(13, (linha+1), Conteudo.get(linha).getLinha().substring(132, 150));
			aba.addCell(label13);
			Label label14 = new Label(14, (linha+1), Conteudo.get(linha).getLinha().substring(150, 167));
			aba.addCell(label14);
			Label label15 = new Label(15, (linha+1), Conteudo.get(linha).getLinha().substring(167, 186));
			aba.addCell(label15);
			Label label16 = new Label(16, (linha+1), Conteudo.get(linha).getLinha().substring(186, 206));
			aba.addCell(label16);
			Label label17 = new Label(17, (linha+1), Conteudo.get(linha).getLinha().substring(206, 207));
			aba.addCell(label17);
			Label label18 = new Label(18, (linha+1), Conteudo.get(linha).getLinha().substring(207, 932).trim());
			aba.addCell(label18);
			
			
			
		}
		
		
		
			
		planilha.write();
		// Fecha o arquivo
		planilha.close();	
		
		//JOptionPane.showMessageDialog(null, "Planilha Criada em: "+destino+name);
			
		int opt = JOptionPane.showOptionDialog(null, "Planilha Criada em: "+name, "Informação", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Abrir Pasta","Continuar"}, new String[]{"Abrir Pasta"});
		if (opt == 0){
			Runtime.getRuntime().exec("explorer "+name);
		}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "300 anos tentando mas algo falhou na criaçãao de planilha do tipo 20");
			Controle.getInstance().logErro(e.toString(),"ExcelTipo20",this.getClass().getName());
			
		}
		
		
		
		
	}
	
	

}
