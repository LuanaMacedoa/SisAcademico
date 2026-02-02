package org.example.controller;

import java.util.List;

import org.example.view.AlunoView;
import org.example.view.DisciplinaView;
import org.example.view.EstagioView;
import org.example.view.MenuView;
import org.example.view.ProfessorView;
import org.example.model.AlunoModel;
import org.example.model.DisciplinaModel;

public class MenuController {
    private MenuView menuView;
    private AlunoController alunoCtrl;
    private AlunoView alunoView;
    private ProfessorController profCtrl;
    private ProfessorView profView;
    private DisciplinaController discipCtrl;
    private DisciplinaView discipView;
    private EstagioController estagCtrl;
    private EstagioView estagView;

    public MenuController(MenuView menuView, AlunoController alunoCtrl, AlunoView alunoView,
                         ProfessorController profCtrl, ProfessorView profView,
                         DisciplinaController discipCtrl, DisciplinaView discipView,
                         EstagioController estagCtrl, EstagioView estagView) {
        this.menuView = menuView;
        this.alunoCtrl = alunoCtrl;
        this.alunoView = alunoView;
        this.alunoView.setMenuView(menuView);
        this.profCtrl = profCtrl;
        this.profView = profView;
        this.profView.setMenuView(menuView);
        this.discipCtrl = discipCtrl;
        this.discipView = discipView;
        this.discipView.setMenuView(menuView);
        this.estagCtrl = estagCtrl;
        this.estagView = estagView;
        this.estagView.setMenuView(menuView);
    }

    public void executarFluxo(int opcao) {
        switch (opcao) {
            case 1: {
                AlunoModel aluno = alunoView.obterDadosCadastro();
                if (alunoCtrl.cadastrar(aluno)) {
                    menuView.exibirMensagem("Aluno cadastrado com sucesso!");
                } else {
                    menuView.exibirMensagem("Erro: Matrícula já existe.");
                }
                break;
            }

            case 2:
                alunoView.exibirListaAlunos(alunoCtrl.listarAlunos());
                break;

            case 3: {
                var professor = profView.obterDadosCadastro();
                if (profCtrl.cadastrar(professor)) {
                    menuView.exibirMensagem("Professor cadastrado com sucesso!");
                } else {
                    menuView.exibirMensagem("Erro: Professor com este ID já existe.");
                }
                break;
            }

            case 4:
                profView.exibirListaProfessores(profCtrl.listarProfessores());
                break;

            case 5: {
                if (profCtrl.listarProfessores().isEmpty()) {
                    menuView.exibirMensagem("Erro: Não há professores cadastrados. Cadastre um professor primeiro.");
                    break;
                }
                DisciplinaModel disciplina = discipView.obterDadosCadastro();
                if (discipCtrl.cadastrar(disciplina)) {
                    menuView.exibirMensagem("Disciplina cadastrada com sucesso!");
                } else {
                    menuView.exibirMensagem("Erro: Disciplina com este nome já existe.");
                }
                break;
            }

            case 6:
                discipView.exibirListaDisciplinas(discipCtrl.listarDisciplinas());
                break;

            case 7: {
                var estagio = estagView.obterDadosCadastro();
                if (estagCtrl.cadastrar(estagio)) {
                    menuView.exibirMensagem("Estágio cadastrado com sucesso!");
                } else {
                    menuView.exibirMensagem("Erro: Estágio com este Nome já existe");
                }
                break;
            }

            case 8:
                estagView.exibirListaEstagios(estagCtrl.listarEstagios());
                break;
            case 9: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirMensagem("Nenhum aluno cadastrado.");
                    break;
                }

                List<DisciplinaModel> disciplinas = discipCtrl.listarDisciplinas();
                if (disciplinas.isEmpty()) {
                    menuView.exibirMensagem("Nenhuma disciplina cadastrada.");
                    break;
                }

                AlunoModel alunoMatricula = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado = alunoCtrl.buscarAlunoPorMatricula(alunoMatricula.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirMensagem("Aluno não encontrado.");
                    break;
                }

                int opcDisciplina = discipView.obterDisciplinaEscolhida(disciplinas);

                if (opcDisciplina < 1 || opcDisciplina > disciplinas.size()) {
                    menuView.exibirMensagem("Opção de disciplina inválida.");
                    break;
                }

                DisciplinaModel disciplinaSelecionada = disciplinas.get(opcDisciplina - 1);
                if (alunoCtrl.matricularAlunoEmDisciplina(alunoMatricula.getMatricula(), disciplinaSelecionada)) {
                    menuView.exibirMensagem("Aluno matriculado com sucesso!");
                } else {
                    menuView.exibirMensagem("Erro: aluno já matriculado nesta disciplina.");
                }
                break;
            }

            case 0:
                menuView.exibirMensagem("Encerrando sistema...");
                break;

            case 10: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirMensagem("Nenhum aluno cadastrado.");
                    break;
                }

                AlunoModel alunoSelecionado = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado = alunoCtrl.buscarAlunoPorMatricula(alunoSelecionado.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirMensagem("Aluno não encontrado.");
                    break;
                }

                if (alunoBuscado.getDisciplinas().isEmpty()) {
                    menuView.exibirMensagem("Este aluno não possui disciplinas matriculadas.");
                    break;
                }

                System.out.println("\nDisciplinas do aluno:");
                for (int i = 0; i < alunoBuscado.getDisciplinas().size(); i++) {
                    System.out.println((i + 1) + ". " + alunoBuscado.getDisciplinas().get(i).getNome());
                }
                int opcDisc = menuView.obterInt("Escolha a disciplina (número): ");

                if (opcDisc < 1 || opcDisc > alunoBuscado.getDisciplinas().size()) {
                    menuView.exibirMensagem("Opção inválida.");
                    break;
                }

                DisciplinaModel discSelecionada = alunoBuscado.getDisciplinas().get(opcDisc - 1);
                alunoView.adicionarNotasDisciplina(alunoBuscado, discSelecionada);
                break;
            }

            case 11: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirMensagem("Nenhum aluno cadastrado.");
                    break;
                }

                AlunoModel alunoSelecionado = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado = alunoCtrl.buscarAlunoPorMatricula(alunoSelecionado.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirMensagem("Aluno não encontrado.");
                    break;
                }

                alunoView.exibirDesempenhoAluno(alunoBuscado);
                break;
            }
                
            default:
                menuView.exibirMensagem("Opção inválida.");
        }
    }
}
