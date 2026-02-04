# Roteiro de testes via terminal — SisAcad

## Como executar

1. Compilar: `mvn -q -DskipTests package`
2. Executar: `java -cp target/classes org.example.AppSisAcad`

> Observação: os testes abaixo são **manuais** e cobrem interações e bloqueios do menu.

---

## Dados sugeridos (base)

Use estes dados para facilitar a execução dos casos:

- Alunos:
  - Ana Silva — matrícula 1001
  - Bruno Lima — matrícula 1002
- Professores:
  - Prof. Carlos — matrícula 2001
  - Profa. Denise — matrícula 2002
- Disciplinas:
  - POO — código 3001 — carga 60 — modalidade Presencial — estratégia Média Simples
  - Redes — código 3002 — carga 60 — modalidade Online — estratégia Média Ponderada
- Estágios:
  - Estágio I — descrição "Infra"
  - Estágio II — descrição "Dev"

---

## Casos principais (fluxos)

**TC-01 — Cadastrar aluno (OK)**
- Menu: 1
- Entradas: Nome + Matrícula (1001)
- Resultado esperado: “Aluno cadastrado com sucesso!”

**TC-02 — Cadastrar professor (OK)**
- Menu: 3
- Entradas: Nome + Matrícula (2001)
- Resultado esperado: “Professor cadastrado com sucesso!”

**TC-03 — Cadastrar disciplina (OK)**
- Pré: professor cadastrado
- Menu: 5
- Entradas: nome, código, carga, modalidade, estratégia
- Resultado esperado: “Disciplina cadastrada com sucesso!”

**TC-04 — Cadastrar estágio (OK)**
- Menu: 8
- Entradas: nome + descrição
- Resultado esperado: “Estágio cadastrado com sucesso!”

**TC-05 — Listar alunos**
- Menu: 2
- Resultado esperado: lista com alunos cadastrados

**TC-06 — Listar professores**
- Menu: 4
- Resultado esperado: lista com professores cadastrados

**TC-07 — Listar disciplinas**
- Menu: 6
- Resultado esperado: lista com disciplinas cadastradas

**TC-08 — Listar estágios**
- Menu: 9
- Resultado esperado: lista com estágios cadastrados

**TC-09 — Vincular professor à disciplina (OK)**
- Menu: 7
- Entradas: código da disciplina + matrícula do professor
- Resultado esperado: “Professor vinculado à disciplina com sucesso!”

**TC-10 — Matricular aluno em disciplina (OK)**
- Menu: 10
- Entradas: matrícula do aluno + disciplina
- Resultado esperado: “Aluno matriculado com sucesso!”

**TC-11 — Adicionar notas (OK)**
- Menu: 11
- Entradas: matrícula do aluno + disciplina + 2 notas válidas
- Resultado esperado: notas registradas + média + status

**TC-12 — Visualizar desempenho do aluno (OK)**
- Menu: 12
- Entradas: matrícula do aluno
- Resultado esperado: disciplinas, notas, médias e status

**TC-13 — Matricular aluno em estágio (OK)**
- Menu: 13
- Entradas: matrícula do aluno + estágio
- Resultado esperado: “Aluno matriculado no estágio com sucesso!”

**TC-14 — Registrar avaliação de estágio (OK)**
- Menu: 14
- Entradas: matrícula + estágio + média (0–100)
- Resultado esperado: média registrada + status

**TC-15 — Listar componentes acadêmicos**
- Menu: 15
- Resultado esperado: disciplinas e estágios listados

**TC-16 — Visualizar situação acadêmica do aluno**
- Menu: 16
- Entradas: matrícula
- Resultado esperado: situação detalhada

---

## Casos de bloqueio e validações

**TB-01 — Opção inválida**
- Menu: 99
- Resultado esperado: “Opção inválida.”

**TB-02 — Listar alunos sem cadastro**
- Menu: 2
- Resultado esperado: “Nenhum aluno cadastrado.”

**TB-03 — Cadastrar aluno com matrícula duplicada**
- Menu: 1
- Entradas: mesma matrícula já usada
- Resultado esperado: “Matrícula já existe.”

**TB-04 — Listar professores sem cadastro**
- Menu: 4
- Resultado esperado: “Nenhum professor cadastrado.”

**TB-05 — Cadastrar professor duplicado**
- Menu: 3
- Entradas: mesma matrícula
- Resultado esperado: “Professor com este ID já existe.”

**TB-06 — Cadastrar disciplina sem professores**
- Menu: 5
- Resultado esperado: “Não há professores cadastrados. Cadastre um professor primeiro.”

**TB-07 — Cadastrar disciplina com nome duplicado**
- Menu: 5
- Entradas: nome já usado
- Resultado esperado: “Disciplina com este nome já existe.”

**TB-08 — Vincular professor sem disciplinas**
- Menu: 7
- Resultado esperado: “Nenhuma disciplina cadastrada.”

**TB-09 — Vincular professor sem professores**
- Menu: 7
- Resultado esperado: “Nenhum professor cadastrado.”

**TB-10 — Vincular professor com código inválido**
- Menu: 7
- Entradas: código inexistente
- Resultado esperado: “Disciplina não encontrada.”

**TB-11 — Vincular professor com matrícula inválida**
- Menu: 7
- Entradas: matrícula inexistente
- Resultado esperado: “Professor não encontrado.”

**TB-12 — Matricular aluno em disciplina sem alunos**
- Menu: 10
- Resultado esperado: “Nenhum aluno cadastrado.”

**TB-13 — Matricular aluno em disciplina sem disciplinas**
- Menu: 10
- Resultado esperado: “Nenhuma disciplina cadastrada.”

**TB-14 — Matricular aluno inexistente**
- Menu: 10
- Entradas: matrícula inexistente
- Resultado esperado: “Aluno não encontrado.”

**TB-15 — Matricular aluno com opção de disciplina inválida**
- Menu: 10
- Entradas: opção fora do intervalo
- Resultado esperado: “Opção de disciplina inválida.”

**TB-16 — Matricular aluno já matriculado**
- Menu: 10
- Entradas: aluno já matriculado na mesma disciplina
- Resultado esperado: “Aluno já matriculado nesta disciplina.”

**TB-17 — Adicionar notas sem alunos**
- Menu: 11
- Resultado esperado: “Nenhum aluno cadastrado.”

**TB-18 — Adicionar notas para aluno inexistente**
- Menu: 11
- Resultado esperado: “Aluno não encontrado.”

**TB-19 — Adicionar notas sem disciplinas**
- Menu: 11
- Resultado esperado: “Este aluno não possui disciplinas matriculadas.”

**TB-20 — Nota fora do intervalo**
- Menu: 11
- Entrada: nota <0 ou >100
- Resultado esperado: “Nota deve estar entre 0 e 100.”

**TB-21 — Menos de 2 notas**
- Menu: 11
- Entradas: apenas 1 nota e encerrar
- Resultado esperado: “Mínimo de 2 notas não atingido…”

**TB-22 — Matricular aluno em estágio sem alunos**
- Menu: 13
- Resultado esperado: “Nenhum aluno cadastrado.”

**TB-23 — Matricular aluno em estágio sem estágios**
- Menu: 13
- Resultado esperado: “Nenhum estágio cadastrado.”

**TB-24 — Matricular aluno em estágio com opção inválida**
- Menu: 13
- Resultado esperado: “Opção inválida.”

**TB-25 — Matricular aluno em estágio duplicado**
- Menu: 13
- Resultado esperado: “Aluno já matriculado neste estágio.”

**TB-26 — Avaliar estágio sem alunos**
- Menu: 14
- Resultado esperado: “Nenhum aluno cadastrado.”

**TB-27 — Avaliar estágio sem matrícula**
- Menu: 14
- Entradas: aluno sem estágio
- Resultado esperado: “Aluno não está matriculado em estágio.”

**TB-28 — Avaliar estágio com opção inválida**
- Menu: 14
- Resultado esperado: “Opção inválida.”

**TB-29 — Avaliar estágio com média fora de 0–100**
- Menu: 14
- Entrada: média inválida
- Resultado esperado: “Erro ao registrar avaliação.”

**TB-30 — Visualizar desempenho sem alunos**
- Menu: 12
- Resultado esperado: “Nenhum aluno cadastrado.”

**TB-31 — Visualizar situação acadêmica sem alunos**
- Menu: 16
- Resultado esperado: “Nenhum aluno cadastrado.”

---

## Observações

- Estratégias de avaliação impactam o número mínimo de notas e o valor de aprovação.
- Para Média Ponderada: mínimo de 3 notas.
- Para Média Rigorosa: mínimo de 4 notas.
- Para Maior Nota: mínimo de 2 notas.
