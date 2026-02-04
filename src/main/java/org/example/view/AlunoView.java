package org.example.view;

import org.example.model.AlunoModel;
import org.example.model.DisciplinaModel;
import org.example.model.EstagioModel;
import org.example.ui.Cores;
import org.example.exception.NotasInsuficientesException;

import java.util.List;

public class AlunoView implements Cores {
    private MenuView menuView;

    public AlunoView() {
    }

    public AlunoView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void exibirListaAlunos(List<AlunoModel> alunos) {
        System.out.println(VERDE + "\n╔════════════════════════════════════════╗" + RESET);
        System.out.println(VERDE + "║         LISTA DE ALUNOS                ║" + RESET);
        System.out.println(VERDE + "╚════════════════════════════════════════╝" + RESET);
        if (alunos.isEmpty()) {
            System.out.println(VERMELHO + "⚠ Nenhum aluno cadastrado." + RESET);
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println(VERDE + "  " + (i + 1) + "." + RESET + " " + alunos.get(i));
            }
        }
        System.out.println();
    }

    public AlunoModel obterDadosCadastro() {
        String nome = menuView.obterEntrada("Nome do aluno: ");
        long matricula = menuView.obterLong("Matrícula: ");
        return new AlunoModel(nome, matricula);
    }

    public AlunoModel obterDadosMatricula(List<AlunoModel> alunos) {
        exibirListaAlunos(alunos);
        long matricula = menuView.obterLong("Informe a matrícula do aluno: ");
        return new AlunoModel(null, matricula);
    }

    public void exibirDesempenhoAluno(AlunoModel aluno) {
        System.out.println(AZUL + "\n╔════════════════════════════════════════╗" + RESET);
        System.out.println(AZUL + "║       DESEMPENHO DO ALUNO              ║" + RESET);
        System.out.println(AZUL + "╚════════════════════════════════════════╝" + RESET);
        System.out.println(CIANO + "Nome: " + RESET + aluno.getNome());
        System.out.println(CIANO + "Matrícula: " + RESET + aluno.getMatricula());
        System.out.println(VERDE + "\n📚 Disciplinas" + RESET);

        if (aluno.getDisciplinas().isEmpty()) {
            System.out.println("Nenhuma disciplina matriculada.");
        } else {
            for (int i = 0; i < aluno.getDisciplinas().size(); i++) {
                var disc = aluno.getDisciplinas().get(i);
                System.out.println((i + 1) + ". " + disc.getNome());
                List<Double> notas = aluno.obterNotasDisciplina(disc.getCodigo());
                System.out.println("   Notas: " + notas);
                if (aluno.podeCalcularMediaDisciplina(disc.getCodigo())) {
                    double media = aluno.calcularMediaDisciplina(disc.getCodigo());
                    System.out.println("   Média: " + String.format("%.2f", media));
                    System.out.println("   Status: " + (aluno.aprovadoEmDisciplina(disc.getCodigo()) ? "APROVADO" : "REPROVADO"));
                } else {
                    System.out.println("   Média: Não calculada (mínimo 2 notas)");
                }
            }
        }
        System.out.println("\n\n");
    }

    public void adicionarNotasDisciplina(AlunoModel aluno, DisciplinaModel disciplina) throws NotasInsuficientesException {
        System.out.println(CIANO + "\nAdicionando notas para " + aluno.getNome() + " em " + disciplina.getNome() + RESET);
        int totalNotas = aluno.obterNotasDisciplina(disciplina.getCodigo()).size();
        boolean continuar = true;

        while (continuar) {
            double nota = menuView.obterDouble("Digite a nota (0-100): ");
            
            if (aluno.adicionarNotaDisciplina(disciplina.getCodigo(), nota)) {
                totalNotas++;
                menuView.exibirSucesso("Nota " + String.format("%.2f", nota) + " adicionada com sucesso! Total: " + totalNotas);
                
                String resposta = menuView.obterEntrada("Deseja adicionar outra nota? (s/n): ");
                continuar = resposta.equalsIgnoreCase("s");
            } else {
                menuView.exibirErro("Nota deve estar entre 0 e 100. Tente novamente.");
            }
        }

        verificarNotasParaCalcularMedia(aluno, disciplina, totalNotas);
    }

    public void verificarNotasParaCalcularMedia(AlunoModel aluno, DisciplinaModel disciplina, int totalNotas) throws NotasInsuficientesException {
        if (totalNotas < 2) {
            throw new NotasInsuficientesException("Mínimo de 2 notas não atingido. Não é possível calcular a média.");
        }

        double media = aluno.calcularMediaDisciplina(disciplina.getCodigo());
        menuView.exibirAviso("Média calculada: " + String.format("%.2f", media));
        if (aluno.aprovadoEmDisciplina(disciplina.getCodigo())) {
            menuView.exibirSucesso("Status: APROVADO");
        } else {
            menuView.exibirErro("Status: REPROVADO");
        }
    }

    public void exibirSituacaoAcademica(AlunoModel aluno) {
        System.out.println("\n===== SITUAÇÃO ACADÊMICA DO ALUNO =====");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());

        System.out.println("\nDisciplinas:");
        if (aluno.getDisciplinas().isEmpty()) {
            System.out.println("Nenhuma disciplina matriculada.");
        } else {
            for (DisciplinaModel disc : aluno.getDisciplinas()) {
                System.out.println("- " + disc.getNome());
                List<Double> notas = aluno.obterNotasDisciplina(disc.getCodigo());
                System.out.println("  Notas: " + notas);

                if (aluno.podeCalcularMediaDisciplina(disc.getCodigo())) {
                    double media = aluno.calcularMediaDisciplina(disc.getCodigo());
                    System.out.println("  Média: " + String.format("%.2f", media));
                    System.out.println("  Status: " +
                            (aluno.aprovadoEmDisciplina(disc.getCodigo()) ? "APROVADO" : "REPROVADO"));
                } else {
                    System.out.println("  Média: Não calculada");
                }
            }
        }


        System.out.println("\nEstágios:");
        if (aluno.getEstagios() == null || aluno.getEstagios().isEmpty()) {
            System.out.println("Nenhum estágio matriculado.");
        } else {
            for (EstagioModel estagio : aluno.getEstagios()) {
                System.out.println("- Nome: " + estagio.getNome());

                if (estagio.getMedia() == null) {
                    System.out.println("  Média: Não informada");
                } else {
                    System.out.println("  Médias registradas: " + estagio.getMedia());
                }
            }
        }
    }
}
