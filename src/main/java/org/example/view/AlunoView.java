package org.example.view;

import org.example.model.AlunoModel;
import org.example.model.DisciplinaModel;
import java.util.List;

public class AlunoView {
    private MenuView menuView;

    public AlunoView() {}

    public AlunoView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void exibirListaAlunos(List<AlunoModel> alunos) {
        System.out.println("\n");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (int i = 0; i <alunos.size(); i++) {
                System.out.println((i + 1) + ". " + alunos.get(i));
            }
        }
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
        System.out.println("\nDESEMPENHO ALUNO");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("\n--- Disciplinas ---");
        
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
                    System.out.println("   Status: " + (aluno.aprovadoEmDisciplina(disc.getCodigo()) ? "✓ APROVADO" : "✗ REPROVADO"));
                } else {
                    System.out.println("   Média: Não calculada (mínimo 2 notas)");
                }
            }
        }
        System.out.println("\n========================================\n");
    }
    
    public void adicionarNotasDisciplina(AlunoModel aluno, DisciplinaModel disciplina) {
        System.out.println("\nAdicionando notas para aluno " + aluno.getNome() + " em " + disciplina.getNome());
        boolean adicionarMais = true;
        int contador = aluno.obterNotasDisciplina(disciplina.getCodigo()).size();
        
        while (adicionarMais && contador < 10) {
            double nota = menuView.obterDouble("Digite a nota (0-100): ");
            if (aluno.adicionarNotaDisciplina(disciplina.getCodigo(), nota)) {
                contador++;
                menuView.exibirMensagem("Nota adicionada com sucesso! Total de notas: " + contador);
                
                if (contador >= 2) {
                    String continuar = menuView.obterEntrada("Adicionar mais notas? (s/n): ");
                    adicionarMais = continuar.equalsIgnoreCase("s");
                }
            } else {
                menuView.exibirMensagem("Erro: Nota deve estar entre 0 e 100.");
            }
        }
        
        if (contador >= 2) {
            double media = aluno.calcularMediaDisciplina(disciplina.getCodigo());
            menuView.exibirMensagem("Média calculada: " + String.format("%.2f", media));
            menuView.exibirMensagem("Status: " + (aluno.aprovadoEmDisciplina(disciplina.getCodigo()) ? "APROVADO" : "REPROVADO"));
        } else {
            menuView.exibirMensagem("Mínimo de 2 notas não atingido. Média não calculada.");
        }
    }
}