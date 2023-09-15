**Para não esquecer mais**

No conteúdo de hoje, vimos:

- Como o Java sinaliza erros e exceções, com classes como `Throwable`, `Error` e `Exception`, além das classes derivadas dessas;
- Como utilizar a palavra-chave `try` para tentar a execução de um código, `catch` para tratar erros e `finally` para liberação de recursos e outras tarefas finais;
- Como criar suas próprias exceções customizadas, de dois tipos:
    - Checked, que forçam o seu tratamento direto ou indireto;
    - Unchecked, que deriva da classe `RuntimeException` e acontece em tempo de execução;
- Como lidar com erros e exceções no Spring através de:
    - `@ResponseStatus`, usado na exceção para indicar o código de status HTTP;
    - `@ExceptionHandler`, usado para definir métodos que tratam exceções específicas em nosso controller;
    - `@ControllerAdvice`, usado para definir uma configuração centralizada de tratamento de erros de controllers;
- Como usar a anotação `@CircuitBreaker` para:
    - Tratar falhas através do controle de estado CLOSED/OPEN/HALF_OPEN;
    - Definir métodos fallback que retornam valores padrão em caso de erro.
