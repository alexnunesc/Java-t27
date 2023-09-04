// AutoWired

@Component
public class Office {
  private Registration registration;

  @Autowired
  public Office(Registration registration) {
    this.registration = registration;
  }
}

//Segundo, a classe tem um atributo do tipo Registration e um construtor que
//recebe um parâmetro desse tipo. Ao anotarmos o construtor com @Autowired,
//estamos indicando que é por ali que a injeção de dependência deve ocorrer.