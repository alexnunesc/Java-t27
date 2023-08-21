public class IndexOf {
  public static void(String[] args) {
    // Exemplo 1.
    String saudacao = "Olá, Mundo!";
    System.out.println(saudacao.indexOf('M')); // imprime: 5


    // Exemplo 2.
    String lorem = "Lorem ipsum dolor sit amet";
    // Vai pegar o primeiro 's' apartir da 10° posição.
    System.out.println(lorem.indexOf('s', 10)); // imprime: 18


    // Exemplo 3.
    String transacao = "123.45MCAD"; // Informação recebida de outro sistema
    int separador = transacao.indexOf('M'); // Retorna 6
    double total = getTotal(transacao, separador - 1); // Retorna 123.45
    String moeda = getMoeda(transacao, separador + 1); // Retornar CAD


    // Exemplo 4.
    String verso = "Um Anel para a todos governar, Um Anel para encontrá-los";
    System.out.println(verso.indexOf("governar")); // Imprime: 21
  }
}