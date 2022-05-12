package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  Banco banco;
  private PessoaCliente cliente;

  @BeforeEach
  public void setUp() {

    banco = new Banco();
    cliente = banco.adicionaPessoaCliente("Renato Marques da Silva", AccountUtils.CONTA_CORRENTE, "587.366.190-19", "123456");

  }

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Assertions.assertEquals(10, banco.gerarNumeroNovaConta().length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
      Assertions.assertEquals(1, banco.quantidadeClientes());
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Assertions.assertEquals(cliente, banco.pessoaClienteLogin("587.366.190-19", "123456"));
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Conta corrente = cliente.getContas().get(0);
    Conta poupanca = cliente.getContas().get(1);

    corrente.adicionarTransacao(1000.00, AccountUtils.TRANSACAO_DEPOSITO);


    banco.transferirFundos(cliente, 0, 1, 100.00);

    System.out.println(corrente.retornarSaldo());
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    fail("Não implementado");

  }

}
