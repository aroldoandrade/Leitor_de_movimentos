package enums;

public enum Movimentos {
	
	
	Ajuste_reserva_a_maior(1),
	Ajuste_reserva_a_menor(2),
	Solicitação_Pagamento_Total(3),
	Cancelamento_do_Aviso(4),
	Reativação_do_Aviso(5),
	Baixa_sem_indenização(7),
	Cobertura_Negada(8),
	Solicitação_Pagamento_Parcial(9);

	public int valor;
	
	Movimentos(int valor ){
		this.valor = valor;
		
	}
	

}
