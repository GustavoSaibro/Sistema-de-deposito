# Sistema-de-deposito

Projeto de um sistema de saques e depositos de notas monetarias brasileiras. Pode-se depositar e sacar 4 notas: As de cem, cinquenta, vente e de dez reais. Projeto feito utilizando a linguagem de programação java. 

## Istalação

Para utilizar o projeto deve-se ter instalado a versão 1.8 do java. 

## Uso

Você pode utilizar a classe de testes criada pra efetuar testes unitarios dos codigos criados. Ou então utilizar diretamente o modulo, bastando importa-lo ao seu codigo. 

Por ser um sistema simples, resolvi deixar tanto o saque quanto os depositos na mesma classe, porém caso fosse mais complexo o ideal seria separar uma classe para deposito e outra para saque. 

Aqui exemplificarei utilizando os metodos  da classe CedulaController, que faz tanto os saques, quanto os depositos.

```java

  CedulaController cedulaController = new CedulaController();
  
  cedulaController.deposito(ValorNota.Cem, 10);
  
  cedulaController.saque(500);

```
Neste exemplo, instanciei um controlador da cedula e fiz um deposito de 10 notas de cem reais. E apoós ter feito este deposito, fiz um saque de 500 reais. Para fazer um deposito é necessário informar o valor da nota a ser depositado e a quantidade de notas que serão depositadas. Para fazer um saque, basta informar a quantia a ser sacada. Os valores das notas são passados por meio de um Enum criado. Existem 4: CEM, CINQUENTA, VINTE, DEZ. Basta passar ValorNota.{valor}.
