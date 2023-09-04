//A anotação @Bean
//Vimos como podemos usar a anotação @Component para indicar para o Spring que
// uma classe deve ser instanciada e seu bean injetado nos locais necessários.
// Mas há uma outra forma de realizar a criação de beans, que é através da
// anotação @Bean.

public class ProgrammingLanguage {
  private String name;

  public ProgrammingLanguage(String name) {
    this.name = name;
  }
}

// Jeito errado nesse caso.
@Component
public class MySystem {
  private ProgrammingLanguage frontendLanguage;
  private ProgrammingLanguage backendLanguage;

  @Autowired
  public MySystem(ProgrammingLanguage frontendLanguage, ProgrammingLanguage backendLanguage) {
    this.frontendLanguage = frontendLanguage;
    this.backendLanguage = backendLanguage;
  }

}

//O fato de termos a mesma instância vem, em parte, da configuração padrão do
//Spring de ter apenas uma instância por bean. No entanto, mesmo se alterássemos
//essa configuração para termos múltiplas instâncias, ainda teríamos o
//problema de elas serem criadas de uma mesma forma, com os mesmos valores.

// Em casos como esse, a anotação @Bean nos dá mais flexibilidade. Em geral ela é
//utilizada em classes marcadas anotadas com @Configuration (ou por outra
//anotação que englobe essa, como a @SpringBootApplication). Assim, poderíamos
//incluir essa definição na própria classe de aplicação, ou poderíamos ter
//outra classe de configuração, como por exemplo:

// Jeito certo
@Configuration
public class LanguageConfiguration {
  @Bean
  public ProgrammingLanguage frontendLanguage() {
    return new ProgrammingLanguage("JavaScript");
  }

  @Bean
  public ProgrammingLanguage backendLanguage() {
    return new ProgrammingLanguage("Java");
  }
}