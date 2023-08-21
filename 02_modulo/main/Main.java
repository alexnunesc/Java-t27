// Exemplo execução de uma classe com método main

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // InicializadorLivros.inicializar();
    PortaSegura porta = new PortaSegura("123");

    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite 1 para abrir OU 2 para fechar a porta: ");

    int opcao = scanner.nextInt();

    if (opcao == 1) {
      System.out.println("Digite a chave para trancar a porta: ");
      String chave = scanner.next();
      porta.trancar(chave);
    } else if (opcao == 2) {
      System.out.println("Digite a chave para destrancar a porta: ");
      String chave = scanner.next();
      porta.destrancar(chave);
    } else {
      System.out.println("Opção inválida");
    }
  }
}
