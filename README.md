# Questão 01

Contexto:
Você está desenvolvendo um sistema de processamento de dados para uma empresa financeira que lida com diferentes tipos de análise de risco. O sistema precisa calcular métricas de risco usando diferentes algoritmos (Value at Risk, Expected Shortfall, Stress Testing) que podem mudar dinamicamente durante a execução.

Problema:
- Cada algoritmo de risco deve ser intercambiável em tempo de execução
- Os algoritmos devem ser capazes de compartilhar um contexto complexo com múltiplos parâmetros financeiros
- Deve ser possível trocar de algoritmo de acordo com a necessidade de negócios

Restrições:
- O cliente deve poder mudar de algoritmo sem conhecer os detalhes de implementação
- Implemente pelo menos 3 algoritmos diferentes com cálculos dummy (podem ser mensagens de texto) distintos

## Padrão utilizado: *Strategy*

### Justificativa:

O padrão *Strategy* foi escolhido porque o requisito do sistema exigia que diferentes algoritmos pudessem ser trocados dinamicamente durante a execução, compartilhando o mesmo contexto de dados. Esse padrão permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis sem modificar o código que os utiliza.


# Questão 2

Contexto: 
Sua empresa está integrando com um legado bancário que possui uma interface complexa para processamento de transações. A interface legada SistemaBancarioLegado possui métodos com assinaturas incompatíveis e usa tipos de dados obsoletos.

Problema:
- Converter a interface atualizada ProcessadorTransacoes (com métodos autorizar(String cartao, double valor, String moeda)) para a interface legada
- O sistema legado usa: processarTransacao(HashMap<String, Object> parametros)
- Implemente de forma que o funcionamento seja bidirecional, ou seja, que também permita converter respostas do legado para o formato atualizado
- Adicione tratamento para campos obrigatórios do legado que não existem na interface moderna (ao menos um)

Restrições:
- O legado exige codificação específica para moedas (USD=1, EUR=2, BRL=3)

## Padrão utilizado: *Adapter*

### Justificativa

O padrão *Adapter* foi escolhido porque o problema envolve a integração entre duas interfaces incompatíveis. Ele permite que o sistema moderno se comunique com componentes legados sem a necessidade de alterar o código existente, garantindo compatibilidade entre ambos. Além disso, o uso desse padrão mantém o *Open/Closed Principle* (Princípio aberto/fechado), já que novos adaptadores podem ser criados sem modificar as classes originais, e aplica o Princípio da Inversão de Dependência, fazendo com que o código atual dependa de abstrações em vez de implementações concretas.


# Questão 3

Contexto:
Você está modelando um sistema de controle para uma usina nuclear com estados complexos de operação. A usina pode estar em: DESLIGADA, OPERACAO_NORMAL, ALERTA_AMARELO, ALERTA_VERMELHO, EMERGENCIA.

Problema:
- Cada transição de estado deve validar condições complexas (temperatura, pressão, nível de radiação)
- Algumas transições são bidirecionais, outras são unidirecionais
- Previna transições circulares perigosas
- O estado EMERGENCIA só pode ser ativado após passar por ALERTA_VERMELHO
- Adicione um modo "manutenção" que sobreescreva temporariamente os estados normais

Regras:
- OPERACAO_NORMAL → ALERTA_AMARELO: se temperatura > 300°C
- ALERTA_AMARELO → ALERTA_VERMELHO: se temperatura > 400°C por mais de 30 segundos
- ALERTA_VERMELHO → EMERGENCIA: se sistema de resfriamento falhar

## Padrão utilizado: *State*

### Justificativa

O padrão *State* foi aplicado para representar os diferentes modos de operação da usina nuclear — DESLIGADA, OPERAÇÃO_NORMAL, ALERTA_AMARELO, ALERTA_VERMELHO, EMERGÊNCIA e MANUTENÇÃO. Esse padrão permite que cada estado possua suas próprias regras de transição e validação, eliminando a necessidade de condicionais complexas dentro de uma única classe e tornando o código mais claro e modular.


# Questão 4

Contexto:
Desenvolva um sistema de validação de documentos fiscais eletrônicos (NF-e) que precisa aplicar múltiplas regras de validação em cadeia.

Problema:
- Cada validador especializado verifica um aspecto específico do documento
- A cadeia deve suportar validações condicionais (se validador X falhar, pule Y)
- Implemente um mecanismo de "circuit breaker" que interrompa a cadeia após 3 validações falharem
- Adicione capacidade de rollback para validadores que modificam o documento

Validadores Requeridos:
1. Validador de Schema XML contra XSD
2. Validador de Certificado Digital (expiração e revogação)
3. Validador de Regras Fiscais (cálculo de impostos)
4. Validador de Banco de dados (duplicidade de número)
5. Validador de Serviço SEFAZ (consulta online)

Restrições:
- Os validadores 3 e 5 devem ser executados apenas se os anteriores passarem
- O validador 4 deve fazer rollback da inserção se validações subsequentes falharem
- Implemente timeout individual para cada validador

## Padrão utilizado: *Chain of Responsibility*

### Justificativa

Nesta questão, foi aplicado o padrão *Chain of Responsibility* para estruturar uma cadeia de validadores responsáveis por processar um documento de forma sequencial e controlada. O padrão foi escolhido por permitir que cada validador execute sua responsabilidade específica e, em caso de sucesso, encaminhe o processamento ao próximo da cadeia, tudo isso sem acoplamento direto entre os validadores.