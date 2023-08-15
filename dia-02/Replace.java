/* Tipo String - replace */

public class Replace {
  public static void main(String[] args) {
    String s = "Java";
    System.out.println(s.replace('a', 'A'));
    System.out.println(s.replace("va", "ven"));
    System.out.println(s.replace('a', 'A').replace("va", "ven"));


    // Eemplo 2
    String nomes = "Maria Magali, Magali da Silva, Magali Medeiros";
    String pessoa = "Laura";

    nomes = nomes.replace("Magali", pessoa);

    System.out.println(nomes); // imprime: Maria Laura, Laura da Silva, Laura Medeiros



  }

}


  String nomes = "Maria Magali, Magali da Silva, Magali Medeiros";
  String pessoa = "Laura";

  nomes = nomes.replaceAll("Magali", pessoa);

  System.out.println(nomes); // imprime: Maria Laura, Laura da Silva, Laur

  /*
    Para não esquecer mais, anote as diferenças entre os métodos replaceAll, replaceFirst e replace:

    No replaceAll, devemos ter uma expressão regular como primeiro parâmetro, podendo assim substituir para nomes.replaceAll("\\S+!", pessoa); e obter o mesmo resultado. Ao fazermos isso, qualquer texto que estiver antes da exclamação será substituído.

    O replaceFirst serve para substituir apenas a primeira ocorrência da expressão regular.

    O método replace serve para substituir caracteres ou textos de uma determinada String por outro caractere ou texto.
  */