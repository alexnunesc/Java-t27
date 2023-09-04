public class Veiculo {
  public void abastecer() {
    System.out.println("Método abastecer da classe Veiculo.");
  }

  public void acelerar() {
    System.out.println("Método acelerar da classe Veiculo.");
  }
}


public class Carro extends Veiculo {

  private String modelo;

  public void acelerar() {
    System.out.println("Método acelerar da classe Carro.");
  }
}

public class Moto extends Veiculo {

  private String modelo;

  public void acelerar() {
    System.out.println("Método acelerar da classe Moto.");
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

//  Método abastecer da classe Veiculo.
//  Método acelerar da classe Carro.
//  Método abastecer da classe Veiculo.
//  Método acelerar da classe Moto.
