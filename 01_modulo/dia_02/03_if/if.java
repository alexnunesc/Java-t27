import java.util.Random;

public class ifteste {
  public static void main(String[] args) {
    mostrarMensagem();
  }

  static String gerarNumeroAleatorio() {
    Random numRandom = new Random();
    int numero = numRandom.nextInt(10); // gera um número aleatório entre 0
    // e 10
    String mensagem = "O número " + numero;
    if (numero > 5) {
      return  mensagem = String.format("%d é maior que 5", numero);
    } else if (numero == 5) {
      return mensagem = String.format("%d é igual a 5", numero);
    } else {
      return mensagem = String.format("%d é menor que 5", numero);
    }
  }

  static void mostrarMensagem() {
    String msg = gerarNumeroAleatorio();
    System.out.println(msg);
  }

}