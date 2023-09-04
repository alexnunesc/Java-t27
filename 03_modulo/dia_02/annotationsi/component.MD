## Anotação `@Component` no Spring

A anotação `@Component` no Spring é usada para marcar uma classe como um componente gerenciado pelo Spring, permitindo a injeção de dependências e o controle de ciclo de vida pelo contêiner Spring. Ao utilizar `@Component`, estamos indicando que essa classe pode ser usada como uma dependência em outras partes do código.

**Funcionamento da Anotação `@Component`**

- **Marcação da Classe:** Ao adicionar `@Component` a uma classe, o Spring a reconhece como um componente gerenciado.

- **Gerenciamento pelo Spring:** O Spring cria e gerencia instâncias dessa classe durante todo o ciclo de vida da aplicação.

- **Injeção de Dependências:** Classes marcadas com `@Component` podem ser injetadas em outras classes usando `@Autowired`.

- **Configuração `@ComponentScan`:** Para localizar classes anotadas com `@Component`, configure `@ComponentScan`. Por padrão, ele busca componentes no pacote configurado e subpacotes.

**Utilização dos Componentes**

- **Injeção de Dependências:** Outras classes podem injetar componentes `@Component` usando `@Autowired`.

- **Controladores:** Em controladores Spring MVC para lidar com solicitações HTTP.

- **Serviços:** Em serviços que executam lógica de negócios.

- **Repositórios:** Em classes que interagem com bancos de dados ou sistemas de armazenamento.

A anotação `@Component` é essencial no Spring, facilitando a construção de aplicativos flexíveis e robustos. Certifique-se de configurar o `@ComponentScan` adequadamente para que o Spring possa localizar e gerenciar seus componentes.
