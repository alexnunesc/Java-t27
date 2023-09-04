## Persistência: Camada de Manipulação e Armazenamento de Dados

A camada de Persistência lida com a manipulação e armazenamento de dados na aplicação. Ela incorpora o padrão Repository para simplificar tarefas relacionadas aos dados.

### Responsabilidades da Camada de Persistência:

- Armazenar e recuperar dados da fonte de dados (geralmente um banco de dados).
- Manipular operações de inclusão, remoção, atualização e busca de dados.
- Abstrair detalhes de implementação para outras partes do código.

### Padrão Repository:

- O Repository oferece uma interface simplificada para interações com dados.
- Fornece métodos para operações comuns (inclusão, busca, remoção) sem expor detalhes de implementação.
- Permite que outras partes do código interajam com os dados de maneira direta e intuitiva.

### Spring Data:

- O Spring Data é um módulo do Spring Framework para lidar com persistência de dados.
- Oferece abstrações e ferramentas para facilitar o acesso a bancos de dados.
- Simplifica a criação de Repositories e a execução de consultas.

### Arquitetura em Camadas:

- A camada de Persistência não deve ser acessada diretamente pela camada de Controller.
- A camada de Service deve intermediar entre a camada de Controller e a camada de Persistência.
- O Service realiza a lógica de negócios e utiliza os métodos do Repository para acessar os dados.

A camada de Persistência é essencial para a construção de aplicações robustas e escaláveis, garantindo a separação de responsabilidades e facilitando a manutenção do código. O padrão Repository e o uso de ferramentas como o Spring Data contribuem para um design mais organizado e eficiente na manipulação dos dados da aplicação.


## Serviço: Regras de Negócio e Interação

A Camada de Serviço tem duas funções principais: aplicar/validar regras de negócio e fornecer serviços para outras camadas.

1. **Aplicação de Regras:** Isola as regras de negócio, simplificando o resto do código.
2. **Fornecimento de Serviços:** Serve a camadas posteriores e interage com a camada de Persistência.

A Camada de Controle não lida diretamente com a camada de dados. O fluxo de uma requisição passa por:

- **Camada de Controle:** Recebe e direciona a requisição.
- **Camada de Serviço:** Aplica regras e interage com a Persistência.
- **Camada de Persistência:** Manipula dados.
- **Camada de Serviço:** Retorna resultados.
- **Camada de Controle:** Pode fazer mais ações e responde ao usuário.
