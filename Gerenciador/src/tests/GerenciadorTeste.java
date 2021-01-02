package tests;

import org.junit.jupiter.api.Test;

import controller.CedulaController;
import junit.framework.TestCase;
import models.ValorNota;

class GerenciadorTeste extends TestCase {

	CedulaController cedulaController = new CedulaController();

	/*
	 * Metodo para testar um deposito. valor é referente ao valor da nota que se
	 * deseja depositar e valorEserado é a quantidade de notas depositadas que se
	 * espera que ocorra.
	 */
	public void testeDeposito(ValorNota valor, Integer valorEsperado) {

		cedulaController.deposito(valor, valorEsperado);
		Integer quantidade = cedulaController.getQtdNotas(valor);

		assertEquals(valorEsperado, quantidade);
	}

	/*
	 * Meotodo para testar um saque. valorDeposito é o valor da nota
	 * depositada(precisa-se depositar antes de sacar) valorEsperado é a quantidade
	 * de notas que se espere que tenham em caixa após o saque notas é a quantidade
	 * de notas que se deseja depositar
	 */
	public void testeSaque(ValorNota valorDeposito, Integer valorEsperado, Integer notas, Integer saque) {

		cedulaController.deposito(valorDeposito, notas);
		cedulaController.saque(saque);

		Integer quantidade = cedulaController.getQtdNotas(valorDeposito);

		assertEquals(valorEsperado, quantidade);

	}

//	@Test
	public void testeDeposito1() {
		testeDeposito(ValorNota.DEZ, 2);
	}

//	@Test
	public void testeSaque1() {
		testeSaque(ValorNota.VINTE, 0, 2, 40);
	}
	
	@Test
	public void testeSaque2() {
		
//		testeDeposito(ValorNota.DEZ, 50);
//		testeDeposito(ValorNota.VINTE, 30);
//		testeDeposito(ValorNota.CINQUENTA, 25);
//		testeDeposito(ValorNota.CEM, 10);			
		testeSaque(ValorNota.CEM, 5, 5, 1040);
		
	}
}
