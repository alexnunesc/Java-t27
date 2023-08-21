/* Tipo String - split */

public class Split {
  public static void main(String[] args) {
    String casasTexto = "Grifinória;Sonseria;Corvinal;Lufa-Lufa";
    String casas[] = casasTexto.split(";");

    for (String casa : casas) {
      System.out.println(casa);
    }
  // Exemplo 2.
    String frase = "caneta,lápis,lapiseira,caderno,borracha";
    String formatado[] = frase.split(",", 3);

    for (String novo_formato : formatado) {
      System.out.println(novo_formato); // imprime ["caneta", "lápis", "lapiseira,caderno,borracha"]
    }
  }
}

/*
  Mas também é possível adicionar um limite negativo e um limite de zero:
  No limite negativo, o padrão será aplicado quantas vezes for preciso, e o array pode ter qualquer tamanho.
  No limite de zero, o padrão será aplicado quantas vezes for preciso, e o array também pode ter qualquer tamanho, mas, além disso, ele também retira valores vazios no final do array.
*/