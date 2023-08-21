// Classe principal que contém o método main para iniciar o programa
public class Main {
  public static void main(String[] args) {
    // Chama o método inicializar da classe InicializadorLivros
    InicializadorLivros.inicializar();
  }
}

// Classe responsável por inicializar o processo de manipulação de livros
public class InicializadorLivros {
  public static void inicializar() {
    // Cria uma instância da classe LivroService com o título "Aventuras Fantásticas"
    LivroService livroService = new LivroService("Aventuras Fantásticas");

    // Obtém o título do livro usando o método getTitulo() e o exibe
    String tituloDoLivro = livroService.getTitulo();
    System.out.println("Título do livro: " + tituloDoLivro);

    // Define um novo título usando o método setTitulo() e o exibe
    livroService.setTitulo("Novo Título");
    System.out.println("Novo título do livro: " + livroService.getTitulo());
  }
}

// Classe que representa um serviço de livros com operações de leitura e escrita do título
public class LivroService {
  private String titulo; // Atributo privado para armazenar o título do livro

  // Construtor que recebe um título ao criar um objeto LivroService
  public LivroService(String titulo) {
    this.titulo = titulo;
  }

  // Método para obter o título do livro
  public String getTitulo() {
    return titulo;
  }

  // Método para definir o título do livro
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}
