// Exemplos de importação de classes

import java.util.Scanner; // Importa a classe Scanner que server para ler dados do teclado.
import java.util.*; // Importa todas as classes do pacote java.util.
import java.util.Date; // Importa a classe Date do pacote java.util.
import java.net.*; // Importa todas as classes do pacote java.net.


// Exemplo de importação de métodos estáticos
import static java.lang.Math.*; // Importa todos os métodos estáticos da classe Math.


// Exemplo de importação de métodos estáticos específicos
import static java.lang.Math.PI; // Importa o método estático PI da classe Math.
import static java.lang.Math.pow; // Importa o método estático pow da classe Math.
import static java.lang.Math.sqrt; // Importa o método estático sqrt da classe Math.



public class RaizQuadradaDeVinteECinco {

  public static void main(String[] args) {
    double resultado = Math.sqrt(25);
    System.out.println(resultado);
  }

}


// Exemplo usando Scanner para ler dados do teclado
class UsandoScanner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Qual o seu nome: ");
    String nome = scanner.next();
    System.out.println("Boas-vindas, " + nome + "!");
    scanner.close();
  }

}