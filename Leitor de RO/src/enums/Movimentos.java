package enums;

public enum Movimentos {
	
	
	Ajuste_reserva_a_maior(1),
	Ajuste_reserva_a_menor(2),
	Solicita��o_Pagamento_Total(3),
	Cancelamento_do_Aviso(4),
	Reativa��o_do_Aviso(5),
	Baixa_sem_indeniza��o(7),
	Cobertura_Negada(8),
	Solicita��o_Pagamento_Parcial(9);

	public int valor;
	
	Movimentos(int valor ){
		this.valor = valor;
		
	}
	

}
