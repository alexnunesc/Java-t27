// import o tipe
// import java.util.Scanner;
public class Principal {
  public static void main(String[] args) {
    Result.mostrar();
  }

  public static int somar(String n1, String n2) {
    return Integer.parseInt(n1) + Integer.parseInt(n2);
  }
}

class Result {
  static void mostrar() {
    System.out.print(Principal.somar("11", "22"));
  }
}
