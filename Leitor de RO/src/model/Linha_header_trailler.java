package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Linha_header_trailler {
	
	private String linha;
	private String zerosOrNoves;
	private String tipoRegistro;
	private String dataDoMovimento;
	private String horaDaGeracao;
	private String NomeDoArquivo;
	private String filler;
	private String relatorioErros;
	
	
	
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		
		if(linha.length() != 923)
			setRelatorioErros("Tamanha do header diferente do padr�o");
		
		this.linha = linha;
	}
	public String getZerosOrNoves() {
		
		return zerosOrNoves;
	}
	public void setZerosOrNoves(String zerosOrNoves) {
		
		
		if(!zerosOrNoves.equals("0000000000") || !zerosOrNoves.equals("999999999"))
			setRelatorioErros("Tamanho do campos 1 diferente do padrão");
		
		
		this.zerosOrNoves = zerosOrNoves;
	}
	public String getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(String tipoRegistro) {
		
		if((zerosOrNoves.contains("0") && !tipoRegistro.equals("00")) || (zerosOrNoves.contains("9") && !tipoRegistro.equals("99")))
			setRelatorioErros("Tipo de registro diferente do padrão");
		this.tipoRegistro = tipoRegistro;
	}
	public String getDataDoMovimento() {
		return dataDoMovimento;
		
	}
	public void setDataDoMovimento(String dataDoMovimento) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date data = sdf.parse(dataDoMovimento);
		} catch (ParseException e) {
			
			setRelatorioErros("Data do movimento não é uma data valida");
			
		}
		
		
		this.dataDoMovimento = dataDoMovimento;
	}
	public String getHoraDaGeracao() {
		return horaDaGeracao;
	}
	public void setHoraDaGeracao(String horaDaGeracao) {
		
		horaDaGeracao = "20180101 "+horaDaGeracao;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
		
		
		try {
			Date data = sdf.parse(horaDaGeracao);
		} catch (ParseException e) {
			
			setRelatorioErros("Hora da geração não é uma hora valida");
			
		}finally {
			this.horaDaGeracao = horaDaGeracao;	
		}
		
		
		this.horaDaGeracao = horaDaGeracao;
	}
	public String getNomeDoArquivo() {
		return NomeDoArquivo;
	}
	public void setNomeDoArquivo(String nomeDoArquivo) {
		
		if(!nomeDoArquivo.contains("Habitacional        "))
			setRelatorioErros("Nome do Arquivo diferente do padrão");
		
		NomeDoArquivo = nomeDoArquivo;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		
		this.filler = filler;
	}
	public String getRelatorioErros() {
		return relatorioErros;
	}
	public void setRelatorioErros(String relatorioErros) {
		if(relatorioErros == null) relatorioErros = "";
		
		this.relatorioErros += relatorioErros+"/n";
	}
	
	
	

}
