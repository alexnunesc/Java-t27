# TDD com JUnit 5

**Basicamente, TDD é dividido em três partes:**

1. Escrevemos o teste para uma determinada funcionalidade, que falhará, pois não a temos implementada ainda;
2. Implementamos a funcionalidade para que o teste passe com sucesso;
3. Com a funcionalidade implementada e o teste passando, refatoramos o código para torná-lo o mais legível e simples possível.


# Exemplos

### código

```java
public class ContaPoupanca {
  private int saldo = 0;
  public int depositar(int valor) {
    this.saldo += valor;
    return valor;
  }

  public int sacar(int valor) {
    this.saldo -= valor;
    return this.saldo;
  }

  public int getVerSaldo() {
    return this.saldo;
  }
}

```

### Test

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaPoupancaTest {

  @Test
  @DisplayName("Teste método depositar")
  void testDepositar() {
    ContaPoupanca contaPoupanca = new ContaPoupanca();
    assertEquals(3000, contaPoupanca.depositar(3000));
  }

  @Test
  @DisplayName("Teste método sacar")
  void testSacar() {
    ContaPoupanca contaPoupanca = new ContaPoupanca();
    contaPoupanca.depositar(3000);
    assertEquals(1000, contaPoupanca.sacar(2000));
  }

  @Test
  @DisplayName("Teste método verSaldo")

  void testVerSaldo() {
    ContaPoupanca contaPoupanca = new ContaPoupanca();
    contaPoupanca.depositar(3000);

    assertEquals(3000, contaPoupanca.getVerSaldo());
  }

}
```









