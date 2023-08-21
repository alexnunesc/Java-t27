
class Tipos {

  public static void main(String[]args){
    // Array de tipos primitivos
    int numero = 10;
    double decimal = 10.5;
    char caracter = 'a';
    boolean verdadero = true;
    boolean falso = false;

    // tipos não primitivos
    String texto = "Alex";
    String[] nomes = new String[5];  // Array com capacidade para 5 nomes
    String[] nomes2 = {"Alex", "João", "Maria", "José", "Pedro"}; // Array
    // com 5 nomes

    // Metodo print com concatenação
    System.out.printf("%d %f Faz o L ", numero, decimal);

    System.out.printf("%s %s", "Alex", "kk");

    // quebra de linha
    // \n

    strg(); // chamando o método strg
  }
    public static void strg(String[] args) {
      double a = 2.356; // double inicializado naturalmente
      double b = 1.409F; // double aceitando número float
      double c = 12930L; // double aceitando número long
      System.out.println(doubleRecebendoFloat); // 1.409000039100647
      System.out.println(doubleRecebendoLong); // 12930.0
    }
}
