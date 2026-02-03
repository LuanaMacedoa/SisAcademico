package org.example.controller;

import java.util.List;

import org.example.model.EstagioModel;
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

            case 12: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirMensagem("Nenhum aluno cadastrado.");
                    break;
                }

                List<EstagioModel> estagios = estagCtrl.listarEstagios();
                if (estagios.isEmpty()) {
                    menuView.exibirMensagem("Nenhum estágio cadastrado.");
                    break;
                }


                AlunoModel alunoSelecionado = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado = alunoCtrl.buscarAlunoPorMatricula(alunoSelecionado.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirMensagem("Aluno não encontrado.");
                    break;
                }


                estagView.exibirListaEstagios(estagios);
                int opcEstagio = menuView.obterInt("Escolha o estágio (número): ");

                if (opcEstagio < 1 || opcEstagio > estagios.size()) {
                    menuView.exibirMensagem("Opção inválida.");
                    break;
                }

                EstagioModel estagioSelecionado = estagios.get(opcEstagio - 1);

                if (alunoCtrl.matricularAlunoEmEstagio(alunoBuscado.getMatricula(), estagioSelecionado)) {
                    menuView.exibirMensagem("Aluno matriculado no estágio com sucesso!");
                } else {
                    menuView.exibirMensagem("Erro: aluno já matriculado neste estágio.");
                }

                break;
            }

            case 13: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirMensagem("Nenhum aluno cadastrado.");
                    break;
                }

                AlunoModel alunoSel = alunoView.obterDadosMatricula(alunos);
                AlunoModel aluno = alunoCtrl.buscarAlunoPorMatricula(alunoSel.getMatricula());

                if (aluno == null) {
                    menuView.exibirMensagem("Aluno não encontrado.");
                    break;
                }

                if (aluno.getEstagios().isEmpty()) {
                    menuView.exibirMensagem("Aluno não está matriculado em estágio.");
                    break;
                }

                System.out.println("\nEstágios do aluno:");
                for (int i = 0; i < aluno.getEstagios().size(); i++) {
                    System.out.println((i + 1) + ". " + aluno.getEstagios().get(i).getNome());
                }

                int opc = menuView.obterInt("Escolha o estágio (número): ");
                if (opc < 1 || opc > aluno.getEstagios().size()) {
                    menuView.exibirMensagem("Opção inválida.");
                    break;
                }

                EstagioModel estagio = aluno.getEstagios().get(opc - 1);

                double media = menuView.obterDouble("Digite a média do estágio (0-100): ");

                if (alunoCtrl.registrarAvaliacaoEstagio(aluno.getMatricula(), estagio, media)) {
                    menuView.exibirMensagem("Avaliação registrada com sucesso!");

                    Double m = estagio.obterMedia(aluno.getMatricula());
                    menuView.exibirMensagem("Média: " + m);
                    menuView.exibirMensagem(
                            estagio.aprovado(aluno.getMatricula())
                                    ? "Status: APROVADO"
                                    : "Status: REPROVADO"
                    );
                } else {
                    menuView.exibirMensagem("Erro ao registrar avaliação.");
                }

                break;
            }
            case 14: {
                System.out.println("\n=== COMPONENTES ACADÊMICOS ===");

                System.out.println("\nDisciplinas:");
                if (discipCtrl.listarDisciplinas().isEmpty()) {
                    System.out.println("Nenhuma disciplina cadastrada.");
                } else {
                    discipView.exibirListaDisciplinas(discipCtrl.listarDisciplinas());
                }

                System.out.println("\nEstágios:");
                if (estagCtrl.listarEstagios().isEmpty()) {
                    System.out.println("Nenhum estágio cadastrado.");
                } else {
                    estagView.exibirListaEstagios(estagCtrl.listarEstagios());
                }

                break;
            }

            case 15: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();

                if (alunos.isEmpty()) {
                    menuView.exibirMensagem("Nenhum aluno cadastrado.");
                    break;
                }

                AlunoModel alunoSelecionado = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado =
                        alunoCtrl.buscarAlunoPorMatricula(alunoSelecionado.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirMensagem("Aluno não encontrado.");
                    break;
                }

                alunoView.exibirSituacaoAcademica(alunoBuscado);
                break;
            }
                
            default:
                menuView.exibirMensagem("Opção inválida.");
        }
    }
}
