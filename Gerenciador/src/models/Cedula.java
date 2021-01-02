package models;


public class Cedula {
	
	//valor das cedulas: 10, 20, 50, 100
	private int valor;
	//quantidade dessa cedula
	private Integer quantidade;
	
	public Cedula() {}

	public Cedula(int valor, Integer quantidade) {
		super();
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
}
