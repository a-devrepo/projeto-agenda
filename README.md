1. Descrição do Projeto

Este projeto é uma aplicação desenvolvida em Java 21 com gerenciamento de dependências via Maven. O objetivo principal é a gestão de aulas e seus respectivos participantes, oferecendo flexibilidade na exportação dos dados.
2. Estrutura de Domínio

O projeto baseia-se em duas entidades principais:

    Aula: Entidade mestre que centraliza as informações do evento.

    Participante: Entidade que representa os indivíduos vinculados a uma aula.

    Relacionamento: Uma instância de Aula contém uma lista de N Participantes (Relacionamento 1:N).

3. Arquitetura do Sistema

A organização do código segue o padrão de camadas para facilitar a manutenção:

    Controllers: Gerenciam as requisições e o fluxo da aplicação.

    Entities: Classes que representam o modelo de dados.

    Enums: Definições de tipos constantes para padronização.

    Interfaces: Contrato CompromissoRepository que define os métodos de persistência/exportação.

    Repositories: Implementações concretas da interface.

4. Exportação e Polimorfismo

O sistema utiliza o padrão de estratégia para exportar os dados do projeto. Existem duas implementações disponíveis para a interface de repositório:

    Formato XML: Exporta os dados estruturados para leitura em sistemas legados ou integrações.

    Formato TXT: Exporta os dados em texto simples para leitura rápida.

5. Interface de Usuário

A escolha do formato de exportação é realizada através de uma interface gráfica minimalista utilizando Java Swing. Ao acionar a exportação, o usuário é apresentado a um seletor simples para definir entre as extensões .xml ou .txt.