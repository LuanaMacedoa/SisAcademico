# Sistema Acadêmico

## Informações acadêmicas

- Instituição: Instituto Federal da Paraíba (IFPB)
- Curso: CST em Sistemas para Internet
- Disciplina: Programação Orientada a Objetos (POO)
- Professor: Frederico Costa Guedes Pereira

## Autores

- Luana Gabriella Pereira Macedo (20242370026)
- Vinícius Ares Monteiro de Lima (20242370007)

## Contexto

Projeto avaliativo da disciplina de POO, com foco na prática de conceitos de orientação a objetos. O sistema simula o acompanhamento de alunos em uma instituição de ensino, com dois tipos de componentes formativos: disciplinas regulares (presenciais e online) e estágios, cada um com regras próprias de avaliação.

## Funcionalidades

- Cadastros básicos: alunos (UC01), professores (UC02), disciplinas (UC03) e estágios (UC04)
- Matrículas: vínculo de alunos em disciplinas (UC05) e em estágios (UC06)
- Avaliação: registro de notas em disciplinas (UC07) e médias em estágio (UC08)
- Resultados: cálculo de médias e situação final (UC09), consulta individual (UC10) e listagem geral (UC13)
- Consultas: listagem de componentes acadêmicos (UC11) e detalhamento de avaliações (UC12)

## Requisitos adicionais

- Arquitetura em camadas (MVC)
- Padronização Java (nomenclaturas e identação)
- Versionamento com Git
- Extensibilidade para novos componentes formativos

## Tecnologias

- Linguagem: Java
- Build: Maven
- Paradigma: Programação Orientada a Objetos

## Como executar

1. Compilar: `mvn -q -DskipTests package`
2. Executar: `java -cp target/classes org.example.AppSisAcad`

## Estrutura do projeto

- `src/main/java/org/example/controller`: controladores
- `src/main/java/org/example/model`: modelos e estratégias de avaliação
- `src/main/java/org/example/view`: views de console
- `src/main/java/org/example/exception`: exceções de domínio
- `src/main/java/org/example/ui`: utilitários de console
