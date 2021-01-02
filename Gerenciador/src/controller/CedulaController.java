package controller;

import models.Cedula;
import models.ValorNota;

public class CedulaController {

	private Integer valorTotal;
	private Cedula dez;
	private Cedula vinte;
	private Cedula cinquenta;
	private Cedula cem;

	public CedulaController() {
		super();
		// valor total disponivel
		this.valorTotal = 0;

		// criando a cedula de 10
		int valorDez = ValorNota.DEZ.getValor();
		this.dez = new Cedula(valorDez, 0);

		// criando a cedula de 20
		int valorVinte = ValorNota.VINTE.getValor();
		this.vinte = new Cedula(valorVinte, 0);

		// criando a cedula de 50
		int valorCinquenta = ValorNota.CINQUENTA.getValor();
		this.cinquenta = new Cedula(valorCinquenta, 0);

		// criando a cedula de 100
		int valorCem = ValorNota.CEM.getValor();
		this.cem = new Cedula(valorCem, 0);
	}

	private void setValorTotal() {
		// atualiza o valor total com base na quantidade de notas existentes em caixa
		this.valorTotal = (this.dez.getValor() * this.dez.getQuantidade()
				+ this.vinte.getValor() * this.vinte.getQuantidade()
				+ this.cinquenta.getValor() * this.cinquenta.getQuantidade()
				+ this.cem.getValor() * this.cem.getQuantidade());

	}

	public Integer getValorTotal() {
		return this.valorTotal;
	}

	private void setQtdNotas(Cedula cedula, Integer quantidade) {
		cedula.setQuantidade(quantidade+ cedula.getQuantidade());
	}

	// Metodo criado para retornar a cedula da nota passada por parametro
	private Cedula verificarCedula(ValorNota valorNota) {
		Cedula cedula = null;
		if (valorNota == ValorNota.DEZ) {
			cedula = dez;
		}

		if (valorNota == ValorNota.VINTE) {
			cedula = vinte;
		}

		if (valorNota == ValorNota.CINQUENTA) {
			cedula = cinquenta;
		}
		if (valorNota == ValorNota.CEM) {
			cedula = cem;
		}
		return cedula;
	}

	public Integer getQtdNotas(ValorNota valorNota) {

		/*
		 * verifica-se qual nota foi passada como parametro e então atribui-se a
		 * quantidade daquela nota à variavel qtdNotas
		 */
		Integer qtdNotas = 0;

		qtdNotas = verificarCedula(valorNota).getQuantidade();

		return qtdNotas;
	}

	public void deposito(ValorNota valorNota, Integer qtdDeNotas) {

		// Verifica o valor das notas depositadas e suas quantidades
		if (qtdDeNotas > 0) {

			Cedula cedula = verificarCedula(valorNota);
			setQtdNotas(cedula, qtdDeNotas);
			System.out.println("Você efetuou um deposito de " + qtdDeNotas + " notas de $" + cedula.getValor());

		} else {
			System.out.println("Informe uma quantidade de notas validas!");
		}
		setValorTotal();
		
	}

	public void saque(Integer valorSaque) {

		// Array criado para guardar a quantidade de cada nota sacada
		Integer[] qtdNotasSacadas = { 0, 0, 0, 0 };
		System.out.println("Valor total disponivel: " +getValorTotal());

		if (valorSaque > 0 && valorSaque > valorTotal) {
			System.out.println(
					"Valor do saque é maior que a quantidade disponivel, porfavor tente novamente. Valor total: "
							+ valorTotal);
		} else {

			// Aqui temos a quantidade de cada notas disponiveis no banco
			Integer notasCem = cem.getQuantidade();
			Integer notasCinquenta = cinquenta.getQuantidade();
			Integer notasVinte = vinte.getQuantidade();
			Integer notasDez = dez.getQuantidade();

			/*
			 * Aqui se faz a checagem das notas contidas no banco e se compara com as notas
			 * necessarias para fazer o saque depois se diminui o valor do total do saque.
			 * Depois atualiza-se a quantidade de notas disponiveis no banco
			 */

			// Aqui temos a quantidade de cada nota necessaria para fazer o saque
			Integer notasCemSaque = valorSaque / 100;			
			if (notasCemSaque <= notasCem) {
				valorSaque = valorSaque - (notasCemSaque * 100);				
				cem.setQuantidade(cem.getQuantidade() - notasCemSaque);			

				qtdNotasSacadas[0] = notasCemSaque;
			}
			Integer notasCinquentaSaque = valorSaque / 50;
			if (notasCinquentaSaque <= notasCinquenta) {
				valorSaque = valorSaque - (notasCinquentaSaque * 50);
				cinquenta.setQuantidade(cinquenta.getQuantidade() - notasCinquentaSaque);

				qtdNotasSacadas[1] = notasCinquentaSaque;
			}
			Integer notasVinteSaque = valorSaque / 20;
			if (notasVinteSaque <= notasVinte) {
				valorSaque = valorSaque - (notasVinteSaque * 20);
				vinte.setQuantidade(vinte.getQuantidade() - notasVinteSaque);

				qtdNotasSacadas[2] = notasVinteSaque;
			}
			Integer notasDezSaque = valorSaque / 10;
			if (notasDezSaque <= notasDez) {
				valorSaque = valorSaque - (notasDezSaque * 10);
				dez.setQuantidade(dez.getQuantidade() - notasDezSaque);

				qtdNotasSacadas[3] = notasDezSaque;
			}

			/*
			 * Aqui se faz a verificação se o saque foi efetuado ou não. Caso se chegue com
			 * 
			 * o valor do saque igual a zero isto quer dizer que o saque foi efetuado com
			 * sucesso, caso o valor seja diferente de zero quer dizer que não foi realizado
			 * com sucesso.Isto quer dizer que não há notas de determinado valor disponivel
			 * para completar o saque
			 */
			if (valorSaque == 0) {
				System.out.println("Saque efetuado com sucesso!!");
				System.out.println("Você sacou: " + qtdNotasSacadas[0] + " notas de cem reais");
				System.out.println("Você sacou: " + qtdNotasSacadas[1] + " notas de cinquenta reais");
				System.out.println("Você sacou: " + qtdNotasSacadas[2] + " notas de vinte reais");
				System.out.println("Você sacou: " + qtdNotasSacadas[3] + " notas de dez reais");
			} else {
				System.out.println("Saque não efetuado! Quantidade de notas disponiveis insuficientes");
			}
		}
		setValorTotal();

	}

}
