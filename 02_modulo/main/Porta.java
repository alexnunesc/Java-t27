public class Porta {
  private int tamanho;
  private String material;
  protected boolean estaAberta;

  public Porta() {
    this.estaAberta = false;
  }

  public int getTamanho() {
    return tamanho;
  }

  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public void abrir() {
    this.estaAberta = true; // Está definindo que a porta está aberta
  }

  public void fechar() {
    this.estaAberta = false; // Está definindo que a porta está fechada
  }

}
