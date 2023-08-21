public class PortaSegura extends Porta {
  private String chave;
  private boolean estaTrancada;
  public PortaSegura( String chave ) {
    super(); // chama o construtor da classe pai
    this.chave = chave;
    this.estaTrancada = true;
  }

  public void trancar(String chave) {
    if (this.estaTrancada) {
      System.out.println("PortaSegura já está trancada");
    } else {
      if (chave.equals(this.chave)) {
        this.estaTrancada = true;
        System.out.println("PortaSegura foi trancada");
      } else {
        System.out.println("Chave incorreta");
      }
    }
  }

  public void destrancar(String chave) {
    if (this.estaTrancada) {
      if (chave.equals(this.chave)) {
        this.estaTrancada = false;
        System.out.println("PortaSegura foi destrancada");
      } else {
        System.out.println("Chave incorreta");
      }
    } else {
      System.out.println("PortaSegura já está destrancada");
    }
  }
}
