package models;

public enum ValorNota {
	DEZ(10), VINTE(20), CINQUENTA(50), CEM(100);
	
	private int valorNota;
	
	ValorNota(int valor) {
		valorNota = valor;
	}
	
	public int getValor() {
		return valorNota;
	}
}
