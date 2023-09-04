public abstract class Veiculo {
  public void abastecer() {
    System.out.println("Método abastecer Veiculo.");
  }

  public abstract void acelerar();
}

public class Carro extends Veiculo {
  private String modelo;

  public void acelerar() {
    System.out.println("Método acelerar com o pé.");
  }
}

public class Moto extends Veiculo {
  private String modelo;

  public void acelerar() {
    System.out.println("Método acelerar com a mão.");
  }
}

public class Main {
  public static void main(String[] args) {
    Carro carro = new Carro();
    carro.abastecer();
    carro.acelerar();

    Moto moto = new Moto();
    moto.abastecer();
    moto.acelerar();
  }
}
