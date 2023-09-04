## Configuração do Spring Boot

A anotação `@SpringBootApplication` é uma forma rápida de configurar nossa aplicação Spring Boot. A interface `ApplicationContext` é a representação do container IOC (Inversion of Control), que tem como responsabilidade instanciar e gerenciar os beans. Por baixo dos panos, a `@SpringBootApplication` utiliza três anotações:

- `@EnableAutoConfiguration`: configura automaticamente o Spring;
- `@ComponentScan`: prepara a busca de componentes na nossa aplicação;
- `@Configuration`: permite configurações e definição de beans adicionais.

Em específico, a `@ComponentScan` vai buscar por classes marcadas com `@Component`. Essas classes podem ser de uso geral, mas também podem representar e atuar em certas camadas da nossa aplicação, como classes de controle, de serviço e de repositório.

## Anotações Específicas do Spring

O Spring fornece algumas anotações específicas para indicar o papel de uma classe no contexto da aplicação:

- `@Controller`: declara que a classe é um bean gerenciável do tipo controller, onde criamos endpoints que recebem requisições externas.
- `@Service`: declara que a classe é um bean gerenciável do tipo service, que armazena as regras de negócio e lógica da aplicação.
- `@Repository`: declara que a classe é um bean gerenciável do tipo repository, responsável por operações com dados.

O uso dessas anotações é basicamente o mesmo que `@Component`, e sua principal diferença é semântica, indicando ao Spring qual papel cada classe desempenha. É comum utilizar a injeção de dependência para relacionar esses componentes.
